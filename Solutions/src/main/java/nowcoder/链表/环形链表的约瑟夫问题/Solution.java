/**
 * @author Everett
 * @date 6/30/2021 6:21 PM
 */
package nowcoder.链表.环形链表的约瑟夫问题;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().ysf(5, 2));
    }

    public int ysf(int n, int m) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() > 1) {
            for (int i = 1; i < m; i++) {
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }
}
