/**
 * @author Everett
 * @date 6/28/2021 12:04 AM
 */
package nowcoder.数组.数组中未出现的最小正整数;

import java.util.HashSet;

public class Solutions {
    public static void main(String[] args) {
        int[] t = {1, 3, 2};
        System.out.println(new Solutions().minNumberdisappered(t));
    }

    public int minNumberdisappered(int[] arr) {
        return solution_3(arr);
    }

    // 空间复杂度不满足
    private int solution_1(int[] arr) {
        int ln = arr.length;
        HashSet<Integer> set = new HashSet<>(ln);
        for (int i = 0; i < ln; i++) {
            if (!set.contains(arr[i])) set.add(arr[i]);
        }
        for (int i = 1; i <= ln; i++) {
            if (!set.contains(i)) return i;
        }
        return ln + 1;
    }

    // 思想上符合时间O(n)，空间O(1)，但是考虑到函数入栈，空间还是不满足
    private int solution_2(int[] arr) {
        int ln = arr.length;
        for (int i = 0; i < ln; i++) {
            recursiveSeti(arr, arr[i]);
        }
        for (int i = 0; i < ln; i++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return ln + 1;
    }

    private void recursiveSeti(int[] arr, int value) {
        int nextIndex = value - 1;  // 对当前值对应的下一个索引进行递归操作，比如当前值为3，则下一次要操作的位置为2
        if (nextIndex < 0 || nextIndex >= arr.length || arr[nextIndex] == nextIndex + 1) {
            return;
        }
        int nextValue = arr[nextIndex];
        arr[nextIndex] = nextIndex + 1; // 先对nextIndex设置value，避免死循环
        recursiveSeti(arr, nextValue);
    }

    // 将上面方法改成非递归的
    public int solution_3(int[] arr) {
        int ln = arr.length;
        for (int i = 0; i < ln; i++) {
            int value = arr[i];
            int nextIndex = value - 1;
            while (nextIndex >= 0 && nextIndex < ln && arr[nextIndex] != nextIndex + 1) {
                int nextValue = arr[nextIndex];
                arr[nextIndex] = nextIndex + 1;
                nextIndex = nextValue - 1;
            }
        }
        for (int i = 0; i < ln; i++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return ln + 1;
    }
}
