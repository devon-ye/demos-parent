package org.devon.clazz.instrumentation;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/3/12 4:41 PM
 */
public class AgentMain {

    public static void premain(String args, Instrumentation instrumentation) {

        instrumentation.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            if ("Num".equals(className)) {
                classfileBuffer[261] = 4;
            }
            return classfileBuffer;
        });

        try {
            instrumentation.retransformClasses(Num.class);
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        }
    }
}