package AbstractFactoryPattern;


abstract class Garden {

    public abstract Plant getCenter();

    public abstract Plant getBorder();

    public abstract Plant getShade();

}

class Plant {

    String name;

    public Plant(String pname) {
        name = pname; //save name
    }

    public String getName() {
        return name;
    }
}

class VegieGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Broccoli");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Corn");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Peas");
    }
}

class FruitGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Blackberries");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Guava");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Kivi");
    }
}

class SpiceGarden extends Garden {

    @Override
    public Plant getShade() {
        return new Plant("Black Pepper");
    }

    @Override
    public Plant getCenter() {
        return new Plant("Garlic");
    }

    @Override
    public Plant getBorder() {
        return new Plant("Ginger");
    }
}

class GardenMaker {

    //Abstract Facrory which return one of 3 gardens
    private Garden gd;

    public Garden getGarden(String gtype) {
        gd = new VegieGarden(); //default
        if (gtype.equals("SpiceGarden")) {
            gd = new SpiceGarden();
        }
        if (gtype.equals("FruitGarden")) {
            gd = new FruitGarden();
        }
        return gd;
    }
}

class Test {

    public static void main(String[] args) {
        GardenMaker gm = new GardenMaker();
        String name = gm.getGarden("FruitGarden").getShade().getName();
        System.out.println(name); //Blackberries
    }
}
