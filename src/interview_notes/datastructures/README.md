# Data Structures

* ArrayLists
* LinkedLists
* Hash
* Stacks
* Queues
* [Heap](/src/interview_notes/datastructures/heap.md)
* Binary Search Tree
* Tries (Prefix Trees)
* Graph


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