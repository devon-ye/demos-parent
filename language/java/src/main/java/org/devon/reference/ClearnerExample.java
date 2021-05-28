package org.devon.reference;


import sun.misc.Cleaner;

import java.util.Collections;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/2/21 4:02 PM
 */

public class CleaningExample implements AutoCloseable {
    // A cleaner, preferably one shared within a library
    private static final Cleaner cleaner = <cleaner>;
    static class State implements Runnable {
        State(...) {
            // initialize State needed for cleaning action
        }
        public void run() {
            // cleanup action accessing State, executed at most once
        }
    }
    Collections
    private final State;
    private final Cleaner.Cleanable cleanable
    public CleaningExample() {
        this.state = new State(...);
        this.cleanable = cleaner.register(this, state);
    }
    public void close() {
        cleanable.clean();
    }
}
