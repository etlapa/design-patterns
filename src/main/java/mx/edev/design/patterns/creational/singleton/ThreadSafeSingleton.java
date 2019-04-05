package mx.edev.design.patterns.creational.singleton;

public class ThreadSafeSingleton {
    /**
     * This keyword (modifier) stores the value of the instance in the main
     * memory and not in the one reserve for an specific thread (cache memory)
     */
    private static volatile ThreadSafeSingleton instance;
    private int counter;

    /**
     * This exception prevents the creation by reflection
     */
    private ThreadSafeSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance method to create");
        }
    }

    /**
     * This is synchronizing only the instance instead of the the whole method.
     * The reason behind making this, it's because performance issue could occur
     * if the whole method is synchronized (delays while calling a response from
     * getInstance)
     * 
     * @return
     */
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public int getCounter() {
        return counter++;
    }
}