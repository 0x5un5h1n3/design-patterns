package FactoryPattern;

interface Mammal {

    void sound();
}

class cat implements Mammal {

    public void sound() {

        System.out.println("Meow Meow");
    }
}

class dog implements Mammal {

    public void sound() {
        System.out.println("Woof Woof");
    }
}

class MammalFactory {

    public static Mammal getMammalClass(String mammalType) {
        if (mammalType.equals("dog")) {
            return new dog();
        }
        if (mammalType.equals("cat")) {
            return new cat();
        }
        return null;
    }

}

class ProgramFactory {

    public static void main(String[] args) {
        Mammal m1 = MammalFactory.getMammalClass("dog");
        m1.sound(); //Woof Woof

        Mammal m2 = MammalFactory.getMammalClass("cat");
        m2.sound(); //Meow Meow

    }
}
