package PrototypePattern;

class MyData implements Cloneable {

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates

    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return "Name = " + name;
    }
}

class CloneObject {

    public static void main(String[] args) {
        try {
            MyData a = new MyData();
            MyData a1 = (MyData) a.clone();

            a.setName("Hello");
            a1.setName("World");

            System.out.println(a); //Name = Hello
            System.out.println(a1); //Name = World
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}
