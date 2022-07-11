package BridgePattern.Example1;

import java.util.concurrent.TimeUnit;

//Concrete implementation 1 for Bridge pattern
public class ProduceWorkShop extends WorkShop {

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
