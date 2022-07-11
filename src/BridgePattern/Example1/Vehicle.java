package BridgePattern.Example1;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

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
