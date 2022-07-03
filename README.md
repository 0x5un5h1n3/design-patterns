# Design Patterns

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <Ul>
    <li>
      <a href="#what-is-a-design-pattern">Introduction<a>
      <ul>
        <li><a href="#gang-of-four-design-patterns">Gang of Four Design Patterns</a></li>
        <li><a href="#advantages-of-design-patterns">Advantages of Design Patterns</a></li>
      </ul>
    </li>
    <li>
      <a href="categories-of-design-patterns">Design Pattern Types<a>
      <ul>
        <li><a href="#creational-design-patterns">Creational Design Patterns</a></li>
        <li><a href="#structual-design-patterns">Structural Design Patterns</a></li>
        <li><a href="#behavioral-design-patterns">Behavioral Design Patterns</a></li>
      </ul>
    </li>
    <li>
      <a href="#11-singleton-design-pattern">Creational Design Patterns</a>
      <ul>
        <li><a href="#11-singleton-design-pattern">Singleton Design Pattern</a></li>
        <li><a href="#12-factory-design-pattern">Factory Design Pattern</a></li>
        <li><a href="#13-abstract-factory-design-pattern">Abstract Factory Design Pattern</a></li>
        <li><a href="#14-builder-design-pattern">Builder Design Pattern</a></li>
        <li><a href="#15-prototype-design-pattern">Prototype Design Pattern</a></li>
        </ul>
    </li>
    <li>
      <a href="#21-adapter-design-pattern">Structural Design Patterns</a>
      <ul>
        <li><a href="#21-adapter-design-pattern">Adapter Design Pattern</a></li>
        <li><a href="#22-composite-design-pattern">Composite Design Pattern</a></li>
        <li><a href="#23-proxy-design-pattern">Proxy Design Pattern</a></li>
        <li><a href="#24-flyweight-design-pattern">Flyweight Design Pattern</a></li>
        <li><a href="#25-facade-design-pattern">Facade Design Pattern</a></li>
        <li><a href="#26-bridge-design-pattern">Bridge Design Pattern</a></li>
        <li><a href="#27-decorator-design-pattern">Decorator Design Pattern</a></li>
        </ul>
    </li>
  </Ul>
</details>

## What is a Design Pattern

A design pattern is a general reusable solution to a commonly occurring problem in software design. It is a template for how to solve a problem that can be used in many different situations. Patterns are formalized best practices that the programmer can use to solve common problems when designing an application or system.

## Gang of Four Design Patterns

These are design patterns which were defined by four authors - Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides in their book Design Patterns: Elements of Reusable Object-Oriented Software. A lot has evolved in the field of software design since this book came out in 1994. This book and its patterns however make the foundation of the field of object oriented design patterns.

## Advantages of design patterns

They are reusable in multiple projects. They provide the solutions that help to define the system architecture. They capture the software engineering experiences. They provide transparency to the design of an application. They are well-proved and testified solutions since they have been built upon the knowledge and experience of expert software developers. Design patterns don't guarantee an absolute solution to a problem. They provide clarity to the system architecture and the possibility of building a better system.

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
| Proxy | Proxy is a surrogate or placeholder class for another class mostly done with an intention of intercepting access to the said class. |

 

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


## 1.1. Singleton Design Pattern

Properties

* Creational design pattern
* Only one instance of the class should exists
* Other classes should be able to get instance of Singleton class
* Used in logging, cache, session, drivers


Implementation

* Constructor should be private (to prevent creation of multiple objects outside)
* Public method for returning instance
* Instance type - private static


Initialization type

* Eager Initialization (As soon as we initialize the instance, it automatically create/declare at the same time)
* Lazy Initialization (Only create object when it finds a call, need)
* Thread safe Method Initialization
* Thread safe block Initialization


```java
class SingletonEager {
private static SingletonEager instance = new SingletonEager(); //Eager Initialization

private SingletonEager() {
} //Private Constructor

public static SingletonEager getInstance() {
    return instance;
}

}

class Singleton {private static Singleton instance;

private Singleton() {
}

public static Singleton getInstance() {
    if (instance == null) { //Lazy Initialization
        instance = new Singleton();
    }
    return instance;
}

}

class SingletonSynchronizedMethod { //Making the Method Synchronized

private static SingletonSynchronizedMethod instance;

private SingletonSynchronizedMethod() {
}

public static synchronized SingletonSynchronizedMethod getinstance() {
    if (instance == null) {
        instance = new SingletonSynchronizedMethod();
    }
    return instance;
}

}

class SingletonSynchronized {

private static SingletonSynchronized instance;

private SingletonSynchronized() {
}

public static SingletonSynchronized getInstance() { //Making the Block Synchronized
    if (instance == null) {
        synchronized (SingletonSynchronized.class) {
            if (instance == null) {
                instance = new SingletonSynchronized();
            }
        }
    }
    return instance;
}

}

public class SingletonExample {

public static void main(String[] args) {
    SingletonEager instance1 = SingletonEager.getInstance();
    System.out.println(instance1); //SingletonEager@6bf2d00e

    SingletonEager instance2 = SingletonEager.getInstance();
    System.out.println(instance2); //SingletonEager@6bf2d00e

    Singleton instance3 = Singleton.getInstance();
    System.out.println(instance3); //Singleton@Hexcode

    Singleton instance4 = Singleton.getInstance();
    System.out.println(instance4); //Singleton@Hexcode

  }
}
```

