package leetcode.贪心.种花问题;

public class Solution {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(new Solution().canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int r = 0;
        int size = flowerbed.length;
        if (size == 1) {
            if (n == 0) return true;
            else if (n == 1 && flowerbed[0] == 0) return true;
            else return false;
        }
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    r++;
                    flowerbed[i] = 1;
                }
            } else if (i == size - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    r++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                r++;
            }
        }
        return r >= n;
    }
}
