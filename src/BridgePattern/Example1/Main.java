package BridgePattern.Example1;

public class Main {

    public static void main(String[] args) {

        Vehicle bike = new Bike();
        bike.joinWorkShop(new ProduceWorkShop());
        bike.joinWorkShop(new AssembleWorkShop());
        bike.joinWorkShop(new TestWorkShop());
        bike.manufactre();

        Vehicle car = new Car();
        car.joinWorkShop((new ProduceWorkShop()));
        car.joinWorkShop((new AssembleWorkShop()));
        car.joinWorkShop((new PaintWorkShop()));
        car.joinWorkShop((new TestWorkShop()));
        car.manufactre();

        Vehicle bus = new Bus();
        bus.joinWorkShop(new RepairWorkShop());
        bus.joinWorkShop(new AssembleWorkShop());
        bus.joinWorkShop(new TestWorkShop());
        bus.manufactre();
    }
}
