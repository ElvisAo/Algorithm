/**
 * @author Everett
 * @date 6/29/2021 4:22 PM
 */
package leetcode.扁平化嵌套列表迭代器.解法优化;

import leetcode.扁平化嵌套列表迭代器.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = this.list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) list.addFirst(first.get(i));
        }
        return !list.isEmpty();
    }
}

public class Solution {

}
