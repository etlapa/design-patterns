package mx.edev.design.patterns.creational.singleton;

public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    /**
     * The instance is created just at the moment that is required, not at the
     * beginning of the application like the BasicSingleton. Making this change
     * improves the performance of the application just because the lazy load
     * 
     * @return
     */
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}