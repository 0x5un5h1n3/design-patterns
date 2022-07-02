package SingletonPattern;

class SingletonEager {

    private static SingletonEager instance = new SingletonEager(); //Eager Initialization

    private SingletonEager() {
    } //Private Constructor

    public static SingletonEager getInstance() {
        return instance;
    }
}

class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) { //Lazy Initialization
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonSynchronizedMethod { //Making the Method Synchronized

    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
    }

    public static synchronized SingletonSynchronizedMethod getinstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized {

    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
    }

    public static SingletonSynchronized getInstance() { //Making the Block Synchronized
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        System.out.println(instance1); //SingletonEager@6bf2d00e

        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance2); //SingletonEager@6bf2d00e

        Singleton instance3 = Singleton.getInstance();
        System.out.println(instance3); //Singleton@Hexcode

        Singleton instance4 = Singleton.getInstance();
        System.out.println(instance4); //Singleton@Hexcode

    }
}
