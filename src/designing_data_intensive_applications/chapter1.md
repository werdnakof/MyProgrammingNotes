---


---

<p>Typical modern applicatins involve:</p>
<ul>
<li>data-intensive instead of compute intensive</li>
<li>data store to data persistence</li>
<li>cache to remember expensive operation</li>
<li>data indexing for querying and filtering</li>
<li>asynchronous calls</li>
<li>periodical batch processing</li>
</ul>
<p>Factors to consider:</p>
<p><strong>Reliability</strong></p>
<ul>
<li>fulfill user requirements</li>
<li>tolerate user mistakes</li>
<li>good enough performance under extreme system load</li>
<li>prevents malicious access/abuse</li>
<li><code>"It is impossible to reduce the probability of a fault to zero; therefore it is usually best to design fault-tolerance mechanisms that prevent faults from causing failures."</code></li>
<li>Hardware faults
<ul>
<li><code>"Hard disks are reported as having a mean time to failure (MTTF) of about 10 to 50 years [5, 6]. Thus, on a storage cluster with 10,000 disks, we should expect on average one disk to die per day."</code></li>
<li><code>Single-server system requires planned downtime if you need to reboot the machine (to apply operating system security patches, for example), whereas a system that can tolerate 1+ machine failure can be patched one node at a time, without downtime of the entire system</code></li>
<li>Unlikely for all hardware to go down at the same time</li>
</ul>
</li>
<li>Software errors
<ul>
<li>Systematic error within system’s dependencies e.g. OS, services, shared resources, etc. (<em>Dependent softwares which are not built or maintained by system owners</em>)</li>
<li>Increase monitoring, thresholds on SLAs, health checks</li>
</ul>
</li>
<li>Human errors
<ul>
<li>Good separation of concern, decouple when necessary</li>
<li>Implement tests at all levels: end to end, unit, integ</li>
<li>Enable fast rollbacks for error recovery</li>
<li>Enable performance and error metrics, logs</li>
</ul>
</li>
</ul>
<p><strong>Scalability</strong><br>
*<br>
<strong>Maintainability</strong></p>
<h1 id="storage-and-retrieval">3. Storage and Retrieval</h1>
<h2 id="data-structures">Data structures</h2>
<ul>
<li>Indexes are used to speed up <code>reads</code>, otherwise it’s O(N) complexity to scan through entire data store</li>
<li>Indexes are additional metadata computed from stored data, which incur additional overhead - indexes need to be updated for every <code>write</code></li>
<li>Indexes are usually deferred to be calculated by application developers, based their knowledge of the typical query pattern.</li>
</ul>
<h3 id="hash-indexes-and-segments">Hash Indexes and Segments</h3>
<ul>
<li>In-memory hash map where every key is mapped to a byte offset in a file</li>
<li><img src="https://i.imgur.com/WCSL958.png" alt="enter image description here"></li>
<li>For writes,
<ol>
<li>Appending to end of file with key-value pair</li>
<li>Update hashmap with byte offet for the key</li>
</ol>
</li>
<li>For reads, simply read the byte offset for the key</li>
<li>Append only file writes is faster than random writes</li>
<li>Appending data to file will lead to eventually running out of disk space, <strong>Compaction</strong> is performed remove duplicates.</li>
<li>The file is also broken down into <strong>Segments</strong> once it reaches a certain size. Multiple hashmaps are created for each segment.</li>
<li><img src="https://i.imgur.com/mqPpjZG.png" alt="enter image description here"></li>
<li>Segments are never modified after they have been written (create and append to new segments only)</li>
<li>Compaction and merging are carried out in background thread. Once the new segment file is created, reads are served from it and old segment files are deleted.</li>
<li><strong>File format</strong>: Binary file, each data entry is encoded with 1.) length of string in bytes and 2.) raw string in bytes</li>
<li><strong>Deleting records</strong>: tombstone is appended for the key, merging segments will discard key if the latest append is a tombstone.</li>
<li><strong>Crash recovery</strong>: backup hashmaps in disk</li>
<li><strong>Partially written records</strong>: use checksums</li>
<li><strong>Concurrency Control</strong>: single write thread, multiple read threads, append only segment files</li>
<li><strong>Limitations</strong> - inmemory hashmay is limited + range queries is not possible</li>
</ul>
<h3 id="sstables-and-lsm-trees">SSTables and LSM-Trees</h3>
<p>(Inspired by Google’s Bigtable paper)</p>
<ul>
<li><strong>Resolving range queries limitation</strong>
<ul>
<li>Adding ordering on top of “hash indexes and segemnts”</li>
<li><img src="https://i.imgur.com/XqhVljA.png" alt="enter image description here"></li>
<li>Reading the input files side by side, look at the first key in each file, copy the lowest key (according to the sort order) to the output file, and repeat.</li>
<li>All the values in one input segment must be more recent than all the values in the other segment. When multiple segments contain the same key, keep the value from the most recent segment and discard the values in older segments.</li>
</ul>
</li>
<li><strong>Resolving in-memory hashmap limitation</strong>
<ul>
<li>no longer keeps indexes of all the keys in memory</li>
<li>Use a sorted data structure e.g. AVL or red-black trees to create a <strong>sparse index</strong> instead of a hashmap</li>
<li><img src="https://i.imgur.com/hEM4jpJ.png" alt="enter image description here"></li>
<li>if key doesn’t exist in sparse index, find the closest keys and scan through SSTable (segment file)</li>
<li>Since read requests need to scan over several key-value pairs in the requested range. Group the key-value pairs and compress them into a block, this saves disk space and reduct I/O bandwidth use</li>
</ul>
</li>
</ul>
<h4 id="constucting-and-maintaining-sstables-simple-string-table">Constucting and maintaining SSTables (Simple String Table)</h4>
<ul>
<li>When a write comes in, add it to an in-memory balanced tree data structure - sometimes called a memtable.</li>
<li>When the memtable gets bigger than some threshold—typically a few megabytes —write it out to disk as an SSTable file. The new SSTable file becomes the most recent segment of the database. While the SSTable is being written out to disk, writes can continue to a new memtable instance.</li>
<li>In order to serve a read request, first try to find the key in the memtable, then in the most recent on-disk segment, then in the next-older segment, etc.</li>
<li>From time to time, run a merging and compaction process in the background to combine segment files and to discard overwritten or deleted values.</li>
</ul>
<h4 id="performance-optimzation">Performance optimzation</h4>
<ul>
<li>LSM-tree algorithm can be slow when looking up keys that do not exist in the database: check the memtable, then the segments all the way back to the oldest (possibly having to read from disk for each one) before you can be sure that the key does not exist.</li>
<li>In order to optimize this kind of access, storage engines often use additional Bloom filters  - a memory-efficient data structure for approximating the contents of a set. It can tell you if a key does not appear in the database, saving unnecessary disk reads for nonexistent keys</li>
<li></li>
</ul>
<blockquote>
<p>Written with <a href="https://stackedit.io/">StackEdit</a>.</p>
</blockquote>

