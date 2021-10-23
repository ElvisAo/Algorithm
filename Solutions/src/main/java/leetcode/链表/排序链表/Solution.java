package leetcode.链表.排序链表;

import common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 4;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 4;
        System.out.println(Arrays.toString(arr));
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        ListNode listNode = new Exercise().solution_1(head.next);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * {@借助java-api}
     *
     * @param head
     * @return
     */
    public ListNode solution_1(ListNode head) {
        if (head == null || head.next == null) return head;
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort((x, y) -> x.val - y.val);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }


    /**
     * {@单链表快排：交换节点值而非节点}
     *
     * @param head
     * @return
     */
    public ListNode solution_2(ListNode head) {
        if (head == null || head.next == null) return head;
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode pivot = partition(head, end);
            quickSort(head, pivot);
            quickSort(pivot, end);
        }
    }

    private ListNode partition(ListNode head, ListNode end) {
        int pivot = head.val;   // 取出pivot的值
        /**
         * 注意：比较巧妙的一点是使用pre来记录了最后一个小于pivot的节点
         */
        ListNode pre = head, p1 = head.next, p2;
        while (true) {
            while (p1 != end && p1.val < pivot) {
                pre = p1;   // pre记录小于pivot的最后一个节点（循环结束后，p1已经大于等于pivot了 ）
                p1 = p1.next;
            }
            if (p1 == end) break;
            p2 = p1.next;   // p1.val已经>=pivot了，P2从p1后面开始找比pivot小的
            while (p2 != end && p2.val > pivot) p2 = p2.next;   // 循环结束后，p2小于或等于pivot
            if (p2 == end) break;
            swap(p1, p2);
        }
        swap(head, pre);    // 最开始是以head的val作为pivot，结束时pre是小于pivot的最后一个节点，将他们交换
        return pre;
    }

    private void swap(ListNode node1, ListNode node2) {
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }

    /**
     * {@归并排序}
     *
     * @param head
     * @return
     */
    public ListNode solution_3(ListNode head) {
        if (head == null || head.next == null) return head;
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode end) {
        if (head == end) return head;
        ListNode slow = head, fast = head;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode post = sort(slow.next, end);
        slow.next = null;   // 将前后两半截链表分开
        ListNode pre = sort(head, slow);
        return merge(post, pre);
    }

    private ListNode merge(ListNode post, ListNode pre) {
        if (pre == null || post == null) return pre == null ? post : pre;
        if (pre.val < post.val) {
            pre.next = merge(post, pre.next);
            return pre;
        } else {
            post.next = merge(post.next, pre);
            return post;
        }
    }
}
