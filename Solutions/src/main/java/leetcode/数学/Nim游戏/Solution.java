package leetcode.数学.Nim游戏;

/***
 * leetcode 292
 * 我是先手
 * 分析：
 * 1~3赢
 * 4输
 * 5~7赢
 * ...
 * 4的倍数的人会输
 */
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
