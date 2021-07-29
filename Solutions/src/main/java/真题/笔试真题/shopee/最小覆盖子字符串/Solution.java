package 真题.笔试真题.shopee.最小覆盖子字符串;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMinOverrideSubString("abcd", "bc"));
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * <p>
     * <p>
     * find min override sub string
     *
     * @param source string字符串
     * @param target string字符串
     * @return string字符串
     */
    public String findMinOverrideSubString(String source, String target) {
        int lns = source.length(), lnt = target.length();
        int left = 0, right = -1; // 双闭
        boolean isAllMatch = false;
//        boolean isContinue = true;
        while (!isAllMatch && right < lns) {
            right++;
            while (right - left >= lnt && SequenceContains(source.substring(left, right), target)) {
                isAllMatch = true;
                left++;
            }
        }
        String r = source.substring(left - 1, right);
        String next = findMinOverrideSubString(source.substring(left), target);
        return !isAllMatch ? "" : (r.length() <= next.length() ? r : next);
    }

    private boolean SequenceContains(String s, String t) {
        int i = 0, j = 0;
        int lns = s.length(), lnt = t.length();
        while (i < lns && j < lnt) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == lnt;
    }
}
