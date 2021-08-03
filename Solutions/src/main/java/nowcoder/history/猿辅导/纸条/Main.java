package nowcoder.history.猿辅导.纸条;

import java.util.Scanner;

/**
 * TODO 未完成
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[][] input = new String[T][3];
        for (int i = 0; i < T; i++) {
            input[i][0] = scanner.next();
            input[i][1] = scanner.next();
            input[i][2] = scanner.next();
        }

    }

    public boolean solution(String[] input) {
        String s1 = input[0], s2 = input[1], s3 = input[2];
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
//                if (dfs())
            }
        }
        return false;
    }

    public boolean dfs(String s1, String s2, String s3, StringBuilder r) {
        if (s3.equals(r.toString())) return true;
        else if (s1.isEmpty()) {
            r.append(s2);
            if (s3.equals(r.toString())) return true;
            else return false;
        } else if (s2.isEmpty()) {
            r.append(s1);
            if (s3.equals(r.toString())) return true;
            else return false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {

                }
            }
        }
        return false;
    }
}
