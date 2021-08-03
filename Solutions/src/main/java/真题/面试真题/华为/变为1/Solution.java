package 真题.面试真题.华为.变为1;

public class Solution {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        for (int i = 1; i <= 1000; i++) {
            if (legal(i, 0)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean legal(int i, int counter) {
        if (counter >= 50) return false;
        int t = 0;
        while (i > 0) {
            int i1 = i % 10;
            i /= 10;
            t += i1 * i1;
        }
        if (t == 1) return true;
        else {
            return legal(t, counter + 1);
        }
    }
}
