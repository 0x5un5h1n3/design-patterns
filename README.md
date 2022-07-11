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


## 1.5. Prototype Design Pattern

Properties

* Creational design pattern
* Used when you want to avoid multiple Object creation of same instance; instead you copy the object to new object and then we can modify as per our need


Implementation

* Object which we're copying should provide copying feature by implementing Cloneable interface
* We can override clone() method to implement as per our need


Why use Prototype

* If you want to create the same object of a class more than one time like if you want to create an object that help of database. (It will take more time if you create two object and load the same database values to both the objects)
* A prototype pattern is used when creating an instance of a class is very time-consuming or complex is some way. Then, rather than creating more instances, you make copies of the original instance and modify them as appropriate
* The Prototype pattern specifies the kinds of object to create using a prototypical instance, and create new objects by copying this prototype


Consequences

* You can add and remove classes at run time by cloning them as needed
* You can revise the internal data representation of a class at run time based on program conditions
* you can also specify new object at run time without creating a proliferation of classes and inheritance structures


Difficulties

* One difficulty in implementing the Prototype pattern in Java is that if the classes already exist, you may not be able to change them to add the required clone or deep Clone methods. The deep clone method cab be particularly difficult if all of the class objects contained in a class cannot be declared to implement the Serializable interface
* Classes that have circular references to other classes cannot really be cloned
* The idea of having prototype classes to copy implies that you have sufficient access to the data or methods in these classes to change them after cloning. This may require adding data access methods to these prototype classes so that you can modify the data once you have cloned the class


Cloning in Java

* You can make a copy of any Java object using the clone method
  * MyClass ob2 = (MyClass) obj1.clone();
* The clone method always returns an object of type Object,. You must cast it to the actual type of the object you are cloning, There are three other significant restrictions on the clone method
  * It is a protected method and can only be called from within the same class or the module that contains that class
  * You can only clone object which are declared to implement the Cloneable interface
  * Objects that cannot be cloned throw the CloneNotSupported Exception


Implementing Cloneable

* This suggests packaging the actual clone method inside the class where it can access the real clone method


```java
class MyClass implements Cloneable {

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
```



Ex:  Making a Clone Object

```java
class MyData implements Cloneable { //Cloneable is a Marker Interface

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates

    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return "Name = " + name;
    }
}

class CloneObject {

    public static void main(String[] args) {
        try {
            MyData a = new MyData();
            MyData a1 = (MyData) a.clone();

            a.setName("Hello");
            a1.setName("World");

            System.out.println(a); //Name = Hello
            System.out.println(a1); //Name = World
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}
```


Ex 1:

```java
import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable {

    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Range Rover");
        vehicleList.add("BMW");
        vehicleList.add("Audi");
        vehicleList.add("Honda");
        vehicleList.add("Toyota");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }
        return new Vehicle(tempList);
    }
}

class PrototypePatternExample {

    public static void main(String[] args) throws CloneNotSupportedException {

        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Range Rover");

        System.out.println(a.getVehicleList()); // [Range Rover, BMW, Audi, Honda, Toyota]
        System.out.println(list); // [Range Rover, BMW, Audi, Honda, Toyota, Range Rover]

        b.getVehicleList().remove("Audi");
        System.out.println(list); //[Range Rover, BMW, Honda, Toyota, Range Rover]
    }
}
```


Procedure

* Let's write a simple program that reads data from a database and then clones the resulting object
* In our this program, BookShop, we just read these data from a array list, but the original data were derived from a large database as we discussed above
  * We create a class called Book that holds Book id and Book name
  * We create a class called BookShop that maintains a ArrayList of the Books we read in from the database
  * We clone this class and add data differently in the new class
  * Again we clone the data because creating a new class instance would be much slower, and we want to keep the data in both forms


