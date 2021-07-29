package nowcoder.history.shopee.罗马数字转整数;

import java.util.HashMap;

/**
 * 罗马数字中小的数字在大的数字的右边。但也存在6种特例
 */
public class Main {
    /**
     * @param s string字符串
     * @return int整型
     */
    public int romanToInt(String s) {
        // write code here
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s == null || "".equals(s)) return 0;
        if (s.length() == 1) return map.get(s.charAt(0));
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                //三种特例
                if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    res -= map.get(s.charAt(i));
                } else if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    res -= map.get(s.charAt(i));
                } else if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    res -= map.get(s.charAt(i));
                }
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}