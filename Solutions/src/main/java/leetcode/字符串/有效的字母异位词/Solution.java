package leetcode.字符串.有效的字母异位词;

/**
 * leetcode 242
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if (n != m) return false;
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        int x, y;
        for (int i = 0; i < n; i++) {
            x = s.charAt(i);
            y = t.charAt(i);
            arr1[x]++;
            arr2[y]++;
        }
        for (int i = 0; i < 256; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
