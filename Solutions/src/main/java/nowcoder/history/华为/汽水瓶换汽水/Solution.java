package nowcoder.history.华为.汽水瓶换汽水;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 每次输入是一个文件，要注意输出的结束
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            list.add(n);
        }
        while (!list.isEmpty()) {
            System.out.println(exchange(list.removeFirst()));
        }
    }

    private static int exchange(int n) {
        int r = 0;
        while (n > 2) {
            int w = n / 3;
            r += w;
            n = w + n % 3;
        }
        if (n == 2) r++;
        return r;
    }
}

