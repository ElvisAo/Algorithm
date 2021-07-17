package common;

import lombok.Data;

@Data
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left, right;

    public TreeNode(T val) {
        this.val = val;
    }
}
