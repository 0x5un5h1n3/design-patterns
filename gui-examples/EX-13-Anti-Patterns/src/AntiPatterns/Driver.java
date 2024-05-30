/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiPatterns;

public abstract class Driver {

    protected TrafficControlMediator x;
    protected String y;
    protected String z;
    protected String msg;

    public Driver(TrafficControlMediator med, String driverName, String numberPlate) {
        this.x = med;
        this.y = driverName;
        this.z = numberPlate;

    }

    public abstract String request(String msg);

}
