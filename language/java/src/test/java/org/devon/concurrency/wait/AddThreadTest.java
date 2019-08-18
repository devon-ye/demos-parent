package org.devon.concurrency.wait;

import org.junit.Test;

/**
 * Created by lenovo on 2017/12/3.
 */
public class AddThreadTest {

    @Test
    public  void test() {
        AddOperatorWaitNodify addOperatorWaitNodify = new AddOperatorWaitNodify(7);
        AddThread addThread = new AddThread(addOperatorWaitNodify);
        PrintThread printThread = new PrintThread(addOperatorWaitNodify);
        int i=0;
        while (i<5) {
            new Thread(addThread).start();
            new Thread(printThread).start();
            i++;
        }
    }
}