```java
import java.util.ArrayList;
import java.util.List;

class Book {

    private int b_id;
    private String b_name;

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setB_Name(String b_Name) {
        this.b_name = b_Name;
    }

    public int getB_id() {
        return b_id;
    }

    public String getB_name() {
        return b_name;
    }

    @Override
    public String toString() {
        return "Book_Id: " + b_id + ", " + "Book Name: " + b_name;
    }
}

class BookShop implements Cloneable {

    private String ShopName;
    private List<Book> books = new ArrayList<>();

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBooks() {
        for (int x = 1; x <= 10; x++) {
            Book b = new Book();
            b.setB_id(x);
            b.setB_Name("Story " + x);
            getBooks().add(b);
        }
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop = new BookShop();

        for (Book b : this.getBooks()) {
            shop.getBooks().add(b);
        }
        return shop;
    }

    @Override
    public String toString() {
        return "Shop Name: " + ShopName + ", " + "Books: " + books;
    }

}

class PrototypeClass {

    public static void main(String[] args) {
        try {
            BookShop shop1 = new BookShop();
            shop1.setShopName("My Shop");
            shop1.addBooks();

            BookShop shop2 = (BookShop) shop1.clone();
            shop1.getBooks().remove(0);

            System.out.println(shop1);// Shop Name: My Shop, Books: [Book_Id: 2, Book Name: Story 2, Book_Id: 3, Book Name: Story 3, Book_Id: 4, Book Name: Story 4, Book_Id: 5, Book Name: Story 5, Book_Id: 6, Book Name: Story 6, Book_Id: 7, Book Name: Story 7, Book_Id: 8, Book Name: Story 8, Book_Id: 9, Book Name: Story 9, Book_Id: 10, Book Name: Story 10]
            System.out.println(shop2); //Shop Name: null, Books: [Book_Id: 1, Book Name: Story 1, Book_Id: 2, Book Name: Story 2, Book_Id: 3, Book Name: Story 3, Book_Id: 4, Book Name: Story 4, Book_Id: 5, Book Name: Story 5, Book_Id: 6, Book Name: Story 6, Book_Id: 7, Book Name: Story 7, Book_Id: 8, Book Name: Story 8, Book_Id: 9, Book Name: Story 9, Book_Id: 10, Book Name: Story 10]

        } catch (CloneNotSupportedException e) {
        }
    }
}
```


## 2.1. Adapter Design Pattern

Properties

* Structural design pattern
* When objects offering same features, but has different interface. i.e. Charging Adapter, USB to Ethernet Adapter
* It allows existing classes to be used with others with other without modifying their source code
  * i.e. WebDriver Adapter


Implementation

* Interface - WebDriver
* Interface Implementation - ChromeDriver, WebDriverAdapter
* Adapter - ieDriver
* Adaptee - ieDriver
* Client - AdapterPatternTest


Definition and Applicability

* Adapters are used to enable objects with different interfaces to communicate with each other
* The Adapter pattern is used to convert the programming interface of one class into that of another
* We use adapters whenever we want unrelated classes to work together in a single program
* Adapters come in two flavors
  * Object Adapters
  * Class Adapters
* The concept of an adapter is this pretty simple; we write a class that has the desired interface and then make it communicate with the class that has a different interface
* Adapters in Java can be implemented in two ways
  * By Inheritance
  * By Object Composition


Object Adapters

* Structural Object adapters use a compositional technique to adapt one interface to another
* The adapter inherits the target interface that the client expects to see, while it holds an instance of the adaptee
* When the client calls the request() method on its target object (the adapter), the request is translated into the corresponding specific request on the adaptee
* Object adapters enable the client and the adaptee to be completely decoupled from each other.
* Only the adapter knows about both of them


Consequences of the Adapter Pattern

* Class and object adapters have different trade-offs
* A Class Adapter;
  * Adapt Adaptee to Target by committing to a concrete Adapter class
  * Lets Adapter override some of Adapter override some of Adaptee's behavior, since Adapter is a subclass of Adaptee;
  * introduce only one object and no additional indirection is needed to get to the Adaptee
* An Object Adapter
  * lets a single adapter work with many Adaptees - that is, the Adaptee itself and all of its and all of its subclasses (if any). The Adapter can also add functinality to all Adaptee at once
  * Makes it harder to override Adapter behavior. It will require sub-classing Adaptee and making Adapter refer to the subclass rather than the Adapter itself

Ex 1:

```java
class SquarePeg {
    
    public void insert(String str) {
        System.out.println("SquarePeg insert(): " + str); // SquarePeg insert(): Insert square peg...
    }
}

class RoundPeg {
    
    public void insertIntoHole(String msg) {
        System.out.println("RoundPeg inserIntoHole(): " + msg); //oundPeg inserIntoHole(): Insering round peg...
    }
}

class RoundToSquarePegAdapter extends SquarePeg {
    
    private RoundPeg roundPeg;
    
    public RoundToSquarePegAdapter(RoundPeg peg) {
        this.roundPeg = peg;
    }
    
    @Override
    public void insert(String str) {
        roundPeg.insertIntoHole(str);
    }
}

class ObjectAdapter {

    public static void main(String[] args) {
        RoundPeg roundPeg = new RoundPeg();
        SquarePeg squarePeg = new SquarePeg();
        
        squarePeg.insert("Insert square peg...");
        
        RoundToSquarePegAdapter adapter = new RoundToSquarePegAdapter(roundPeg);
        adapter.insert("Insering round peg...");
    }
}
```


Ex 2:

```java
interface HDMICable {

    void plug(String txt);
}

class MyLaptop {

    private HDMICable myHdmiCable;
    
    public void plugTheCable(String plug) {
        myHdmiCable.plug(plug);
    }
    
    public HDMICable getMyCable() {
        return myHdmiCable;
    }
    
    public void setMyCable(HDMICable hdmi) {
        this.myHdmiCable = hdmi;
    }
}

class USBCable {

    public void plugUSBCable(String txt) {
        System.out.println(txt); //USB Cable Connected!
    }
}

class HDMIAdapter implements HDMICable {

    USBCable usb = new USBCable();
    
    @Override
    public void plug(String txt) {
        usb.plugUSBCable("USB " + txt);
    }
}
```


