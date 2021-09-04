package TopK;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(new Solution().solution(arr, 5)));
    }

    public int[] solution(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        Arrays.stream(arr).forEach(x -> queue.offer(x));
        int[] r = new int[k];
        for (int i = 0; i < k && i < arr.length; i++) {
            r[i] = queue.poll();
        }
        return r;
    }

}
