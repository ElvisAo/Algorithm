package nowcoder.栈.两个栈实现队列;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    Stack<Integer> stack1 = new Stack<Integer>();   // 存元素
    Stack<Integer> stack2 = new Stack<Integer>();   // 取元素

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        else {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
}
