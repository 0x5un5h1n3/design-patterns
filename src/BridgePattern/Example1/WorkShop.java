package BridgePattern.Example1;

/*
Implementor -
It defines the interface for implementing classes
This interface does not need to correspond directly to the abstraction interface and can be very different
Abstraction imp provides an implementation in terms of operations provided by implementatoer interface
*/
public abstract class WorkShop {

    public abstract void work(Vehicle vehicle);

}
