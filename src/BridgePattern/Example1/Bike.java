package BridgePattern.Example1;

//Refine abstraction 1 in Bridge pattern
public class Bike extends Vehicle {

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