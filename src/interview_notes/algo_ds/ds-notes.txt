Data Structures:

ArrayLists
LinkedLists
Hash Tables
Stacks
Queues
Heaps
Binary Search Tree
Tries (Prefix Trees)
Graph

------------------------------------------------------------------------

ArrayLists
- amortized insertion time O(1)
- GET time O(1), by index only
- inserting N elements is O(N), on average each insertion takes O(1)
- but some takes O(N) due to increasing array size
- Space - O(N)


LinkedList
- GET O(N), by index only
- GET head/tail node O(1)
- Space - O(N)


HashTable
- get, put, hasKey
- amortized GET and INSERT time is O(1)
- pre-defined no. buckets
- Use hashkey from an Object to allocate to a bucket
- Then do a modulus on the hashkey to allocate to/retrieve from correct bucket
- Each bucket contains a linked list
- Compare equality to each linked node with the key to retrieve Object
- Load factor = number of buckets filled / total number of buckets
- worst time complexity is O(N) if collisions occur for all objects
- Space - O(N)


Stack
- pop, push, peek, isEmpty
- constant GET and INSERT time O(1)
- Order of insertion matters! FILO
- ArrayList implementation - keep track of last inserted index
- LinkedList implementation - keep track of last inserted/head node
- Space - O(N)


Queue
- add, remove, peek, isEmpty
- Constant GET and INSERT time O(1)
- Order of insertion matters FIFO
- LinkedList implementation - keep track of head AND tail node
- Space - O(N)


Heap (by priority)
- insert, findMin, extractMin/Max, findAny (depends if max or min heap)
- insert time - O(log N), bubbling up to the root
- findMin/Max - O(1), root is always min/max
- extractMin/Max - O(log N), bubble down to leaf
- findAny - O(N)
- Array Implementation - 2n+1 left, 2n+2 right
- TreeNode Implementation (i.e. left, right, value)
- Space - O(N)


BST
- insert, findAny
- insert - O(log N)
- findAny - O(log N)
- Array Implementation - 2n+1 left, 2n+2 right
- TreeNode Implementation (i.e. left, right, value)
- Space - O(N)


Tries (Prefix Trees)
- insert, findByPrefix, findExact
(for a prefix or String length of k)
- insert - O(k)
- findByPrefix - O(k)
- findExact - O(k)
- findByCharacterAtSpecificPosition - O(V + E) each vertex V represents a character, Edge E length of words - 1
  (E.g. find a word by wildcard ..a. in coat)
- TrieNode Implementation - array containing 26 TrieNode, isWord (boolean)

Graph
- properties - directed, acyclic/cyclic, weighted
- findNode, shortestPath
- Node implementation - array containing neighbour nodes, weight value
- Array implementation -