Ex 3:

```java
interface WebDriver {

    public void getElement();
    public void selectElement();

}

class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get Element from ChromeDriver"); //Get Element from ChromeDriver
    }

    @Override
    public void selectElement() {
        System.out.println("Select Element from ChromeDriver"); //Select Element from ChromeDriver
    }
}

class IEDriver {

    public void findElement() {
        System.out.println("Find Element from IEDriver"); //Find Element from IEDriver
    }

    public void clickElement() {
        System.out.println("Click Element from IEDriver"); //Click Element from IEDriver
    }
}

class WebDriverAdapter implements WebDriver {

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        this.ieDriver = ieDriver;
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement(); //Click Element from IEDriver
    }
}
```


Ex 4:

```java
//The IRoundPeg interface
interface IRoundPeg {

    public void insertIntoHole(String msg);
}

//The ISquarePeg interface
interface ISquarePeg {

    public void insert(String str);
}

//The RoundPeg interface
class RoundPeg implements IRoundPeg {

    @Override
    public void insertIntoHole(String msg) {
        System.out.println("RoundPeg insertIntoHole(): " + msg);
    }
}

//The SquarePeg class
class SquarePeg implements ISquarePeg {

    @Override
    public void insert(String str) {
        System.out.println("SquarePeg insert(): " + str);
    }
}

//The PegAdapter class. This is the two-way adapter class
//Abstraction applies here. Only the interfaces can implement more than one classes
class PegAdapter implements ISquarePeg, IRoundPeg {

    private RoundPeg roundPeg;
    private SquarePeg squarePeg;

    public PegAdapter(RoundPeg peg) {
        this.roundPeg = peg;
    }

    public PegAdapter(SquarePeg peg) {
        this.squarePeg = peg;
    }

    @Override
    public void insert(String str) {
        roundPeg.insertIntoHole(str);
    }

    @Override
    public void insertIntoHole(String msg) {
        squarePeg.insert(msg);
    }

}

//Test program for Pegs
class TestPeg {

    public static void main(String[] args) {
        //Create some pegs
        RoundPeg roundPeg = new RoundPeg();
        SquarePeg squarePeg = new SquarePeg();

        //Do an insert using the square peg
        ISquarePeg roundToSquare = new PegAdapter(roundPeg);
        roundToSquare.insert("Inserting round peg..."); //RoundPeg insertIntoHole(): Inserting round peg...

        //Do an inser using the round peg
        roundPeg.insertIntoHole("Inserting round peg..."); //RoundPeg insertIntoHole(): Inserting round peg...

        //Create a two-way adapter and do an insert with it
        IRoundPeg squareToRound = new PegAdapter(squarePeg);
        squareToRound.insertIntoHole("Inserting square peg..."); // SquarePeg insert(): Inserting square peg...
    }
}
```


## 2.2. Composite Design Pattern

Properties

* Structural design pattern
* Leaf Object is the sub unit of main Composite Object
* Composite lets client treat individual objects(Leaf) and Compositions of objects(Composite) uniformly
* 4 Participants
  * Components
  * Leaf
  * Composite
  * Client
* If object is Leaf node, request is handled directly
* If object is Composite, it forwards the request to child, so some operation and combine operations


Implementation

* Component - Account Class, which contains common method
* Leaf - DepositAccount, SavingsAccount
* Composite -  CompositeAccount
* Client - Client Class
* Getting the balance of all account for a person


Definition and Applicability

* The Composite Design pattern allows a client object to treat both single components identically
* Composite patterns are often used to represent recursive data structures. The recursive nature of the Composite structure naturally gives way to recursive code to process that structure
* Use the Composite pattern when;
* you want to represent part-whole hierarchies of objects
* You want to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite uniformly


Consequences

* The Composite pattern allows you to define a class hierarchy of simple objects and more complex composite objects so that they appear to be the client program
* Because of the simplicity, the client can be that much simpler, since nodes and leaves are handled in the same way
* The Composite pattern also makes it easy for you to add new kinds of components to your collection, as long as they support a similar programming interface
* The composite is essentially a singly-linked tree, in which any of the objects may themselves be additional composites


Ex 1:

```java
import java.util.ArrayList;
import java.util.List;

abstract class Account {

    public abstract float getBalance();
}

class DepositAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class SavingsAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }

}

class CompositeAccount extends Account {

    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public float getBalance() {
        totalBalance = 0;
        for (Account f : accountList) {
            totalBalance = totalBalance + f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        accountList.add(acc);
    }
}

class Client {

    public static void main(String[] args) {
        CompositeAccount component = new CompositeAccount();
        component.addAccount(new DepositAccount("DA001", 100));
        component.addAccount(new DepositAccount("DA002", 150));
        component.addAccount(new SavingsAccount("SA001", 200));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance: " + totalBalance);

    }
}
```


