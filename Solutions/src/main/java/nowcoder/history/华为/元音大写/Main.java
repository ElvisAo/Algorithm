package nowcoder.history.华为.元音大写;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashSet<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n = input.length();
        char[] array = input.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = array[i];
            if (c == ' ') continue;
            if (set.contains(c)) {
                if (c >= 'a' && c <= 'z') {
                    c += 'A' - 'a';
                    array[i] = c;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c += 'a' - 'A';
                    array[i] = c;
                }
            }
        }
        System.out.println(new String(array));
    }
}