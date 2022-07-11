package BridgePattern.Example1;

import java.util.concurrent.TimeUnit;

//Concrete implementation 1 for Bridge pattern
public class AssembleWorkShop extends WorkShop {

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