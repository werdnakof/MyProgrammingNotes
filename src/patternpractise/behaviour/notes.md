### Behaviour Patterns

#### Mediator

* Adds a 'central controller' to control the interaction between multiply objects.

* Reduce the coupling between the classes communicating with each other.

* Because now they don't need to have the knowledge of each other's implementation.

#### Template

* Defines the skeleton of how a certain algorithm could be performed,

* But defers the implementation of those steps to the children classes.

* In other words: using an abstract class

Chain of Responsibility

    Builds a chain of objects i.e. linked list
    Request enters from one end,
    and keeps going from object to object till it finds a suitable handler.

Iterator

    Presents a way to access the elements of an object
    without exposing the underlying presentation.

State

    Lets you change the behavior of a class when the state/internal attribute changes.

Memento

    Provides the ability to restore an object to its previous state (undo via rollback).

Observer (Uses Observable class)

    Defines a dependency between objects, the dependent's behaviour now depend on another object

    so that whenever an object changes its state, all its dependents are notified.

    similar to state pattern, but across objects

Command

    - Encapsulate actions-information as objects.

    - The key idea behind this is to decouple client's methods from receiver.

    - a chef can cook chinese and italian food,
      so Chef class can methods for each type cuisine, and returns the cuisine to client
      but with more cuisine, more methods have to be added.
      so let's decouple cuisine information to classes e.g. CookChinese, CookItalian, etc

    - It is simply message passing, message as object, the object will hold various attributes
      containing information of the message e.g. salt quantity, meat type, etc

Strategy

    - Switching the strategy based upon the situation at run time

    - Unlike Command pattern, strategy actually implements the logic instead of passing a message

    - e.g. CookChinese, CookItalian, etc These classes will take in the ingredient information and
      perform the action.

Visitor

    - provides a level of indirection when client calls an action from receiver

    - the actual implementation of the behaviour is not defined in the derived class

    - but instead the derived class receive a Strategy class, and then the derived class
      passes itself into the Strategy class

    - Strategy class performs based on derived type information

    - Similar to Strategy pattern, but the strategy changes behaviour based of the derived type

    - Using chef example above: the strategy CookChinese and CookItalian might differs based on
      experience of the chef i.e. JuniorChef, SeniorChef