/**
 * @description: TODO
 * @author Everett
 * @date 7/1/2021 6:25 PM
 */
package nowcoder.汉诺塔问题;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new Solution().getSolution(2);
        for (String s : list) System.out.println(s);
    }

    public ArrayList<String> getSolution(int n) {
        hanoi(n, "left", "mid", "right");
        return r;
    }

    ArrayList<String> r = new ArrayList<>();

    private void hanoi(int n, String left, String mid, String right) {
        if (n == 1) {
            r.add("move from " + left + " to " + right);
            return;
        }
        hanoi(n - 1, left, right, mid);
        r.add("move from " + left + " to " + right);
        hanoi(n - 1, mid, left, right);
    }
}
