/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediatorPattern;

public abstract class Driver {

    protected TrafficControlMediator mediator;
    protected String driverName;
    protected String numberPlate;
    protected String msg;

    public Driver(TrafficControlMediator med, String driverName, String numberPlate) {
        this.mediator = med;
        this.driverName = driverName;
        this.numberPlate = numberPlate;

    }

    public abstract String request(String msg);

}