Ex 2:

```java
import java.util.ArrayList;
import java.util.List;

interface Componant {

    void ShowPrice();
}

class Leaf implements Componant {

    private int price;
    private String name;

    public Leaf(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public void ShowPrice() {
        System.out.println("Name: " + name + " - " + "Price: " + price);
    }

}

class Composite implements Componant {

    private String name;
    List<Componant> componants = new ArrayList<>();

    public Composite(String name) {
        super();
        this.name = name;
    }

    void addComponant(Componant comp) {
        componants.add(comp);
    }

    @Override
    public void ShowPrice() {
        System.out.println(name);

        for (Componant c : componants) {
            c.ShowPrice();
        }
    }
}

class TestComposite {

    public static void main(String[] args) {
        Composite mb = new Composite("MotherBoad Intel G41");
        Leaf cpu = new Leaf("CPU i7", 25000);
        Leaf ram = new Leaf("RAM 4 GB", 4000);
        Leaf vga = new Leaf("VGA 2GB", 15000);
        mb.addComponant(cpu);
        mb.addComponant(ram);
        mb.addComponant(vga);

        Composite systemUnit = new Composite("System unit");
        Leaf hdd = new Leaf("HDD 1TB", 8000);
        Leaf power = new Leaf("Power Unit", 15000);
        systemUnit.addComponant(hdd);
        systemUnit.addComponant(power);
        systemUnit.addComponant(mb); // Add the Composite MotherBoard to the System Unit

        Composite peripheral = new Composite("Peripheral Devices");
        Leaf moniter = new Leaf("Moniter 17inch", 15000);
        Leaf mouse = new Leaf("Mouse", 2000);
        Leaf keyBoard = new Leaf("key Board", 4500);
        peripheral.addComponant(moniter);
        peripheral.addComponant(mouse);
        peripheral.addComponant(keyBoard);

        Composite Computer = new Composite("Computer");
        Computer.addComponant(systemUnit);
        Computer.addComponant(peripheral);

        peripheral.ShowPrice();
//        Peripheral Devices
//        Name: Moniter 17inch - Price: 15000
//        Name: Mouse - Price: 2000
//        Name: key Board - Price: 4500

        Computer.ShowPrice();
//        Computer
//        System unit
//        Name: HDD 1TB - Price: 8000
//        Name: Power Unit - Price: 15000
//        MotherBoad Intel G41
//        Name: CPU i7 - Price: 25000
//        Name: RAM 4 GB - Price: 4000
//        Name: VGA 2GB - Price: 15000
//        Peripheral Devices
//        Name: Moniter 17inch - Price: 15000
//        Name: Mouse - Price: 2000
//        Name: key Board - Price: 4500

    }
}
```


## 2.3. Proxy Design Pattern

Properties

* Structural design pattern
* Used when you want to control access
  * In databases, you would want to control the "delete" query available only for certain users like admin


Implementation

* In general, we've class which is executing interface executor method, which is executing all commands
* To control this, we add a Proxy class which implements the same interface and write the conditions for "Admin" user before proceeding to actual executor

Definition

* In proxy pattern, a class represents functionality of another class
* This type of design pattern comes under structural pattern
* Provide a class which limit access to another class
* We use this pattern will limit access to another class
* We use this pattern for security reason
* Situation like an object is intensive to create
* An object that access from a remote location
* In Proxy pattern, we create object having original object to interface its functionality to outer world


Ex 1:

```java
import java.util.Scanner;

interface AbstractBank {

    void getMoney();

    void depositMoney();

    void getBalance();
}

class Bank implements AbstractBank {

    public int accNo = 0;
    double balance = 0;
    String name = "";

    public Bank(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
    }

    @Override
    public void getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter GetMoney Id as 'g' or DepositMoney Id as 'd'");
        String tranceType = sc.next();
        if (tranceType.equalsIgnoreCase("0")) {
            System.out.println("Enter the amount : ");
            balance -= Double.parseDouble(sc.next());
            System.out.println("Transaction Completed: Your Balance is : " + balance);
        } else {
            System.out.println("Enter Deposit amount : ");
            balance += Double.parseDouble(sc.next());
            System.out.println("Transaction Completed: Your Balance is : " + balance);
        }
    }

    @Override
    public void depositMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class BankATM implements AbstractBank {

    Bank myBank;
    public int accNo = 0;
    double balance = 0;
    String name = "";

    public BankATM(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
        check();
    }

    void check() {
        if (accNo == 001 & name.equalsIgnoreCase("user")) {
            myBank = new Bank(accNo, name);
        }
    }

    @Override
    public void getMoney() {
        myBank.getMoney();
    }

    @Override
    public void depositMoney() {
        myBank.depositMoney();
    }

    @Override
    public void getBalance() {
        myBank.depositMoney();
    }
}

class client{
    public static void main(String[] args) {
        AbstractBank bank = new BankATM(001, "user");
        bank.getMoney();
    }
}
```


