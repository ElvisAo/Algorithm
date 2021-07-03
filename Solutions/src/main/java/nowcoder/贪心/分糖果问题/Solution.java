/**
 * @description: TODO
 * @author Everett
 * @date 7/1/2021 9:08 PM
 */
package nowcoder.贪心.分糖果问题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 2, 1, 1, 3, 4};
        System.out.println(new Solution().solution_2(t));
    }

    /**
     * {@空间复杂度n}
     *
     * @param arr
     * @return
     */
    public int solution_1(int[] arr) {
        int r = arr.length, t[] = new int[r];
        t[0] = 1;
        t[r - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            t[i] = 1;
            if (arr[i] > arr[i - 1]) {
                t[i] = t[i - 1] + 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                t[i] = Math.max(t[i], t[i + 1] + 1);
            }
        }
        return Arrays.stream(t).sum();
    }

    /**
     * {@空间复杂度1}
     *
     * @param arr
     * @return
     */
    public int solution_2(int[] arr) {
        int up = 0, down = 0, peak = 1, r = 1;  // up,down:连续上坡或下坡的个数
        for (int i = 1; i < arr.length; i++) {
            r++;    // 没扫描一个，就加基本的1
            if (arr[i] > arr[i - 1]) {  // 如果是上坡，就要再加一个连续上坡的个数，并更新峰顶值
                up++;
                r += up;
                down = 0;
                peak = up + 1;
            } else if (arr[i] == arr[i - 1]) {  // 如果是平的，把上坡数与下坡数置0，更新峰值
                up = 0;
                down = 0;
                peak = 1;
            } else {    // 如果是下坡，就要加上连续下坡的个数，如果下坡的个数已经超过了峰的高度，就要再加1（峰顶）
                up = 0;
                r += down;
                down++;
                if (down >= peak)
                    r++;
            }
        }
        return r;
    }
}
