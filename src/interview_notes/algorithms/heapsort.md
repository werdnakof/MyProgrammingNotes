# Heapsort
* Uses a [heap](/src/interview_notes/datastructures/heap.md)
* Time O(N log N)
* Space O(1)
* Need to build a heap first! O(N log N)
    * create a new array (same size as input array)
    * put the actual value or the position of the value from input array, one by one
* remove from root (removeMin/Max) until empty