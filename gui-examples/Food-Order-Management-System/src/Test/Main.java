package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// Builder Pattern
// Item interface representing food items
interface Item {

    public String name();

    public Packing packing();

    public float price();
}

// Packing interface
interface Packing {

    public String pack();
}

// Concrete classes implementing the Packing interface
class Wrapper implements Packing {

    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {

    public String pack() {
        return "Bottle";
    }
}

// Concrete classes implementing the Item interface
abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}

abstract class Drink implements Item {

    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}

class VegBurger extends Burger {

    public String name() {
        return "Veg Burger";
    }

    public float price() {
        return 25.0f;
    }
}

class ChickenBurger extends Burger {

    public String name() {
        return "Chicken Burger";
    }

    public float price() {
        return 50.5f;
    }
}

class Coke extends Drink {

    public String name() {
        return "Coke";
    }

    public float price() {
        return 30.0f;
    }
}

class Pepsi extends Drink {

    public String name() {
        return "Pepsi";
    }

    public float price() {
        return 35.0f;
    }
}

// Meal class using the Builder pattern
class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item: " + item.name());
            System.out.println("Packing: " + item.packing().pack());
            System.out.println("Price: " + item.price());
        }
    }
}

// MealBuilder class, the actual builder class responsible to create Meal objects
class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

// Flyweight Pattern
// Flyweight interface
interface Ingredient {

    public void use(Topping topping);
}

// Concrete Flyweight class
class ConcreteIngredient implements Ingredient {

    private String name;

    public ConcreteIngredient(String name) {
        this.name = name;
    }

    @Override
    public void use(Topping topping) {
        System.out.println("Using " + name + " with " + topping.getName());
    }
}

// Topping class
class Topping {

    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Interpreter Pattern
// Interpreter class
class OrderInterpreter {

    private Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>();

    public OrderInterpreter() {
        ingredients.put("cheese", new ConcreteIngredient("Cheese"));
        ingredients.put("lettuce", new ConcreteIngredient("Lettuce"));
    }

    public void interpret(String command) {
        // Interpret the command
        if (command.contains("extra")) {
            String[] words = command.split(" ");
            if (words.length == 3) {
                String ingredient = words[1];
                Ingredient concreteIngredient = ingredients.get(ingredient);
                if (concreteIngredient != null) {
                    concreteIngredient.use(new Topping("Extra " + ingredient));
                }
            }
        }
    }
}

// Mediator Pattern
// Mediator interface
interface OrderMediator {

    void sendMessage(String message, Colleague colleague);
}

// Colleague interface
abstract class Colleague {

    protected OrderMediator mediator;

    public Colleague(OrderMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

// Concrete Colleague classes
class Customer extends Colleague {

    public Customer(OrderMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println("Customer received: " + message);
    }
}

class OrderManagementSystem extends Colleague {

    public OrderManagementSystem(OrderMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println("Order Management System received: " + message);
    }
}

// Concrete Mediator class
class OrderProcessing implements OrderMediator {

    private Customer customer;
    private OrderManagementSystem orderManagementSystem;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderManagementSystem(OrderManagementSystem orderManagementSystem) {
        this.orderManagementSystem = orderManagementSystem;
    }

    public void sendMessage(String message, Colleague colleague) {
        if (colleague == customer) {
            orderManagementSystem.receive(message);
        } else {
            customer.receive(message);
        }
    }
}

// Chain of Responsibility Pattern
// OrderStep abstract class
abstract class OrderStep {

    protected OrderStep nextStep;

    public void setNextStep(OrderStep nextStep) {
        this.nextStep = nextStep;
    }

    public abstract void handleStep(Order order);
}

// ConcreteHandler classes
class AcceptingStep extends OrderStep {

    @Override
    public void handleStep(Order order) {
        // Handle logic for accepting step
        if (order.getStatus().equals("New")) {
            order.setStatus("Accepted");
            System.out.println("Order accepted");
            // Move to the next step
            if (nextStep != null) {
                nextStep.handleStep(order);
            }
        }
    }
}

class CookingStep extends OrderStep {

    @Override
    public void handleStep(Order order) {
        // Handle logic for cooking step
        if (order.getStatus().equals("Accepted")) {
            order.setStatus("Cooking");
            System.out.println("Order cooking");
            // Move to the next step
            if (nextStep != null) {
                nextStep.handleStep(order);
            }
        }
    }
}

class PackingStep extends OrderStep {

    @Override
    public void handleStep(Order order) {
        // Handle logic for packing step
        if (order.getStatus().equals("Cooking")) {
            order.setStatus("Packing");
            System.out.println("Order packing");
            // Move to the next step
            if (nextStep != null) {
                nextStep.handleStep(order);
            }
        }
    }
}

class HandoverStep extends OrderStep {

    @Override
    public void handleStep(Order order) {
        // Handle logic for handover step
        if (order.getStatus().equals("Packing")) {
            order.setStatus("Handed over");
            System.out.println("Order handed over to the driver");
            // Move to the next step
            if (nextStep != null) {
                nextStep.handleStep(order);
            }
        }
    }
}

// Order class
class Order {

    private String status;

    public Order() {
        this.status = "New";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

// Main class
public class Main {

    public static void main(String[] args) {
        // Set up the chain of responsibility
        OrderStep acceptingStep = new AcceptingStep();
        OrderStep cookingStep = new CookingStep();
        OrderStep packingStep = new PackingStep();
        OrderStep handoverStep = new HandoverStep();

        acceptingStep.setNextStep(cookingStep);
        cookingStep.setNextStep(packingStep);
        packingStep.setNextStep(handoverStep);

        // Create a new order
        Order order = new Order();

        // Handle the order through the chain
        acceptingStep.handleStep(order);

        // Print the final order status
        System.out.println("Order status: " + order.getStatus());

        // Use the Flyweight pattern to optimize memory usage for frequently used
        // ingredients and toppings
        Ingredient cheese = new ConcreteIngredient("Cheese");
        Ingredient lettuce = new ConcreteIngredient("Lettuce");
        Topping topping = new Topping("Extra cheese");
        cheese.use(topping);
        lettuce.use(topping);

        // Use the Builder pattern to handle complex food orders
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        // Use the Interpreter pattern to customize orders with command parsing
        OrderInterpreter interpreter = new OrderInterpreter();
        interpreter.interpret("I want a burger with extra cheese");
        interpreter.interpret("I want a pizza with extra pepperoni");

        // Use the Mediator pattern to centralize communication between users and manage group orders
        OrderMediator mediator = new OrderProcessing();
        Customer customer = new Customer(mediator);
        OrderManagementSystem orderManagementSystem = new OrderManagementSystem(mediator);
        ((OrderProcessing) mediator).setCustomer(customer);
        ((OrderProcessing) mediator).setOrderManagementSystem(orderManagementSystem);

//         Send messages using Mediator
        customer.send("Your order has been accepted");
        orderManagementSystem.send("New order received");

    }
}
