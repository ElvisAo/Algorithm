package Labuladong及巧妙算法.数学.FisherYates洗牌算法;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {

    }

    public void shuffle(int[] array) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            swap(array, i, random.nextInt(i + 1));  // bound can't be reached
        }
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
