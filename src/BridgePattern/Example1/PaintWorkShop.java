package BridgePattern.Example1;

import java.util.concurrent.TimeUnit;

public class PaintWorkShop extends WorkShop {

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
