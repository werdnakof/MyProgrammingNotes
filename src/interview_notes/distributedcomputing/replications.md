# Partition

### Network Partition

* **Single-copy consistency**: goal to maintain a single copy of partition which represents the true state of data

* **Network Partition Tolerance** for systems that enforce **single-copy consistency** requires that 
  only **one** partition remains active during a network partition, 
  since it is NOT possible to prevent divergence during a network partition

* Failure of a network link to one or several nodes can occur.

* The nodes themselves continue to stay active AND may even be able to receive requests from clients

* Not possible to distinguish between a failed remote node and the node being unreachable.

* **Divergence**: if a network partition occurs but no nodes fail, 
  then the system is divided into two simultaneously-active partitions, opposite of our goal.
  
* **Partition tolerant consensus algorithms** rely on a **majority vote** 
    - Requiring a majority of nodes - rather than all of the nodes
    - to agree on updates allows a minority of the nodes to be down, or slow, or unreachable. 
    - As long as (N/2 + 1) of N nodes (i.e. odd number of nodes) are up and accessible, the system can continue to operate
    
* Minority partitions will stop processing operations to prevent divergence during a network partition

* **Distinct roles** for each node i.e. a single fixed leader node, follower nodes

    * Consensus algorithms for replication generally opt for having distinct roles
      
    * Distinct roles doesn't preclude failure of the leader, recover from failure by reassigning the roles after a failure (e.g. via a leader election phase)
    
    * Both Paxos and Raft make use of distinct node roles.

* **Epoch**: a period (term) of normal operation in the whole system

    ![](http://book.mixu.net/distsys/images/epoch.png)
    
    * each epoch only has one node as the designated leader
    
    * after a successful election, the same leader coordinates until the end of the epoch
    
    * some elections may fail, causing the epoch to end immediately
    
    * act as a logical clock, allowing other nodes to identify when an outdated node starts communicating
    
    * nodes that were partitioned or out of operation will have a **smaller** epoch number than the current one, and their commands are ignored
    
    
* All nodes start as followers; one node is elected to be a leader at the start

* During normal operation, the leader maintains a heartbeat which allows the followers to detect if the leader fails or becomes partitioned

* When a node detects that a leader has become non-responsive, 
  it switches to an intermediate state (called "candidate" in Raft) 
  where it increments the term/epoch value by one, 
  initiates a leader election and competes to become the new leader.
  
* In order to be elected a leader, a node must receive a majority of the votes. 
    - One way to assign votes is to simply assign them on a first-come-first-served basis
    - Adding a random amount of waiting time between attempts at getting elected will reduce the number of nodes that are simultaneously attempting to get elected.
    


- 

