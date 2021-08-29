import demo.defaultDemo;

import java.util.HashSet;


public class ClassDemo {
    private static int pint = 0;

    static class SInner {
        private int pint = 1;
        private static int psint = 3;

        public void test() {
            System.out.println(new ClassDemo().pint);
        }
    }

    class NSInner {
        private int pint = 2;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new SInner().psint);
        new SInner().test();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.add(1));
        set.wait();
        Thread.sleep(100);
        System.out.println(defaultDemo.prop2);
    }

    public void test() {
        System.out.println(pint);
    }
}
