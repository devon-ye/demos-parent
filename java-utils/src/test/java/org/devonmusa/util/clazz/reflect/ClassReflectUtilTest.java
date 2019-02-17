package org.devonmusa.util.clazz.reflect;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/17 14:39
 */
public class ClassReflectUtilTest {

    @Test
    public void printClassMessage() {
        ClassReflectUtil.printClassMessage(ClassReflectUtil.class);
    }

    @Test
    public void printFieldMessage() {
        ClassReflectUtil.printFieldMessage(ClassReflectUtil.class);
    }

    @Test
    public void printConstructorMessage() {
        ClassReflectUtil.printConstructorMessage(ClassReflectUtil.class);
    }
}