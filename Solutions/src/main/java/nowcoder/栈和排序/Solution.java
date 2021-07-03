/**
 * @author Everett
 * @date 7/1/2021 3:39 PM
 */
package nowcoder.栈和排序;

import java.util.Arrays;
import java.util.Stack;

// 单调栈，如果后面有比知己大的，就先不出栈，否则出栈
public class Solution {
    public static void main(String[] args) {
        int[] a = {5, 8, 9, 6, 7, 1, 3, 2, 4};
        Arrays.stream(new Solution().solve(a)).forEach(x -> System.out.print(x + " "));
    }

    public int[] solve(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] rmax = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, a[i]);
            rmax[i] = max;
        }
        int[] r = new int[n];
        int ri = 0;
        for (int i = 0; i < n; i++) {
            /**
             * {@这里必须先push再while，因为对于当前元素，进栈后，在下面while的i+1时，才是与后面的继续比较}
             */
            stack.push(a[i]);
            while (!stack.isEmpty() && i < n - 1 && stack.peek() > rmax[i + 1]) {
                r[ri++] = stack.pop();
            }
        }
        while (!stack.isEmpty()) r[ri++] = stack.pop();
        return r;
    }
}
