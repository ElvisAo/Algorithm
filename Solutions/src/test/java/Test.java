public class Test {
    public static void main(String[] args) {
 /*       Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i == j);*/
/*        Thread thread = new Thread();
        thread.getPriority();
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("one", "two", "two", "two", "two"));
        for (int i = 0; i < list.size();i++) {
            if (list.get(i).equals("two")) {
                list.remove(i);
            }
        }
        System.out.println(list.toString());*/
        double v = 1.0 / 0.0;
        System.out.println(v);
        System.out.println(1.0 / 0.0);
        int f = 0, g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }

    }
}
