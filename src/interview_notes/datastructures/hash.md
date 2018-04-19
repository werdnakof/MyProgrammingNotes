# Hash
* **Goal**: O(1) time access to element **by key/hash value**
* Time O(1)
* Space O(N)
* Load factor = number of buckets filled / total number of buckets
* Hash function
    * maps a key/hashValue to a small index - `hashValue % arraySize`
    * the indices should be distributed evenly
    * if not evenly, need to handle collision

* Example hash function
    * String:
    
        ```
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash*31 + str.charAt(i);
        }
        ```
        
    * Object:
    
        * default hashCode java method returns hash value by **instance**,
        * Need to override hashCode for same hash value for same parameters (see below)

        ```
        public class Employee {
            int        employeeId;
            String     name;
            Department dept;
                    
            @Override
            public int hashCode() {
                int hash = 1;
                hash = hash * 17 + employeeId;
                hash = hash * 31 + name.hashCode();
                hash = hash * 13 + (dept == null ? 0 : dept.hashCode());
                return hash;
            }
            
            // or
            
            @Override
            public int hashCode() {
                return Objects.hash(employeeId, name, dept);
            }
        }
        ```

* **Collision Handling**: (_multiple hash value mod to the same index_)
    * Chaining:
        * Linked List 
        * Need to use `equals` method to match keys (keys of different hash value but same array index)
        
        Advantages:
        
        1. Simple to implement.
        2. Hash table never fills up
        3. Less sensitive to the hash function or load factors.
        4. Mostly used when it is unknown how many and how frequently keys may be inserted or deleted.
        
        Disadvantages:
        
        1) Cache performance of chaining is not good as keys are stored using linked list. 
           Open addressing provides better cache performance as everything is stored in same table.
        2) Wastage of Space (Some Parts of hash table are never used)
        3) If the chain becomes long, then search time O(n) in worst case.
        4) Extra space for links.
        
        Java implementation:
        
        ```
        public V put(K key, V value) {
            int hash = hash(key.hashCode());
            int i = indexFor(hash, table.length);
            // i is the index where we want to insert the new element
            addEntry(hash, key, value, i);
            return null;
        }
        
        void addEntry(int hash, K key, V value, int bucketIndex) {
            // take the entry that's already in that bucket
            Entry<K,V> e = table[bucketIndex];
            // and create a new one that points to the old one = linked list
            table[bucketIndex] = new Entry<>(hash, key, value, e);
        }
        ```
        