package BridgePattern.Example1;

import java.util.concurrent.TimeUnit;

//Concrete implementation 2 for Bridge pattern
public class RepairWorkShop extends WorkShop {

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