Ex 2:

```javascript
class ImageClass{
    private String fileName;
    
    public ImageClass(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    
    void display(){
        System.out.println("Display my Image :"+ fileName);
    }
    
    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

class Client{
    /*
    As part of its implementation, the Client class creates an instance of the ImageClass and directly accesses its services.
    In Other words, for a client object, the way of accessing a Image object is fairly straightforward
    */
    public static void main(String[] args) {
        ImageClass aa = new ImageClass("/Proxy/com.png");
        aa.display();
    }
}

//Loading /Proxy/com.png
//Display my Image :/Proxy/com.png
```


Ex 3:

```java
interface Image {

//Create an Imag interface
    void display();
}

class RealImage implements Image {

//create concrete classes implementing the same interface
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}

class ProxyPatternDemo {

//Use the ProxyImage to get object of RealImage class when required
    public static void main(String[] args) {
        Image image = new ProxyImage("/Proxy/com.png");
        //image will be loaded from the disk
        image.display();
        System.out.println("");
        //image will not be loaded from the disk
        image.display();
    }
}

//Loading /Proxy/com.png
//Displaying /Proxy/com.png

//Displaying /Proxy/com.png
```


Ex: 4:

```java
interface DatabaseExecuter {

    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Executing Query: " + query);
    }
}

class DatabaseExecuteProxy implements DatabaseExecuter {

    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuteProxy(String name, String passwd) {
        if (name == "Admin" && passwd == "Admin@123") {
            ifAdmin = true;
            dbExecuter = new DatabaseExecuterImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin users");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

class ProxyPatternExample {

    public static void main(String[] args) {
//        DatabaseExecuter nonAdminExecuter = new DatabaseExecuteProxy("NonAdmin", "Admin123");
//        nonAdminExecuter.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuteProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE"); // Executing Query: DELETE
    }
}
```


## 2.4. Flyweight Design Pattern

Properties

* Structural design pattern
* This pattern provides ways to decrease object count this improving application required object structure
* Used when we need to create many objects of a class, to reduce creation of objects
* Flyweight pattern is used when we need to create a large number of similar objects (like 100000 obj)
* One important feature of flyweight object is that they are immutable (This means that they cannot be modified once they have been constructed)


Definition

* Flyweight design pattern is used when there is to create large number of objects of amount of similar nature
* The larger number of objects consume a large amount of memory and the fly weight design pattern provides a solution for reducing the load on the memory by sharing objects
* Flyweight design pattern is primarily used to reduce the number of objects created, to decrease memory foot print and increase performance flyweight pattern try to re-use already exist similar kind of object by storing them and create  the new object when no matching object is found


State of Flyweight design pattern

* There are two state of fly weight design pattern
  * Intrinsic
    * Things that are Constant and are stored in memory
    * (Same for an Object)
  * Extrinsic
    * Things that are not-constant and need to be calculated on the fly, and therefore not stored in the memory
    * (Different for an object)


Implementation

* Interface - Which contain common method : Employee
* Object - Individual class : Developer, Tester
* Intrinsic Property (Developer : Fix the issue, Tester : test the issue)z
* Extrinsic Property - Skills
* We use Factory to use return Object - EmployeeFactory
* Client - Client class


Ex 1:

