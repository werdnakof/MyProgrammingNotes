# Master's theorem

<img src="https://i2.wp.com/techieme.in/wp-content/uploads/recurrencetree.png?zoom=1.5&resize=640%2C382" width = 600>

* Goal: solve time complexity problem for recursions
* Facts:
    - height of recursion tree H: **log_b(N)**
    - branching factor **a**
    - no. leaves: **a^H** -> **a^(log_b(N))**, can be rewritten as **N^(log_b(a))**

* Time complexity of recursion: **T(n) = a\*T(n/b) + f(n)**
* a - no. branches to recur
* b - size reduction for each recursion
* 3 cases:

f(n) compare to n^(log_b a) | T(n)
:------------: | :-------------:
polynomially smaller | n<sup>log<sub>b</sub>a</sup>
polynomially equal | n<sup>(log<sub>b</sub>a)</sup> * log<sub>b</sub>n
polynomially larger | f(n)

For example: T(n) = 4T(n/2) + f(n)

f(n) | T(n)
:------------: | :-------------:
n | n<sup>2</sup>
n<sup>2</sup> | n<sup>2</sup>log<sub>2</sub>n
n<sup>3</sup> | n<sup>3</sup>