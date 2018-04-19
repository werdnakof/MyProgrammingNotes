A - Ask good questions
B - Don't use buzzwords
C - Clear and organized thinking
D - Drive discussions with 80-20 rule

Things to consider
Features
API
Availability
Latency
Scalability
Durability
Class Diagram
Security and Privacy
Cost-effective

Concepts to know

Vertical vs horizontal scaling

CAP theorem

CAP is Consistency, Availability, and Partition tolerance. Basically you can pick 2 of those but you can't do all 3.

ACID focuses on Consistency and availability.

BASE focuses on Partition tolerance and availability and throws consistency out the window.

ACID vs BASE

ACID
Atomic - All operations in a transaction succeed or every operation is rolled back.
Consistent - On the completion of a transaction, the database is structurally sound.
Isolated - Transactions do not contend with one another. Contentious access to data is moderated by the database so that transactions appear to run sequentially.
Durable - The results of applying a transaction are permanent, even in the presence of failures.

Base
Basic Availability - The database appears to work most of the time.
Soft-state - Stores don’t have to be write-consistent, nor do different replicas have to be mutually consistent all the time.
Eventual consistency - Stores exhibit consistency at some later point (e.g., lazily at read time).

Partitioning/Sharding 
Consistent Hashing
Optimistic vs pessimistic locking
Strong vs eventual consistency
RelationalDB vs NoSQL
Types of NoSQL
     Key value
     Wide column
     Document-based
     Graph-based
Caching
Data center/racks/hosts
CPU/memory/Hard drives/Network bandwidth
Random vs sequential read/writes to disk


Load Balancer

CDNs & Edges

Bloom filters and Count-Min sketch

Paxos 

Leader election

Design patterns and Object-oriented design

Virtual machines and containers

Pub-sub architecture 

MapReduce

Multithreading, locks, synchronization, CAS(compare and set)
