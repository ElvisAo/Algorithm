package nowcoder.history.华为.字符集合;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            list.add(helper(s));
        }
        list.forEach(x -> System.out.println(x));
    }

    private static String helper(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) set.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        set.stream().forEach(x -> sb.append(x));
        return sb.toString();
    }
}
