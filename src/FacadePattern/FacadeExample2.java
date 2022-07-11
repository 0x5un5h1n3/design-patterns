package FacadePattern;

interface vehicleSale{
    String getVehicles();
}

class ElectricVehicles implements vehicleSale{
    @Override
    public String getVehicles(){
        return "---------------"+"\n"
                + "ELECRIC VEHICLE LIST"+"\n"
                + "TESLA MODEL 1"+"\n"
                + "TESLA MODEL 2"+"\n"
                + "TESLA MODEL 3"+"\n"
                + "TESLA MODEL S"+"\n"
                + "Total : $6,700,000";
    }
}

class HybridVehicles implements vehicleSale{
  
    @Override
    public String getVehicles() {
        return "---------------"+"\n"
                + "HYBRID VEHICLE LIST"+"\n"
                + "MERCEDES BENZ"+"\n"
                + "HONDA"+"\n"
                + "HYUNDAI"+"\n"
                + "Total : $870,000";
    }
}

class SalesmanFacade{
    private ElectricVehicles electric;
    private HybridVehicles hybrid;

public SalesmanFacade(){
    electric = new ElectricVehicles();
    hybrid = new HybridVehicles();
}    
    void getElectricVehicles(){
        System.out.println(electric.getVehicles());
    }
    
    void getHybridVehicles(){
        System.out.println(hybrid.getVehicles());
    }
}

class Driver{
    public static void main(String[] args) {
        SalesmanFacade s = new SalesmanFacade();
        s.getElectricVehicles();
        s.getHybridVehicles();
    }
}

/*
---------------
ELECRIC VEHICLE LIST
TESLA MODEL 1
TESLA MODEL 2
TESLA MODEL 3
TESLA MODEL S
Total : $6,700,000
---------------
HYBRID VEHICLE LIST
MERCEDES BENZ
HONDA
HYUNDAI
Total : $870,000
*/