package codetop.哈希表.两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * leetcode 349
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        Arrays.stream(nums1).forEach(x -> set1.add(x));
        Arrays.stream(nums2).forEach(x -> set2.add(x));
        LinkedList<Integer> list = new LinkedList<>();
        set1.stream().forEach(x -> {
            if (set2.contains(x)) {
                list.offerLast(x);
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
