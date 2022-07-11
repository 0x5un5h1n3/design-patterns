package BridgePattern.Example1;

import java.util.concurrent.TimeUnit;

//Concrete implementation 3 for Bridge pattern
public class TestWorkShop extends WorkShop{
    public TestWorkShop(){
        super();
    }
    @Override
    public void work(Vehicle vehicle){
        System.out.println("Testing...");
        long timeToTake = 50 * vehicle.minWorkTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake); //Thread.sleep(timeToTake);
        } catch (InterruptedException e) {
        }
        System.out.printf("(Time taken : %d millis), Done.\n", timeToTake);
    }
}
