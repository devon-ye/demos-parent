package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Created by lenovo on 2017/10/25.
 */
@ThreadSafe
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
    }


    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }

    static class Resource {
    }


    /**
     * Double-checked locking is the practice of checking a lazy-initialized object's state both before and after a synchronized block is entered to determine whether or not to initialize the object.
     * <p>
     * It does not work reliably in a platform-independent manner without additional synchronization for mutable instances of anything other than float or int. Using double-checked locking for the lazy initialization of any other type of primitive or mutable object risks a second thread using an uninitialized or partially initialized member while the first thread is still creating it, and crashing the program.
     * <p>
     * There are multiple ways to fix this. The simplest one is to simply not use double checked locking at all, and synchronize the whole method instead. With early versions of the JVM, synchronizing the whole method was generally advised against for performance reasons. But synchronized performance has improved a lot in newer JVMs, so this is now a preferred solution. If you prefer to avoid using synchronized altogether, you can use an inner static class to hold the reference instead. Inner static classes are guaranteed to load lazily.
     */
   /* @SuppressWarnings("unchecked")
    public static DoubleCheckSingleton getInstances() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }*/
}
