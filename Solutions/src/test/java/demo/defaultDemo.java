package demo;

public interface defaultDemo {
    public static final int prop1 = 12;
    final int prop2 = 13;

    default public void m1() {
        System.out.println("m1");
    }

    default public void m2() {
        System.out.println("m2");
    }
}