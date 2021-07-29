package InnerOuterTest;

public class InnerOuterTest {
    int a = 10;

    class Inner {
        int b = 20;

        public void print() {
            System.out.println(new InnerOuterTest().a);
        }
    }

    public static void main(String[] args) {
        System.out.println(create());
        ClassLoader classLoader = create().getClass().getClassLoader();
        ClassLoader parent = classLoader.getParent();
        System.out.println(classLoader);
        System.out.println(parent);

    }

    public static Object create() {
        class User {
            String name="bb";

            @Override
            public String toString() {
                return "User{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
        return new User();
    }
}
