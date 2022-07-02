# Design Patterns


## What is a Design Pattern

A design pattern is a general reusable solution to a commonly occurring problem in software design. It is a template for how to solve a problem that can be used in many different situations. Patterns are formalized best practices that the programmer can use to solve common problems when designing an application or system.

## Gang of Four Design Patterns

These are design patterns which were defined by four authors - Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides in their book Design Patterns: Elements of Reusable Object-Oriented Software. A lot has evolved in the field of software design since this book came out in 1994. This book and its patterns however make the foundation of the field of object oriented design patterns.

## Advantages of design patterns

They are reusable in multiple projects. They provide the solutions that help to define the system architecture. They capture the software engineering experiences. They provide transparency to the design of an application. They are well-proved and testified solutions since they have been built upon the knowledge and experience of expert software developers. Design patterns don?t guarantee an absolute solution to a problem. They provide clarity to the system architecture and the possibility of building a better system.

## Categories of GOF Design Patterns

Gang Of Four design patterns are grouped into 3 categories:

1. Creational Design Patterns: Creational patterns deal with object creation i.e they look at ways to solve design issues arising out of creation of objects.
2. Structural Design Patterns: Structural patterns ease the design by identifying a simple way to realize relationships between entities.
3. Behavioral Design Patterns: Behavioral patterns identify common communication patterns between objects and realize these patterns.


## Creational Design Patterns

| **Pattern** | Description |
|----|----|
| Abstract Factory *(Garden Factory)* | Provides an interface for creating families of related or dependent objects without specifying their concrete classes. |
| Factory Method *(Namer and Minimal Factory)* | Deals with the problem of creating related objects without specifying the exact class of object that will be created. |
| Singleton *(More click one window)* | This pattern ensures a class has only one instance and provides a global(app level) point of access to it. |
| Prototype *(Clone Bookshop)* | Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. |
| Builder *(LapBuilder)* | Separates the construction of a complex object from its representation, thus enabling the same construction process to create various representations. |


## Structural Design Patterns

| **Pattern** | Description |
|----|----|
| Adapter| This pattern lets classes work together that could not otherwise because of incompatible interfaces. |
| Bridge | This pattern decouples an abstraction from its implementation so that they become loosely coupled. |
| Composite | This pattern allows aggregating objects such that individual objects and composition of objects can be treated uniformly. |
| Decorator | This pattern attaches additional responsibilities to an object dynamically while keeping the interface same |
| Facade | This pattern provides a simpler interface to a larger and more complex system such as a class library or a complex API. |
| Flyweight | This pattern minimizes memory usage by sharing common data between objects. |
| Proxy | Proxy is a surrogate or placeholder class for another class mostly done with an intention of intercepting access to the said class.Design Patterns Handy Quick |

 

## Behavioral Design Patterns

| **Pattern** | Description |
|----|----|
| Chain of Responsibility | This pattern defines a chain of processing objects in a chain in such a way that the incoming request is processed by each processing objects in sequence |
| Command | In this pattern an object is used to represent and encapsulate all the information needed to call a method at a later time. |
| Interpreter | This pattern defines a representation for a given language's grammar along with an interpreter that uses the representation to interpret sentences in the language. |
| Iterator | This pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. |
| Mediator | In this pattern communication between objects is encapsulated with a mediator object. Objects no longer communicate directly with each other, but instead communicate through the mediator. |
| Memento | Mementos capture and externalize an object's internal state allowing the object to be restored to this state later. |
| Observer | An observable object called "Subject" maintains a list of objects called "Observers". Subject notifies the observers of any state changes. |
| State | State pattern allows an object to alter its behavior when its internal state changes. |
| Strategy | This pattern defines a family of algorithms, encapsulate each one, and make them interchangeable. |
| Template Method | Pattern defines steps of an algorithm as methods in an interface while allowing subclasses to override some steps in the overall algorithm. |
| Visitor | Pattern separates an algorithm from the object structure on which it operates, which provides the ability to add new operations to existing object structures without modifying those structures |
