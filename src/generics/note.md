### Object vs Generic?

There are some cases where you want a container to hold multiple types of oObjects, but typically you only put one type of object into a container.
[See ObjectHolder](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/ObjectHolder.java)

One of the primary motivations for generics is to specify what type of object a container holds, and to have that specification backed up by the compiler.
[See GenericHolder](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/GenericHolder.java)

GenericHolder can only hold one type of object at runtime once
it has been initialized.

### Tuple
With generics, it’s possible for a method to return a group of
elements, which can only be read but not put new ones in.
This ensures compile-time type safety.

See TwoTuple, 'final' prevent users from reassigning the fields

### Generic Interfaces

Generics also work with interfaces. [See CoffeeGenerator](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/CoffeeGenerator.java)

### No Primitives for Generics!

### Generic Methods ###

Class methods can also parameterize.
The class itself may or may not be generic—this is independent of whether you
have a generic method.

With class generics, they have to be specified when class is initialized,
but not with methods

See GenericMethods

### Leveraging type argument inference

[See GenericContainerGenerator](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/GenericContainerGenerator.java)

[Remember PECS: "Producer Extends, Consumer Super"](https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java)

### A generic method to use with Generators

See [BasicGenerator](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/BasicGenerator.java) and [BasicGeneratorDemo](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/BasicGeneratorDemo.java)

### Set utility - an example

See [ContainerMethodDifferences](https://github.com/werdnakof/MyProgrammingNotes/blob/master/src/generics/ContainerMethodDifferences.java)

### Anonymous inner classes

See Customer and Teller

### Store - complex model using generics, inner class and generator

See Store

### There’s no information about generic parameter types available inside generic code. ###

See LostInformation

### generic type parameter erases to its first bound

See Manipulator:
The bound <T extends HasF> says that T must be of type HasF or something derived
from HasF. If this is true, then it is safe to call f( ) on obj.

Generics are only useful when you want to use type
parameters that are more "generic" than a specific type (and all its subtypes)

That is, when you want code to work across multiple classes.

As a result, the type parameters and their application in useful generic code
will usually be more complex than simple class replacement

### Migration compatibility ###

In an erasure-based implementation, generic types are treated as second class types that
cannot be used in some important contexts.

The generic types are present only during static type checking,
after which every generic type in the program is erased by replacing it with a
non-generic upper bound

For example, type annotations such as List<T> are erased to
List, and ordinary type variables are erased to Object unless a bound is specified.

The primary justification for erasure is the transition process from non generified code to
generified code, and to incorporate generics into the language without breaking existing
libraries. Erasure allows existing nongeneric client code to continue to be used without
change, until clients are ready to rewrite code for generics. This is a noble motivation,
because it doesn’t suddenly break all existing code.

### erasure's removes type information...to a certain extent ###

See ArrayMaker:
Even though kind is stored as Class<T>, erasure means that it is actually just being stored
as a Class, with no parameter!!!

Array.newInstance( ) doesn’t actually have the type information that’s implied in kind
So the Array only contains null instances

See ListMaker:
Even though the compiler is unable to know anything about T inside ListMaker,
it can still ensure—at compile time—that what you put into result is of type T,
so that it agrees with ArrayList<T>.

Thus, even though erasure removes the information about the actual type inside
a method or class, the compiler can still ensure internal consistency in the way that
the type is used within the method or class.

erasure removes type information in the body of a method, what matters at run time
is the boundaries: the points where objects enter and leave a method

erasure loses the ability to perform certain operations in generic code i.e.
Anything that requires the knowledge of the exact type at run time won’t work
However you can introduce a class type field in class to 'remember' type
See ClassTypeCapture

### Generic Array ###

First we cannot init an array with a generic i.e. new T[10] doesn't work

The problem is that arrays keep track of their actual type, and that type is established at the
point of creation of the array. So even though gia has been cast to a Generic < Integer >[],
that information only exists at compile time (and without the @SuppressWarnings
annotation, you’d get a warning for that cast). At run time, it’s still an array of Object, and

See GenericArray:
As before, we can’t say T[] array = new T[sz], so we create an array of objects and cast it.
The rep( ) method returns a T[], which in main( ) should be an Integer[] for gai, but if
you call it and try to capture the result as an Integer [] reference, you get a
ClassCastException, again because the actual runtime type is Object[]

See GenericArray2:
Because of erasure, the runtime type of the array can only be Object[]. If we immediately
cast it to T[], then at compile time the actual type of the array is lost, and the compiler may
miss out on some potential error checks. Because of this, it’s better to use an Object[] inside
the collection, and add a cast to T when you use an array element.

Note: there’s no way to subvert the type of the underlying array, which can only be Object[].

Solution? Add a type! See GenericArrayWithTypeToken

### Bounds ###

See BasicBounds, InheritBounds

### Wildcards ###

1. Covariance

See CovariantArrays:
Unlike arrays, generics do not have built-in covariance. This is
because arrays are completely defined in the language and can thus have both compile-time
and runtime checks built in, but with generics, the compiler and runtime system cannot
know what you want to do with your types and what the rules should be.

See GenericsAndCovariance:
After upcast, the list can’t even add an Apple that you just said would hold Apples.
Yes, but the compiler doesn’t know that.

A List<? extends Fruit> could legally point to a List<Orange>. Once you do this
kind of "upcast," you lose the ability to pass anything in, even an Object.

On the other hand, if you call a method that returns Fruit, that’s safe because you know that
anything in the List must at least be of type Fruit, so the compiler allows it.

See FruitHolder:
you can also upcast an generic class to an 'extended generic' class

2. Contravariance

See GenericWriting for usage of 'super':
'super' can be used as follows:
'<? super ClassType>', '<? super T>',

See GenericReading:
You can see when reading from generic classes, there is a difference between:
- a class with generic pre-defined i.e. Reader class
- a class without generic pre-defined i.e. GenericReading class
- a class with 'extended' generic pre-defined i.e. CovariantReader class

See UnboundedWildcards1, UnboundedWildcards2
Indeed, since a generic argument erases to its first bound,
List<?> would seem to be equivalent to List<Object>, and List is effectively
List<Object> as well—except neither of those statements is exactly true.

List actually means "a raw List that holds any Object type," whereas List<?> means
"a non-raw List of some specific type, but we just don’t know what that type is."

See WildCards:
A good example of generic constraints

### Capture conversion ###
See CaptureConversion

### Issues ###
P. 515

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTMyMDEzMjgyNSwxNTI0NTIxMDc3XX0=
-->