# Algorithms

# Dynamic Programming
* Brute Force
    * finds a solution by trying all possible answers and picking the best one.
* Greedy
    * builds up a solution by choosing the option that looks the best at every step.
* Bottom-up
    * Going bottom-up is a way to avoid recursion, 
    * saving the memory cost that recursion incurs when it builds up the call stack.
    * O(1) space O(n) time
* Memoization
    * ensures that a function doesn't run for the same inputs more than once by keeping a record

### Principle of Optimality (Bellman)
<img src="http://latex.codecogs.com/png.latex?\inline&space;\dpi{150}&space;V_k(x_k)&space;=&space;\begin{Bmatrix}&space;g(x_k,&space;u_k)&space;&plus;&space;V_{k&plus;1}\left&space;(&space;x_k&plus;1&space;\right&space;)&space;\end{Bmatrix}\&space;where&space;\&space;k&space;=&space;0,1,2,...N-1\\\\&space;\centerline{boundary\&space;condition&space;=&space;V_N(x_N)&space;=&space;g_N(x_N)}" title="V_k(x_k) = \begin{Bmatrix} g(x_k, u_k) + V_{k+1}\left ( x_k+1 \right ) \end{Bmatrix}\ where \ k = 0,1,2,...N-1\\\\ \centerline{boundary\ condition = V_N(x_N) = g_N(x_N)}" />

* start from end state e.g. destination or the last stage of adding coins i.e. 0 amount left
* choose the best decision at each stage e.g. choose coin 5, 3, 2 which minimise the coin count
* repeat until you reach the start

### [Problems](https://github.com/james727/Dynamic-Programming-Workshop)

**Easy**
* Climbing Stairs
    [leetcode](https://leetcode.com/problems/climbing-stairs/)
* House Robber
    [leetcode](https://leetcode.com/problems/house-robber/)
    [my-solution](/src/leetcode/dp/CoinChange.java)
* Stock selling
    [leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
* Max sum subarray
    [leetcode](https://leetcode.com/problems/maximum-subarray/)

**Medium**
* Coin Change
[leetcode](https://leetcode.com/problems/coin-change/)
[my-solution](/src/leetcode/dp/CoinChange.java)
* String edit distance
* Knapsack (1-0, fractional)
* Longest Common Sub Sequence

## Knapsack 

* Weights wts and values vals of N items, 
* put these items in a knapsack of capacity W 
* to get the maximum total value in the knapsack.

**0-1**
* Only take one of each

Consider all subsets (greedy)

* i.e. recursion, 2 branches (take or leave it)
* time complexity O(2^N)
* overlapping sub problems occurs

Use bottom up approach
* time complexity O(NW)

**Fractional**
* Can take fractional part of each item

Greedy
* Rank items by value/weight ratio: val / wt
* Thus: vi / wi ≥ vj / wj, for all i ≤ j
* Consider items in order of decreasing ratio
* Take as much of each item as possible
* Θ(n), if already sorted


## Sorts:
Merge Sort
Quick Sort
Selection Sort
Insertion Sort
Heap Sort

###

Search:

Binary Search

BFS

DFS:
Time: O(V + E) i.e. search through all vertices and all edges in each vertex
Space: O(V + E)
https://stackoverflow.com/questions/11468621/why-is-the-time-complexity-of-both-dfs-and-bfs-o-v-e
https://stackoverflow.com/questions/45662736/how-to-find-the-time-complexity-of-dfsbacktracking-algorithms

Tree Algos:
pre/in/post traversal

--------------------------------------------------------------------------

Concepts
Memory (Stack vs. Heap)
Bit Manipulation
Recursion
Dynamic Programming
Big O Time & Space