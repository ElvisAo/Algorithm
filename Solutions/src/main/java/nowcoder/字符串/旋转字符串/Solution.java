package nowcoder.字符串.旋转字符串;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean solution_1(String A, String B) {
        if (A.length() != B.length()) return false;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            boolean preFlag = true, postFlag = true;
            for (int a = 0, b = n - i - 1; a <= i && b < n; a++, b++) {
                if (A.charAt(a) != B.charAt(b)) {
                    preFlag = false;
                    break;
                }
            }
            if (!preFlag) continue;
            for (int a = i + 1, b = 0; b < n - i - 1 && a < n; a++, b++) {
                if (A.charAt(a) != B.charAt(b)) {
                    postFlag = false;
                    break;
                }
            }
            if (preFlag && postFlag) return true;
        }
        return false;
    }

    public boolean solution_2(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        return (A + A).contains(B);
    }
}
