package com.shiva.webservices.restfulwebservices;

public class Demo {
    public static void main(String[] args) {


        /**
         *
         // a simple lambda expression
         () -> System.out.println("hi");

         // arguemnts in lambda expression
         (int a, int b) -> System.out.println(a + b);

         // no need types always
         (a, b) -> System.out.println(a + b);

         // takes an int, returns the square of that
         a -> a * a;
         *
         */


        // IFunc i = () -> System.out.println("woawww");
        // i.singleAbstractMethod();

        // IFunc i2 = n -> n;
        // i2.singleAbstractMethod(10);


        // IFunc i1 = new Test();
        // System.out.println(i1.square(10));
        // System.out.println(i1.square(20));
        //
        // IFunc i = n -> n * n;
        // IFunc i2 = (n) -> n * n;
        // IFunc i3 = n -> {
        //     return n * n;
        // };
        // IFunc i4 = n -> {
        //     return n * n;
        // };

        // System.out.println(i.square(7));
        // System.out.println(i.square(8));

        Runnable r = () -> {
            for (int idx = 0; idx < 10; idx++) {
                System.out.println("child thread" + idx);
            }
        };

        // main thread job
        for (int idx = 0; idx < 10; idx++) {
            System.out.println("main thread" + idx);
        }
        // r.run();

        Runnable job = new Runnable() {
            @Override
            public void run() {
                for (int idx = 0; idx < 10; idx++) {
                    System.out.println("child thread" + idx);
                }
            }
        };

        Thread childThread = new Thread(job);
        // childThread.start();
    }

}


class Test implements IFunc {
    @Override
    public int square(int a) {
        return a * a;
    }
}


@FunctionalInterface
interface IFunc {
    int square(int a);
}
