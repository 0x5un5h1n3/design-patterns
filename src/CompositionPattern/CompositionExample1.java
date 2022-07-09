package CompositionPattern;

import java.util.ArrayList;
import java.util.List;

interface Componant {

    void ShowPrice();
}

class Leaf implements Componant {

    private int price;
    private String name;

    public Leaf(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public void ShowPrice() {
        System.out.println("Name: " + name + " - " + "Price: " + price);
    }

}

class Composite implements Componant {

    private String name;
    List<Componant> componants = new ArrayList<>();

    public Composite(String name) {
        super();
        this.name = name;
    }

    void addComponant(Componant comp) {
        componants.add(comp);
    }

    @Override
    public void ShowPrice() {
        System.out.println(name);

        for (Componant c : componants) {
            c.ShowPrice();
        }
    }
}

class TestComposite {

    public static void main(String[] args) {
        Composite mb = new Composite("MotherBoad Intel G41");
        Leaf cpu = new Leaf("CPU i7", 25000);
        Leaf ram = new Leaf("RAM 4 GB", 4000);
        Leaf vga = new Leaf("VGA 2GB", 15000);
        mb.addComponant(cpu);
        mb.addComponant(ram);
        mb.addComponant(vga);

        Composite systemUnit = new Composite("System unit");
        Leaf hdd = new Leaf("HDD 1TB", 8000);
        Leaf power = new Leaf("Power Unit", 15000);
        systemUnit.addComponant(hdd);
        systemUnit.addComponant(power);
        systemUnit.addComponant(mb); // Add the Composite MotherBoard to the System Unit

        Composite peripheral = new Composite("Peripheral Devices");
        Leaf moniter = new Leaf("Moniter 17inch", 15000);
        Leaf mouse = new Leaf("Mouse", 2000);
        Leaf keyBoard = new Leaf("key Board", 4500);
        peripheral.addComponant(moniter);
        peripheral.addComponant(mouse);
        peripheral.addComponant(keyBoard);

        Composite Computer = new Composite("Computer");
        Computer.addComponant(systemUnit);
        Computer.addComponant(peripheral);

        peripheral.ShowPrice();
//        Peripheral Devices
//        Name: Moniter 17inch - Price: 15000
//        Name: Mouse - Price: 2000
//        Name: key Board - Price: 4500

        Computer.ShowPrice();
//        Computer
//        System unit
//        Name: HDD 1TB - Price: 8000
//        Name: Power Unit - Price: 15000
//        MotherBoad Intel G41
//        Name: CPU i7 - Price: 25000
//        Name: RAM 4 GB - Price: 4000
//        Name: VGA 2GB - Price: 15000
//        Peripheral Devices
//        Name: Moniter 17inch - Price: 15000
//        Name: Mouse - Price: 2000
//        Name: key Board - Price: 4500

    }
}
