package DecotatorPattern;

interface Pizza {

    void make();
}

class CheesePizza implements Pizza {

    @Override
    public void make() {
        System.out.println("Pizza: Chicken Pizza");
    }

}

class ChickenPizza implements Pizza {

    @Override
    public void make() {
        System.out.println("Pizza: Chicken Pizza");
    }
}

abstract class PizzaDecorator implements Pizza {

    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public void make() {
        decoratedPizza.make();
    }

}

class CheesePizzaDecorator extends PizzaDecorator {

    public CheesePizzaDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public void make() {
        decoratedPizza.make();
        addCheese(decoratedPizza);
    }

    private void addCheese(Pizza decoratedPizza) {
        System.out.println("Chicken Pizza with Cheese");
    }
}

class SpicyPizzaDecorator extends PizzaDecorator {

    public SpicyPizzaDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public void make() {
        decoratedPizza.make();
        addCheese(decoratedPizza);

    }

    private void addCheese(Pizza decoratedPizza) {
        System.out.println("Chicken Pizza with Spices");
    }
}

class DecoratorPatternTest {

    public static void main(String[] args) {
        Pizza CheesePizza = new CheesePizza();
        Pizza CheeseChicken = new CheesePizzaDecorator(new CheesePizza());
        Pizza ChickenPizza = new CheesePizzaDecorator(new ChickenPizza());

        System.out.println("Normal Cheese Pizza");
        CheesePizza.make();

        System.out.println("\nCheese Chicken Pizza");
        CheeseChicken.make();
        
        System.out.println("\nChicken Pizza");
        ChickenPizza.make();
        
        System.out.println("\n-----Mixed Pizza-----");
        Pizza mixedPizza = new CheesePizzaDecorator(new SpicyPizzaDecorator(CheesePizza));
        mixedPizza.make();
    }
}

/*
Normal Cheese Pizza
Pizza: Chicken Pizza

Cheese Chicken Pizza
Pizza: Chicken Pizza
Chicken Pizza with Cheese

Chicken Pizza
Pizza: Chicken Pizza
Chicken Pizza with Cheese

-----Mixed Pizza-----
Pizza: Chicken Pizza
Chicken Pizza with Spices
Chicken Pizza with Cheese
*/