package nowcoder.字符串.比较版本号;

public class Solution {
    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1.0";
        System.out.println(new Solution().compare(version1, version2));
    }

    public int compare(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int ln = Math.max(s1.length, s2.length);
        for (int i = 0; i < ln; i++) {
            int x = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int y = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }
}