```java
//A common interface for all players
import java.util.HashMap;
import java.util.Random;

interface Player {

    public void assignWeapon(String weapon);

    public void mission();
}

//Gurilla must have weapon and mission
class Guerilla implements Player {

    //Intrinsic Attribute
    private final String TASK;
    //Extrinsic Attribute
    private String weapon;

    public Guerilla() {
        TASK = "Shoot To Soldier";
    }

    @Override
    public void assignWeapon(String weapon) {
        //Assign a weapon
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        //work on the mission
        System.out.println("Guerilla with weapon " + weapon + " | " + "task is " + TASK);
    }
}
//Soldier must have weapon and mission

class Soldier implements Player {

    //Intrinsic Attribute
    private final String TASK;
    //Extrinisic String weapon;
    private String weapon;

    public Soldier() {
        TASK = "Shoot to Guerilla";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Soldier with weapon " + weapon + " | " + "task is " + TASK);
    }
}

class PlayerFactory {

    /*HashMap stores the reference to the object of Guerilla (TS) or Soldier (CT)
     */
    private static HashMap<String, Player> hm = new HashMap<String, Player>();

    //Method ro get a player
    public static Player getPlayer(String type) {
        Player p = null;
        /*If an object for Guerilla or Soldier has already been created simply return its reference
         */

        if (hm.containsKey(type)) {
            p = hm.get(type);
        } else {
            // creates an object of Guerilla/Soldier
            switch (type) {
                case "Guerilla":
                    System.out.println("Guerilla Created");
                    p = new Guerilla();
                    break;

                case "Soldier":
                    System.out.println("Soldier Created");
                    p = new Soldier();
                    break;

                default:
                    System.out.println("Unreachable code!");
            }
            //Code created insert it into the HashMap
            hm.put(type, p);
        }
        return p;
    }
}

// Driver class
class BattleField {
    //All payer types and weapons (used by getRandPlayerType() and getRandWeapon())

    private static String[] playerType = {"Guerilla", "Soldier"};
    private static String[] weapons = {"308_SniperRifle", "M16", "M1921", "QBZ-95", "RPG"};

//Driver Code
    public static void main(String[] args) {
        //Assume that we have a total of 10 players in the game
        for (int i = 0; i < 10; i++) {
            //getPlayer() is called simply using the class name since the method is a static one

            Player p = PlayerFactory.getPlayer(getRandPlayerType());

            //Assign a weapon chosen randomly uniformly from the weapon array
            p.assignWeapon(getRandWeapon());

            //Send this player on a mission
            p.mission();
        }
    }
    //Utility methods to get a random player type and weapon

    public static String getRandPlayerType() {
        Random r = new Random();

        //Will return an integer between(0, 2)
        int randInt = r.nextInt(playerType.length);
        System.out.println("@@@@@" + randInt);

        //return the player stored at index 'randInt'
        return playerType[randInt];
    }

    public static String getRandWeapon() {
        Random r = new Random();
        int randInt = r.nextInt(weapons.length);
        System.out.println("@@@@@" + randInt);
        //Return the weapon stored at index 'randInt'
        return weapons[randInt];
    }

}
// Random results

/*
@@@@@0
Guerilla Created
@@@@@3
Guerilla with weapon QBZ-95 | task is Shoot To Soldier
@@@@@0
@@@@@1
Guerilla with weapon M16 | task is Shoot To Soldier
@@@@@0
@@@@@2
Guerilla with weapon M1921 | task is Shoot To Soldier
@@@@@1
Soldier Created
@@@@@1
Soldier with weapon M16 | task is Shoot to Guerilla
@@@@@0
@@@@@4
Guerilla with weapon RPG | task is Shoot To Soldier
@@@@@0
@@@@@0
Guerilla with weapon 308_SniperRifle | task is Shoot To Soldier
@@@@@1
@@@@@2
Soldier with weapon M1921 | task is Shoot to Guerilla
@@@@@1
@@@@@2
Soldier with weapon M1921 | task is Shoot to Guerilla
@@@@@1
@@@@@2
Soldier with weapon M1921 | task is Shoot to Guerilla
@@@@@1
@@@@@0
Soldier with weapon 308_SniperRifle | task is Shoot to Guerilla
*/
```


Ex 2:

```java
import java.util.HashMap;
import java.util.Random;

interface Employee {

    public void assignSkill(String skill);

    public void task();
}

class Developer implements Employee {

    private final String JOB;
    private String skill;

    public Developer() {
        JOB = "Fixing the Issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}

class Tester implements Employee {

    private final String JOB;
    private String skill;

    public Tester() {
        JOB = "Testing the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + skill + " with Job: " + JOB);
    }
}

class EmployeeFactory {

    private static HashMap<String, Employee> m = new HashMap<String, Employee>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                default:
                    System.out.println("No such Employee");
            }
            m.put(type, p);
        }
        return p;
    }
}

class Engineering {

    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "Python", "C++", ".NET"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            e.assignSkill(getRandSkill());
            e.task();
        }
    }

    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);

        return employeeType[randInt];
    }

    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);

        return skills[randInt];
    }
}

//Random Results

/*
Tester Created
No such Employee
Tester with skill: Java with Job: Testing the issue
Developer Created
Developer with skill: .NET with Job: Fixing the Issue
Developer with skill: .NET with Job: Fixing the Issue
Tester with skill: C++ with Job: Testing the issue
Tester with skill: Python with Job: Testing the issue
Developer with skill: Python with Job: Fixing the Issue
Developer with skill: C++ with Job: Fixing the Issue
Tester with skill: Java with Job: Testing the issue
Developer with skill: C++ with Job: Fixing the Issue
Tester with skill: C++ with Job: Testing the issue
*/
```


## 2.5. Facade Design Pattern

Properties

* Structural design pattern
* Used when there're multiple interfaces of similar kinds of jobs, then we add a Facade interface, which provide better interface to these interfaces and clients
* It basically help in routing to related interface (i.e. Drivers, Databases)
* So, as the name suggests, it means the face of the building. The people walking past the road can only see this glass face of the building. They do not know anything about it, the wiring, the pipes and other complexities. It hides all the complexities of the building and displays a friendly face
* Example:
  * In Java, the interface JDBC
    * This can be called a facade because, we as users or clients create connection using the "java.sql.Connection" interface, the implementation of which we are not concerned about. The implementation is left to vendor of driver
  * Startup of a Computer
    * When a computer starts up, involves the work of cpu, memory, hard drive, etc. To make it easy to use for users, we can add a facade which wrap the complexity of the task, and provide one of the task, and provide one simple interface instead
  * Same goes for the Facade design pattern. It hides the complexities of the system and provides an interface to the client from where the client can access the system


