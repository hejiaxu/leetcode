package com.code.syn;


/*
1. local inner class should only use final var of outer, for its a dup of it
2. extends of inner class should init an outer class in constructor

 */
public class InnerClass {

    public static void main(String[] args) {
        new InnerClass().test();
    }

    private void test() {
        A b = new A();
        b.a = 1;

        new Thread() {
            @Override
            public void run() {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b.a = 2;
                System.out.println("run" + b.a);
                super.run();
            }
        }.start();

        System.out.println("test" + b.a);
    }

    public class A {
        int a;

        public class C {

        }
    }


}

// extends of InnerClass
class B extends InnerClass.A.C {
    B(InnerClass.A a) {
        a.super();
    }
}



