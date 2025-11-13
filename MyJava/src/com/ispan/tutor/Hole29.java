package com.ispan.tutor;

public class Hole29 {

    public static void main(String[] args) {
        Hole291 obj1 = new Hole291();
        obj1.m1();

        Hole291 obj2 = new Hole292(); // 用父類型接收子類別
        obj2.m1();
    }

    static class Hole291 {
        void m1() { System.out.println("Hole291:m1()"); }
    }

    static class Hole292 extends Hole291 {
        void m1() { System.out.println("Hole292:m1()"); }
    }

    class Hole293 extends Hole291 {
        void m1() { System.out.println("Hole293:m1()"); }
    }

    class Hole294 extends Hole291 {
        void m1() { System.out.println("Hole294:m1()"); }
    }
}