Implementation

* We'll implement a Facade helper class, which will route to method related to specific class based input


Ex 1:

```java
interface abstractMenu{
    String getMenu();
}

class MexicanFoodMenu implements abstractMenu{
    @Override
    public String getMenu(){
        return "---------------"+"\n"
                + "MEXICAN FOOD MENU"+"\n"
                + "MEXICAN FOOD 1"+"\n"
                + "MEXICAN FOOD 2"+"\n"
                + "MEXICAN FOOD 3"+"\n"
                + "MEXICAN FOOD 4"+"\n"
                + "Total : $150";
    }
}

class ChineseFoodMenu implements abstractMenu{
  
    @Override
    public String getMenu() {
        return "---------------"+"\n"
                + "CHINESE FOOD MENU"+"\n"
                + "CHINESE FOOD 1"+"\n"
                + "CHINESE FOOD 2"+"\n"
                + "CHINESE FOOD 3"+"\n"
                + "Total : $250";
    }
}

class WaiterFacade{
    private MexicanFoodMenu mexican;
    private ChineseFoodMenu chinese;

public WaiterFacade(){
    mexican = new MexicanFoodMenu();
    chinese = new ChineseFoodMenu();
}    
    void getChineseMenu(){
        System.out.println(chinese.getMenu());
    }
    
    void getMexicanMenu(){
        System.out.println(mexican.getMenu());
    }
}

class Client{
    public static void main(String[] args) {
        WaiterFacade w = new WaiterFacade();
        w.getMexicanMenu();
        w.getChineseMenu();
    }
}

/*
---------------
MEXICAN FOOD MENU
MEXICAN FOOD 1
MEXICAN FOOD 2
MEXICAN FOOD 3
MEXICAN FOOD 4
Total : $150
---------------
CHINESE FOOD MENU
CHINESE FOOD 1
CHINESE FOOD 2
CHINESE FOOD 3
Total : $250
*/
```


Ex 2:

```java
import java.sql.Driver;

class Firefox {

    public static Driver getFirefoxDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HUML report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT report for Firefox Driver");
    }
}

class Chrome {

    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

class WebExplorerHelperFacade {

    public static void generateReports(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

class FacadePatternExample {

    public static void main(String[] args) {
        String test = "CheckElementPresent";
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}

/*
Generating HUML report for Firefox Driver
Generating JUNIT report for Firefox Driver
Generating HTML Report for Chrome Driver
Generating JUNIT Report for Chrome Driver
Generating JUNIT report for Firefox Driver
Generating JUNIT Report for Chrome Driver
Generating HTML Report for Chrome Driver
Generating JUNIT Report for Chrome Driver
Generating JUNIT Report for Chrome Driver
*/
```


## 2.6. Bridge Design Pattern

Properties

* Structural design pattern
* Bridge pattern is used to separate the interface(abstraction) of class from its implementation, so that either can be varied separately
  * The intent of the Adapter pattern is to make one or more classes' interface look the same as that of a particular class
  * The Bridge pattern is designed to separate a class' interface from its implementation, so that you can vary or replace the implementation without changing the client code
* There are 2 parts in Bridge design pattern
  * Abstraction
  * Implementation
* Used when we've hierarchies in both interface as well as implementations and we want to hide the implementation from client
* It decouple abstraction from it implementation
* Generally we've TV remote, which works differently for Sony and Philips TV, but we can have different Remote as well, i.e. oldRemote and newRemote, which have different methods for each TV
  * i.e. TV and Remote implementation


Design mechanism that encapsulates an implementation class inside of an interface class

* The Bridge pattern allows the Abstraction and the Implementation to be developed independently and the client code can access only the Abstraction part without being concerned about the implementation part
* The abstraction is an interface or abstract class and implementer is also an interface or abstract class
* The abstraction contains a reference to the implementer. Children of the abstraction are referred as Refined Abstractions, and children of the implementer are Concrete implementer(s). Since we can change the reference to the implementer in the abstraction, we are able to change the abstraction's implementer at run-time.
* Changes to the implementer do not affect client code
* It increases the loose coupling between class abstraction and its implementation


Elements of Bridge Design Pattern

* Abstraction
  * Core of the bridge design pattern and defines the crux. Contains reference to the implementer
* Refined Abstraction
  * Extends the abstraction takes the finer detail one level below. Hides the finer elements from implementer(s)
* Implementer
  * It defines the interface implementation classes. This interface does not need to correspond directly to the abstraction interface and can be very different. Abstraction imp provides an implementation in terms of operations provided by implementer interface
* Concrete Implementation
  * Implements the above implementer by providing concrete implementation


Implementation

