# Priority Queue
* **Goal**: operate on the **root** value only e.g. retrieve the min/max value and nothing else
* Insertion: O(log N)
* DeleteMin/Max: O(log N)
* RetrieveMin/Max: O(1)
* Uses a [heap](/src/interview_notes/datastructures/heap.md)
* Differs from a sorted array! **doesn't maintain elements in order**
* Have to remove the elements to return them in order, see [heapsort](/src/interview_notes/algorithms/heapsort.md)