/**
 * @author Everett
 * @date 6/29/2021 3:11 PM
 */
package leetcode.模拟.扁平化嵌套列表迭代器.直接展开;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

import leetcode.模拟.扁平化嵌套列表迭代器.NestedInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class NestInt implements NestedInteger {
    boolean isInt;
    Integer val;
    List<NestedInteger> list;

    public NestInt(Integer val) {
        this.val = val;
        this.isInt = true;
    }

    public NestInt(List<NestedInteger> list) {
        this.list = list;
        this.isInt = false;
    }

    @Override
    public boolean isInteger() {
        return this.isInt;
    }

    @Override
    public Integer getInteger() {
        return this.val;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.list;
    }
}

class NestedIterator implements Iterator<Integer> {

    private ArrayList<Integer> currentList;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        currentList = new ArrayList<>();
        init(nestedList);
        iterator = currentList.iterator();  // 一定要最后取iterator，否则会并发修改异常
    }

    private void init(List<NestedInteger> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()) {
                currentList.add(list.get(i).getInteger());
            } else init(list.get(i).getList());
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

public class Solution {
    public static void main(String[] args) {
        ArrayList<NestedInteger> list = new ArrayList<>();
        NestInt n1 = new NestInt(1);
        NestInt n2 = new NestInt(2);
        NestInt n3 = new NestInt(3);
        NestInt n4 = new NestInt(4);
        list.addAll(Arrays.asList(n1, n2));
        NestInt n5 = new NestInt(Arrays.asList(n3, n4));
        list.add(n5);
        NestedIterator iterator = new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

