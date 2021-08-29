package Basic.tree.math.寻找2到n的素数;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int n = 100;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 2; j * i <= n; j++) list.remove(new Integer(j * i));
        }
        list.stream().forEach(x -> System.out.println(x));
    }
}
