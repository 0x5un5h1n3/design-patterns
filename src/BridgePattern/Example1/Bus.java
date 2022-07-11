package BridgePattern.Example1;

//Refine abstraction 2 in Bridge pattern
public class Bus extends Vehicle {

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
