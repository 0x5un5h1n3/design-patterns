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


## 1.3. Abstract Factory Design Pattern

How does it work

* The Abstract Factory pattern is one level of abstraction higher than the factory pattern. This returns one of several related classes each of which can return several different objects on request. In other words, the Abstract Factory is a factory object that returns one of several factories
* One classic application of the abstract factory is the case where your system needs to support multiple “look-and-feel“ user interfaces, such as Windows, Motif, or Macintosh
  * You tell factory that you want your program to look like Windows and it returns a GUI factory which returns Windows-like objects
  * When you request specific objects such as buttons, check boxes and windows, the GUI factory returns Windows instances of these visual interface components.


Ex:

```java
abstract class Garden {

    public abstract Plant getCenter();

    public abstract Plant getBorder();

    public abstract Plant getShade();

}

class Plant {

    String name;

    public Plant(String pname) {
        name = pname; //save name
    }

    public String getName() {
        return name;
    }
}

class VegieGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Broccoli");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Corn");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Peas");
    }
}

class FruitGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Blackberries");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Guava");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Kivi");
    }
}

class SpiceGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Black Pepper");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Garlic");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Ginger");
    }
}

class GardenMaker {

    //Abstract Facrory which return one of 3 gardens
    private Garden gd;

    public Garden getGarden(String gtype) {
        gd = new VegieGarden(); //default
        if (gtype.equals("SpiceGarden")) {
            gd = new SpiceGarden();
        }
        if (gtype.equals("FruitGarden")) {
            gd = new FruitGarden();
        }
        return gd;
    }
}

class Test {

    public static void main(String[] args) {
        GardenMaker gm = new GardenMaker();
        String name = gm.getGarden("FruitGarden").getShade().getName();
        System.out.println(name); //Blackberries
    }
}
```

## 1.4. Builder Design Pattern

Properties

* Creational design pattern
* Used when we have too many arguments to send in Constructor and it's hard to maintain the order
* When we don't want to send all parameters in Object initialization (Generally we send optional parameters as Null)


Implementation

* A "Static nested class", which contains all arguments of outer class
* As per naming convention, if class name is "Vehicle", builder class should be "VehicleBuilder"
* Builder class have a public constructor with all required parameters
* Builder class should have methods for optional parameters. Method will return the Builder object
* A "Build()" method that will return the Final object
* The main class "Vehicle" has private constructor so to create instance only via Builder class
* The main class "Vehicle" has only getters

How does it work

* The Builder Pattern separates the construction of a complex object from its representation so that the same construction process can create different representations
* The client creates the Director object and configures it with the desired object
* Director notifies the builder whenever a part of the product should be built
* Builder handles requests from the director and adds parts to the product
* The client retrieves the product from the builder


Applicability of Builder Pattern

* Use the Builder pattern when;
  * The algorithm for creating a complex object should be independent of the parts that make up the object and how they are assembled
  * The construction process must allow different representations for the object that is constructed


Consequences of Builder Pattern

* A builder lets you vary the internal representation of the product it builds. It also hides the details of how the product is assembled
* Each specific builder is independent of the others and of the rest of the others and of the rest of the program. This improves molecularity and makes the addition of other builders relatively simple
* Because each builder constructs the final product step-by step, depending on the data, you have more control over each final product that a Builder constructs
* A Builder pattern is somewhat like an Abstract Factory pattern in that both return classes made up of a number of methods and objects
* The main difference is that while the Abstract factory returns a family of related classes, the Builder constructs a complex object step by step depending on the data presented to it


Ex 1:

```java
class Laptop {

    private String os;
    private int ram;
    private String processor;
    private String brand;

    public Laptop(String os, int ram, String processor, String brand) {
        this.os = os;
        this.processor = processor;
        this.ram = ram;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "OS: " + os + ", RAM: "+ ram + "GB, " + "Processor: " + processor + ", Brand: " + brand;
    }

}

class Builder {

    private String os;
    private int ram;
    private String processor;
    private String brand;

    public Builder setOs(String os) {
        this.os = os;
        return this;
    }

    public Builder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public Builder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public Builder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Laptop getLaptop() {
        return new Laptop(os, ram, processor, brand);
    }
}

class LapBuilder {

    public static void main(String[] args) {
        Laptop lap0 = new Laptop("Win10", 8, "i7", "Dell"); //can't be customized
        Laptop lap1 = new Builder().setOs("Win10").setBrand("Asus").setProcessor("i7").setRam(16).getLaptop();
        Laptop lap2 = new Builder().setBrand("Asus").setProcessor("i7").setRam(16).getLaptop(); //Can be customized
        
        System.out.println(lap0); //OS: Win10, RAM: 8GB, Processor: i7, Brand: Dell
        System.out.println(lap1); //OS: Win10, RAM: 16GB, Processor: i7, Brand: Asus
        System.out.println(lap2); //OS: null, RAM: 16GB, Processor: i7, Brand: Asus
    }
}
```


Ex 2:

```java
class Vehicle {

    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {

        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderExample {

    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        System.out.println(car.getEngine()); //1500cc
        System.out.println(car.getWheel()); //4
        System.out.println(car.getAirbags()); //4

        System.out.println(bike.getEngine()); //250cc
        System.out.println(bike.getWheel()); //2
        System.out.println(bike.getAirbags()); //0
    }
}
```
