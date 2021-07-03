package nowcoder.贪心.拼接所有的字符串产生字典序最小的字符串;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public String minString(String[] strs) {
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strs).forEach(x -> sb.append(x));
        return sb.toString();
    }
}
