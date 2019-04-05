package mx.edev.design.patterns.creational.singleton;

public class BasicSingleton {
    private static BasicSingleton singleton = new BasicSingleton();

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        return singleton;
    }
}