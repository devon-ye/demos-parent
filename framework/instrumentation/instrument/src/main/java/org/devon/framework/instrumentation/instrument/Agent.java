package org.devon.framework.instrumentation.instrument;

import java.lang.instrument.Instrumentation;

/**
 * @author devon.ye
 * @date 2019/9/1 2:11
 * @since
 */
public class Agent {
    private static Instrumentation instrumentation;

    public static void premain(String args,Instrumentation instrumentation){
        instrumentation = instrumentation;
    }
}
