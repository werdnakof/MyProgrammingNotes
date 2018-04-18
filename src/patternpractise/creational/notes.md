https://github.com/kamranahmedse/design-patterns-for-humans

Factory:
    Factory generates an instance for client
    without exposing any instantiation logic to the client i.e. calling new ClassName(...)

    WTU

    When creating an object is not just a few assignments and involves some logic,
    it makes sense to put it in a dedicated factory instead of
    repeating the same code everywhere.


Factory Method:
    Delegate the instantiation logic to child classes
    via abstract inheritance method

    WTU

    When there is a generic processing in a class
    but the distinct implementation is decided by its sub-class.
    Each sub-class must implement a factory method to generate an instance of itself

Abstract Factory:

    A factory of factories;
    a factory that groups the individual but related/dependent factories together
    without specifying their concrete classes.

    WTU

    when there are interrelated dependencies with not-that-simple creation logic involved

Builder:

    Allows you to create different flavors of an object while avoiding constructor pollution.
    Useful when there could be several flavors of an object.
    Or when there are a lot of steps involved in creation of an object.

    WTU

    When there could be several flavors of an object and to avoid the constructor telescoping.
    The key difference from the factory pattern is that;
    factory pattern is to be used when the creation is a one step process
    while builder pattern is to be used when the creation is a multi step process.

Singleton:

    Ensures that only one object of a particular class is ever created.



