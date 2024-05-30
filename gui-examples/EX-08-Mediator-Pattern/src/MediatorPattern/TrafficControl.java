/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class TrafficControl implements TrafficControlMediator {
    private List<Driver> drivers;
	
	public TrafficControl(){
		this.drivers=new ArrayList<>();
	}
	
	@Override
	public void addDriver(Driver driver){
		this.drivers.add(driver);
	}
	
	@Override
	public void sendInfo(String msg, Driver driver) {
		for(Driver u : this.drivers){
			
			if(u != driver){
				u.request(msg);
			}
		}
	}

 
    
    
}
