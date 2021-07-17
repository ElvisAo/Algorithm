package 面试真题.字节.分糖果;

import java.util.Arrays;
import java.util.Random;

public class 分糖果 {
    public static void main(String[] args) {
        int R = 5;
        int[] arr = new int[R];
        Random random = new Random();
        for (int i = 0; i < R; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(helper(arr));
    }

    public static int helper(int[] arr) {
        int n = arr.length;
        int[] r = new int[n];
        Arrays.fill(r, 1);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                r[i] = r[i - 1] + 1;
            }
        }
        sum += r[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                r[j] = Math.max(r[j], r[j + 1] + 1);
            }
            sum += r[j];
        }
        return sum;
    }
}
