/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiPatterns;

public class DriverInfo extends Driver {

    public String msg;

    public DriverInfo(TrafficControlMediator med, String driverName, String numberPlate) {
        super(med, driverName, numberPlate);
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String request(String msg) {

        return "Requested By"
                + "\n- Name : "+y+ " "
                + "\n- Number Plate : "+z+"\n" 
                
                + "\nTraffic Information" + msg+"\n";
    }

}
