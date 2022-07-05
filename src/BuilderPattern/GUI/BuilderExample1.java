package BuilderPattern.GUI;

class Laptop {

   private String os;
   private int ram;
   private String processor;
   private String brand;

   public Laptop(String os, int ram, String processor, String brand) {
       this.os = os;
       this.processor = processor;
       this.ram = ram;
       this.brand = brand;
   }

   @Override
   public String toString() {
       return "OS: " + os + ", RAM: "+ ram + "GB, " + "Processor: " + processor + ", Brand: " + brand;
   }

}

class Builder {

   private String os;
   private int ram;
   private String processor;
   private String brand;

   public Builder setOs(String os) {
       this.os = os;
       return this;
   }

   public Builder setRam(int ram) {
       this.ram = ram;
       return this;
   }

   public Builder setProcessor(String processor) {
       this.processor = processor;
       return this;
   }

   public Builder setBrand(String brand) {
       this.brand = brand;
       return this;
   }

   public Laptop getLaptop() {
       return new Laptop(os, ram, processor, brand);
   }
}

class LapBuilder {

   public static void main(String[] args) {
       Laptop lap0 = new Laptop("Win10", 8, "i7", "Dell"); //can't be customized
       Laptop lap1 = new Builder().setOs("Win10").setBrand("Asus").setProcessor("i7").setRam(16).getLaptop();
       Laptop lap2 = new Builder().setBrand("Asus").setProcessor("i7").setRam(16).getLaptop(); //Can be customized
       
       System.out.println(lap0); //OS: Win10, RAM: 8GB, Processor: i7, Brand: Dell
       System.out.println(lap1); //OS: Win10, RAM: 16GB, Processor: i7, Brand: Asus
       System.out.println(lap2); //OS: null, RAM: 16GB, Processor: i7, Brand: Asus
   }
}