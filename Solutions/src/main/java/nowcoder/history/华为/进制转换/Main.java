package nowcoder.history.华为.进制转换;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int base = 16;
        for (int i = 0; i < 10; i++) {
            map.put((char) ('0' + i), i);
        }
        for (char c = 'A'; c <= 'F'; c++) {
            map.put(c, c - 'A' + 10);
        }
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
//            if ("0".equals(s)) break;
            s = s.substring(2);
            int r = 0, ln = s.length();
            for (int i = ln - 1; i >= 0; i--) {
                r += map.get(s.charAt(i)) * Math.pow(base, ln - i - 1);
            }
            list.add(r);
        }
        list.stream().forEach(x -> System.out.println(x));
    }
}
