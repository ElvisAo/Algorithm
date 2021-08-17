import demo.defaultDemo;

public class JSRDemo {


    public static void main(String[] args) {
//        new TreeSet<Integer>()
        System.out.println(defaultDemo.prop2);
//        assert args != null;
        long n = (long) (Math.pow(10, 9) * (2 * Math.pow(10, 9) - 1));
        /*for (int i = 0; i < 2 * Math.pow(10, 5); i++)
            n += Math.pow(10, 9);*/
        System.out.println((n + "").length());
    }

}
