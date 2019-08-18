package org.devon.clazz.statics;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/2 0:15
 * @since 1.0.0
 */
public class MethodExecuteStep {

    static class B extends Object {
        C c = new C();

        static {
            System.out.println("Load B");
        }

        public B() {
            System.out.println("Create B");
        }
    }

     static class A extends Object {
        D d = new D();

        static {
            System.out.println("Load A");
        }

        public A() {
            System.out.println("Create A");
        }
    }

    static class C {
        public C() {
            System.out.println("CONSTRUCT C");
        }

        public void C() {
            System.out.println("method C");
        }
    }


    static class D {
        public D() {
            System.out.println("CONSTRUCT D");
        }

        public void D() {
            System.out.println("method D");
        }
    }

    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            obj.wait();
            obj.notify();
        }
    }


    public static void main(String[] args) {
        // new C().C();
        new A();
        Boolean flag = Boolean.getBoolean(args[0]);
        if (flag = true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}
