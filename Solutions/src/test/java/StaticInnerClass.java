public class StaticInnerClass {
    private int a = 10;
    private static int b = 20;

    static class Inner {
        public void print() {
            System.out.println(b);
        }
    }

    class NoStaticInner {
        public void print(){
            System.out.println(a);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        new Inner().print();
        new StaticInnerClass().new NoStaticInner().print();
    }
}
