package FacadePattern;

interface abstractMenu{
    String getMenu();
}

class MexicanFoodMenu implements abstractMenu{
    @Override
    public String getMenu(){
        return "---------------"+"\n"
                + "MEXICAN FOOD MENU"+"\n"
                + "MEXICAN FOOD 1"+"\n"
                + "MEXICAN FOOD 2"+"\n"
                + "MEXICAN FOOD 3"+"\n"
                + "MEXICAN FOOD 4"+"\n"
                + "Total : $150";
    }
}

class ChineseFoodMenu implements abstractMenu{
  
    @Override
    public String getMenu() {
        return "---------------"+"\n"
                + "CHINESE FOOD MENU"+"\n"
                + "CHINESE FOOD 1"+"\n"
                + "CHINESE FOOD 2"+"\n"
                + "CHINESE FOOD 3"+"\n"
                + "Total : $250";
    }
}

class WaiterFacade{
    private MexicanFoodMenu mexican;
    private ChineseFoodMenu chinese;

public WaiterFacade(){
    mexican = new MexicanFoodMenu();
    chinese = new ChineseFoodMenu();
}    
    void getChineseMenu(){
        System.out.println(chinese.getMenu());
    }
    
    void getMexicanMenu(){
        System.out.println(mexican.getMenu());
    }
}

class Client{
    public static void main(String[] args) {
        WaiterFacade w = new WaiterFacade();
        w.getMexicanMenu();
        w.getChineseMenu();
    }
}

/*
---------------
MEXICAN FOOD MENU
MEXICAN FOOD 1
MEXICAN FOOD 2
MEXICAN FOOD 3
MEXICAN FOOD 4
Total : $150
---------------
CHINESE FOOD MENU
CHINESE FOOD 1
CHINESE FOOD 2
CHINESE FOOD 3
Total : $250
*/