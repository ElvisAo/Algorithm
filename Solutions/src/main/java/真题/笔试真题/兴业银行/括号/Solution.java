package 真题.笔试真题.兴业银行.括号;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String s = "1+2*(1+2)";
        System.out.println(new Solution().match(s));
        int[] nums = {1, 2, 3, 5, 6, 6};
        int target = 12;
        System.out.println(Arrays.toString(new Solution().search(nums, target)));
    }

    public boolean match(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        if (stack.pop() != '(')
                            return false;
                        else continue;
                    } else if (stack.isEmpty()) return false;
                    break;

                case ']':
                    if (!stack.isEmpty() && stack.pop() != '[') return false;
                    else if (stack.isEmpty()) return false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop() != '{') return false;
                    else if (stack.isEmpty()) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }


    public int[] search(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] r = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                r[0] = map.get(target - nums[i]);
                r[1] = i;
                break;
            } else map.put(nums[i], i);
        }
        return r;
    }
}