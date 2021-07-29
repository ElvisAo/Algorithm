import java.util.HashSet;
import demo.defaultDemo;


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

    public static void main(String[] args) {
        System.out.println(new SInner().psint);
        new SInner().test();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.add(1));
        System.out.println(defaultDemo.prop2);
    }

    public void test() {
        System.out.println(pint);
    }
}
