Adapter (adapt an unrelated class to another)

    - Adapter pattern lets you wrap an incompatible object in an adapter
      to make it compatible with another class.

    - Certain objects weren't created and designed the same way
      e.g. lion or dog.

    - But if they need to behave the same way, we can create an adapter on
      top of existing incompatible classes.

    - e.g. a LionHunter hunts Lion, but we want it to hunt Dog as well.
      hence a DogAdapter extends from Lion and adapt Dog's behaviour to Lion

Bridge (a class composes of other classes)

    - Bridge pattern is about preferring composition over inheritance.

    - E.g. Shirt class, Black class -> BlackShirt class composes of Shirt and Black in its constructor

    - The core concept is abstracted away from multiple implementations, and the behaviors
      of the implementations are only decided at runtime.

    - In other words, it simply uses both Strategy and Template

Facade (hide away a complex class with simpler functionality)

    - Provides a simplified interface to a class with complex API.

    - In other words, abstract away complex methods of a class by introducing a wrapper
      class which offers simpler API

    - i.e. like decorator pattern but decorator has to be simpler

    - Structurally speaking, it makes clients life easier by not knowing the complex API

Composite (array of classes of same interface)

    - Compose individual object instances uniformly.

    - E.g. A Company can be the composite class,
      containing/composing of different Employee implementation instances via a collection

    - Client will know the Composite class will provide a collection of Employee

Flyweight (composite pattern with cache)

    - Minimize memory usage or computational expenses
      by sharing as many similar object instances as possible.

    - i.e. if a class has been requested and initialized, cache it!
      and return same instance if requested again

    - E.g. a TeaMaker makes many many types of Tea e.g. KaraTea, BreakfastTea, etc
      if the Tea classes are init everytime -> uses a lot of memory, especially if their
      behaviour stays the same...so just cache them in TeaMaker!

    - It's similar to Composite but uses HashMap

Decorator (add functionality to an interface instance without knowing its derivation)

    - Dynamically change the behavior of an object at RUN TIME via composition

    - By wrapping them in an object of a decorator class which adds additional functionality

    - https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm

    - E.g. There are simple Shape classes e.g. Circle, Square,
      and we wish to add 'color' behaviour to the shapes.
      ColorDecorator abstract class is used, which implements Shape.
      RedDecorator implements ColorDecorator, and its constructor takes an existing Shape instance
      Then RedDecorator has the same behaviour of a Shape, but specifically to a specific Shape instance

    - Structurally speaking, it adds coloring logic on the base Shape class itself via
      composition at run time.

Proxy (add functionality to a specific derivation of an interface)

    - Using the proxy pattern, a class represents functionality of a specific class at compile time

    - proxy knows the specific type of derived class so he can create it himself or gets passed it,

    - represents the behaviour of the derived class with additional logic

    - Contrary to a decorator, decorator class gets passed a derived class instance at run time
      i.e. decorator doesn't know what derived class it is being passed.

    - In other words, both decorator and proxy adds functionality, but proxy has the type information
      of the derived class but decorator doesn't

    https://github.com/kamranahmedse/design-patterns-for-humans#-proxy





