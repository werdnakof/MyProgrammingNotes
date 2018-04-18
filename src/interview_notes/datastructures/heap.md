# Binary Heap
* a complete binary tree

                10                      10
             /      \               /       \  
           20        100          15         30  
          /                      /  \        /  \
        30                     40    50    100   40
  
* O(log N) height
* Array implementation: 
    * left 2 * k
    * right 2 *k + 1
    * parent k /2
* For a min heap, each node is **greater than or equal** to its parent, 
  smallest at the root.
  
* **getMin / getMax** - O(1)
    * get array[0] 
* **Insert** - O(log N) 
    * expand array size if full
    * place new value at the end
    * bubble up if required
* **Delete Min** - O(log N)
    * remove array[0]
    * replace root with last element in array i.e. bottom, right-most leaf
    * compare to child and bubble down if required

Actual Code:

* Insert
```
public void insert(Comparable x) {
	if(isFull()) doubleArraySize();

	//Insert a new item to the end of the array
	int pos = ++size;

	for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2)
		heap[pos] = heap[pos/2];

	heap[pos] = x;
}
```