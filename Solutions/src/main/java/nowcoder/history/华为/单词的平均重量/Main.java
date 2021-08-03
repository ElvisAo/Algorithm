package nowcoder.history.华为.单词的平均重量;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] s = input.split(" ");
        double r = 0, weight = 0;
        for (int i = 0; i < s.length; i++) {
            weight += s[i].length();
        }
        r = weight / s.length;
        System.out.println(String.format("%.2f", r));
    }
}

