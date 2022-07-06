package PrototypePattern;

class MyClass implements Cloneable {

    private String shirt;

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getShirt() {
        return shirt;
    }

    public void setShirt(String s) {
        this.shirt = s;
    }

    @Override
    public String toString() {
        return "Shirt = " + shirt;
    }
}

class CloneShirt {

    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass a = new MyClass();
        MyClass a1 = (MyClass) a.clone();
        a.setShirt("Shirt1");
        a.setShirt("ShirtClone1");
        a1.setShirt("Shirt2");
        System.out.println(a);
        System.out.println(a1);
    }
}
