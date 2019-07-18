package org.devon.clazz.inner;

/**
 * @author Devonmusa
 * @date 2017年7月8日
 */
public class InnerClass {

    class InnerClassA {

    }

    class InnerClassB {

        class InnerClassC {

        }
    }

    class InnerClassD extends OuterClassB {

    }

    class InnerClassE extends OuterClassA {
    }

    public void methodA() {
        new InnerClassE().methodA();
    }

    public void methodB() {
        new InnerClassD().methodB();
    }


    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.methodA();
        innerClass.methodB();
    }
}
