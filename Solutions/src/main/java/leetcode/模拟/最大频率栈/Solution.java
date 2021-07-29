/**
 * @author Everett
 * @date 6/28/2021 12:35 PM
 */
package leetcode.模拟.最大频率栈;

import lombok.*;

import java.util.HashMap;
import java.util.Stack;

@ToString
@NoArgsConstructor
class FreqStack {
    // max frequency
    private int maxFreq;
    // fv
    private HashMap<Integer, Stack<Integer>> fv = new HashMap<>();
    // vf
    private HashMap<Integer, Integer> vf = new HashMap<>();

    public void push(int v) {
        int freq = vf.getOrDefault(v, 0) + 1;
        vf.put(v, freq);
        fv.putIfAbsent(freq, new Stack<>());
        fv.get(freq).push(v);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> vals = fv.get(maxFreq);
        Integer v = vals.pop();
        Integer freq = vf.get(v) - 1;
        vf.put(v, freq);
        if (vals.isEmpty()) maxFreq--;
        return v;
    }
}

public class Solution {
    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(2);
        fs.push(7);
        fs.push(2);
        fs.push(7);
        fs.push(2);
        fs.push(4);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
