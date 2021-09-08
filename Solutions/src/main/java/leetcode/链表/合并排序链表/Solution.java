package leetcode.链表.合并排序链表;

import common.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length, counter = 0;
        for(int i=0; i<n; i++) if(lists[i] != null) counter++;
        ListNode phantom = new ListNode(-1), t = phantom;
        while(counter > 0){
            ListNode min = null; int minIndex = -1;
            for(int i=0; i<n; i++){
                if(lists[i] != null){
                    if(min == null || min.val > lists[i].val){
                        min = lists[i];
                        minIndex = i;
                    }
                }
            }
            t.next = min;
            lists[minIndex] = lists[minIndex].next;
            t = t.next;
            if(lists[minIndex] == null) counter--;
            if(counter <= 0) break;
        }
        return phantom.next;
    }
}
