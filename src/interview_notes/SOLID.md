[Single Responsibility](https://ilclubdellesei.wordpress.com/2017/07/05/solid-principles-by-examples-single-responsability/)

The primary benefit the Single-Responsibility Principle gives you is high-cohesion, low-coupling code. Following SRP minimizes that one class will have to change for a given requirement, and maximizes the possibility that changing one class will not impact any other classes.

[open/closed](https://ilclubdellesei.wordpress.com/2017/07/10/solid-principles-by-examples-openclosed/)

The OCP makes our code more reusable and less coupled. This way we can write new code that with little impact in our existing codebase. SRP and OCP are closely related parents and their application makes our code more clean and mantainable.

[Liskov Substitution ](https://ilclubdellesei.wordpress.com/2017/08/17/solid-principles-by-examples-liskov-substitution-principle/)

TLTR: Model your classes based on behaviours not on properties; model your data based on properties and not on behaviours. If it behaves like a duck, it's certainly a bird.

The classic example is given by the following pseudo-code declaration (implementations omitted):

```
class Rectangle {
    int getHeight()
    void setHeight(int value)
    int getWidth()
    void setWidth(int value)
}

class Square : Rectangle { }

```

Now we have a problem although the interface matches. The reason is that we have violated invariants stemming from the mathematical definition of squares and rectangles. The way getters and setters work, a  `Rectangle`  should satisfy the following invariant:

```
void invariant(Rectangle r) {
    r.setHeight(200)
    r.setWidth(100)
    assert(r.getHeight() == 200 and r.getWidth() == 100)
}

```

However, this invariant  _must_  be violated by a correct implementation of  `Square`, therefore it is not a valid substitute of  `Rectangle`.

[Interface Segregation](https://ilclubdellesei.wordpress.com/2017/09/02/solid-principles-by-example-interface-segregation/)

The ISP guides us to create many _small_ interfaces with coherent functionalities instead of a few _big_ interfaces with lots of different methods. When we apply the ISP, class and their dependencies communicate using focussed interfaces, minimising dependencies. Smaller interfaces are easier to implement, improving flexibility and the possibility of reuse.

[Dependency Injection](https://ilclubdellesei.wordpress.com/2017/09/05/solid-principles-by-example-dependency-inversion/)

The word Inversion comes from the fact that both the high-level and the low-level depend on abstraction and this is the opposite of the classical approach where the high-level classes depend on the low-level classes.



> Written with [StackEdit](https://stackedit.io/).
<!--stackedit_data:
eyJoaXN0b3J5IjpbMjExMzU1ODA4NV19
-->