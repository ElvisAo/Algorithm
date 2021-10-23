package Labuladong及巧妙算法.字符串.旋转字符串;

public class Solution {
    public boolean rotateString(String s, String goal) {
        return (s.length() == goal.length()) && (s + s).contains(goal);
    }
}
