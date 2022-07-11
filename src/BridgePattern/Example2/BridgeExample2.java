package BridgePattern.Example2;

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