## 1.2. Factory Design Pattern

Properties

* Creational design pattern
* Used when we have multiple sub-classes of Super class and based on input we want to return one class instance
* It provides abstraction between implementation and client classes
* Remove the instantiation of client classes from client code


When to use?

* A class can't anticipate which kind of class of objects it must create
* A class uses its sub-classes to specify which objects it creates
* You want to localize the knowledge of which class gets created


There are several similar variations on the factory pattern to recognize

* The base class is abstract and the pattern must return a complete working class
* The base class contains default methods and is only sub-classed for cases where the default methods are insufficient
* Parameters are passed to the factory telling it which of several class types to return. In this case the classes may share the same method names but may do something quite different

  

Implementation

* Super class can be instance or abstract class or basic class
* Factory class has a static method which returns the instance of Sub-class based on input


Ex 1:

```java
abstract class Vehicle {

    public abstract int getWheel();

    @Override
    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle {

    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {

    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {

    public static Vehicle getInstance(String type, int wheel) {
        if (type == "car") {
            return new Car(wheel);
        } else if (type == "bike") {
            return new Bike(wheel);
        }
        return null;
    }
}

public class FactoryExample {

    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car); //Wheel: 4

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike); //Wheel: 2
    }
}
```


Ex 2:

```java
class Namer { // a class to take a string apart into two names

    protected String last; //store last name here
    protected String first; //store first name here

    public String getFirst() {
        return first; //return first name
    }

    public String getLast() {
        return last; //return last name
    }
}

class FirstFirst extends Namer {

    public FirstFirst(String s) {
        int i = s.lastIndexOf(" "); //find separating space
        if (i > 0) {
            first = s.substring(0, i).trim();  //left = first name
            last = s.substring(1 + 1).trim();  //right = last name
        } else {
            first = ""; //put all in last name
            last = s; //if no space
        }
    }
}

class LastFirst extends Namer { //split last, first

    public LastFirst(String s) {
        int i = s.indexOf(","); //find comma
        if (i > 0) {
            last = s.substring(0, i).trim(); //left = last name
            first = s.substring(i + 1).trim(); //right = first name
        } else {
            last = s; //put all in last name
            first = ""; //if no comma
        }
    }
}

class NameFactory {

    //returns an instance of LastFirst or FirstFirst
    //depending on whether a comma is found
    public Namer getNamer(String entry) {
        int i = entry.indexOf(","); //comma determines name order
        if (i > 0) {
            return new LastFirst(entry); //return one class
        } else {
            return new FirstFirst(entry);  //or the other
        }
    }
}

class UseClass {

    public static void main(String[] args) {
        NameFactory nfactory = new NameFactory();
        String sFirstName, sLastName;
        Namer namer;

        //send the text to the factory and get a class back
        namer = nfactory.getNamer("Hello, World");
        //comute the first and last names using the returned class
        sFirstName = namer.getFirst();
        sLastName = namer.getLast();

        System.out.println(sFirstName + " " + sLastName); //World Hello
    }
}
```


Ex 3:

```java
interface Mammal {

    void sound();
}

class cat implements Mammal {

    public void sound() {

        System.out.println("Meow Meow");
    }
}

class dog implements Mammal {

    public void sound() {
        System.out.println("Woof Woof");
    }
}

class MammalFactory {

    public static Mammal getMammalClass(String mammalType) {
        if (mammalType.equals("dog")) {
            return new dog();
        }
        if (mammalType.equals("cat")) {
            return new cat();
        }
        return null;
    }

}

class ProgramFactory {

    public static void main(String[] args) {
        Mammal m1 = MammalFactory.getMammalClass("dog");
        m1.sound(); //Woof Woof

        Mammal m2 = MammalFactory.getMammalClass("cat");
        m2.sound(); //Meow Meow

    }
}
```

