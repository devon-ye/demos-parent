package com.method.statics;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/2 0:15
 * @since 1.0.0
 */
public class MethodExecuteStep {

    static class B extends Object {
        static {
            System.out.println("Load B");
        }

        public B() {
            System.out.println("Create B");
        }
    }

    static class A extends B {

        static {
            System.out.println("Load A");
        }

        public A() {
            System.out.println("Create A");
        }
    }

   static class C {
        public C(){
            System.out.println("CONSTRUCT C");
        }

        public void C(){
            System.out.println("method C");
        }
    }


    public static void main(String[] args) {
        new C().C();
        new A();
    }
}
