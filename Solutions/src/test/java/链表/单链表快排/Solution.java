package 链表.单链表快排;

import common.ListNode;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    static int R = 10;

    public static void main(String[] args) {
        int[] arr = new int[R];
        for (int i = 0; i < R; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        quickSort(head.next, null);
        head = head.next;
        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
    }

    public static void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode pivot = partition(head, tail);
            quickSort(head, pivot); // 左闭右开
            quickSort(pivot.next, tail);
        }
    }

    private static ListNode partition(ListNode head, ListNode tail) {
        if (head == tail) return head;
        int pval = head.val;
        /**
         * slow记录while结束时比pivot大的
         * pre记录最后一个比pivot小的
         * fast记录while结束时比pivot小的
         * {@为什么一定需要pre？为了能有效把比pivot小的换到其前面去，因为如果只使用一个节点的话来记录比pivot小的话，当该节点遍历到tail就无法再操作}
         */
        ListNode pre = head, fast, slow = head.next;
        while (true) {
            while (slow != tail && slow.val < pval) {
                pre = slow;
                slow = slow.next;
            }
            if (slow == tail) break;
            /**
             * {@slow已经比pivot大了，继续从slow后面找比pivot小的，然后交换slow、fast}
             */
            fast = slow.next;
            while (fast != tail && fast.val > pval) fast = fast.next;
            if (fast == tail) break;
            swap(fast, slow);
        }
        swap(pre, head); // 开始是从pre取出来的，再放回去
        return pre;
    }

    private static void swap(ListNode o1, ListNode o2) {
        int t = o1.val;
        o1.val = o2.val;
        o2.val = t;
    }
}