* Class hierarchy : TV, SonyTV, PhilipsTV
* Interface hierarchy : Remote, OldRemote, NewRemote
* Client : Client class


Ex 1:

```java
abstract class TV {

    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on();

    abstract void off();
}

class Sony extends TV {

    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    @Override
    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

class Philips extends TV {

    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    @Override
    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

interface Remote {

    public void on();

    public void off();
}

class OldRemote implements Remote {

    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

class NewRemote implements Remote {

    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }

}

class Client {

    public static void main(String[] args) {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();

    }
}

/*
Sony TV ON: ON with Old Remote
Sony TV OFF: OFF with Old Remote

Sony TV ON: ON with New Remote
Sony TV OFF: OFF with New Remote

Philips TV ON: ON with Old Remote
Philips TV OFF: OFF with Old Remote

Philips TV ON: ON with New Remote
Philips TV OFF: OFF with New Remote
*/
```


Ex 2:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Concrete implementation 1 for Bridge pattern
class AssembleWorkShop extends WorkShop {

    public AssembleWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {
        System.out.println("Assembling...");
        long timeToTake = 200 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}

//Refine abstraction 1 in Bridge pattern
class Bike extends Vehicle {

    @Override
    public void manufactre() {
        System.out.println("Manufacturing Bike...");
        workshops.stream().forEach(workshop -> workshop.work(this));
        System.out.println("Done");
        System.out.println();
    }

    @Override
    public int minWorkTime() {
        return 5;
    }

}

class Bus extends Vehicle {

    @Override
    public void manufactre() {
        System.out.println("Manufacturing Bus...");
        workshops.stream().forEach(workshop -> workshop.work(this));
        System.out.println("Done");
        System.out.println();
    }

    @Override
    public int minWorkTime() {
        return 20;
    }

}

//Refine abstraction 2 in Bridge pattern
class Car extends Vehicle {

    @Override
    public void manufactre() {
        System.out.println("Manufacturing Car...");
        workshops.stream().forEach(workshop -> workshop.work(this));
        System.out.println("Done");
        System.out.println();
    }

    @Override
    public int minWorkTime() {
        return 10;
    }

}

class Main {

    public static void main(String[] args) {

        Vehicle bike = new Bike();
        bike.joinWorkShop(new ProduceWorkShop());
        bike.joinWorkShop(new AssembleWorkShop());
        bike.joinWorkShop(new TestWorkShop());
        bike.manufactre();

        Vehicle car = new Car();
        car.joinWorkShop((new ProduceWorkShop()));
        car.joinWorkShop((new AssembleWorkShop()));
        car.joinWorkShop((new PaintWorkShop()));
        car.joinWorkShop((new TestWorkShop()));
        car.manufactre();

        Vehicle bus = new Bus();
        bus.joinWorkShop(new RepairWorkShop());
        bus.joinWorkShop(new AssembleWorkShop());
        bus.joinWorkShop(new TestWorkShop());
        bus.manufactre();
    }
}

class PaintWorkShop extends WorkShop {

    public PaintWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {
        System.out.println("Painting...");
        long timeToTake = 400 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}

//Concrete implementation 1 for Bridge pattern
class ProduceWorkShop extends WorkShop {

    public ProduceWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {
        System.out.println("Producing...");
        long timeToTake = 300 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}

//Concrete implementation 2 for Bridge pattern
class RepairWorkShop extends WorkShop {

    public RepairWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {
        System.out.println("Repairing...");
        long timeToTake = 150 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}

//Concrete implementation 3 for Bridge pattern
class TestWorkShop extends WorkShop {

    public TestWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {
        System.out.println("Testing...");
        long timeToTake = 50 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}

abstract class Vehicle {

    protected List<WorkShop> workshops = new ArrayList<WorkShop>();

    public Vehicle() {
        super();
    }

    public boolean joinWorkShop(WorkShop workshop) {
        return workshops.add(workshop);
    }

    public abstract void manufactre();

    public abstract int minWorkTime();

}


/*
Implementor -
It defines the interface for implementing classes
This interface does not need to correspond directly to the abstraction interface and can be very different
Abstraction imp provides an implementation in terms of operations provided by implementatoer interface
 */
abstract class WorkShop {

    public abstract void work(Vehicle vehicle);

}

/*
Manufacturing Bike...
Producing...
(Time taken : 1500 millis), Done.
Assembling...
(Time taken : 1000 millis), Done.
Testing...
(Time taken : 250 millis), Done.
Done

Manufacturing Car...
Producing...
(Time taken : 3000 millis), Done.
Assembling...
(Time taken : 2000 millis), Done.
Painting...
(Time taken : 4000 millis), Done.
Testing...
(Time taken : 500 millis), Done.
Done

Manufacturing Bus...
Repairing...
(Time taken : 3000 millis), Done.
Assembling...
(Time taken : 4000 millis), Done.
Testing...
(Time taken : 1000 millis), Done.
Done
*/
```
