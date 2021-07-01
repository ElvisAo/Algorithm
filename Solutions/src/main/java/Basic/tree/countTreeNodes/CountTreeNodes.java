package Basic.tree.countTreeNodes;

import Basic.tree.binarytree.BinaryTreeUtil;
import Basic.tree.binarytree.Node;

public class CountTreeNodes {
    private int count(Node root) {
        int hl = 0, hr = 0;
        Node l = root, r = root;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        if (hr == hl) return (int) Math.pow(2, hr) - 1;
        else return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        Node tree = BinaryTreeUtil.getBinaryTree();
        System.out.println(new CountTreeNodes().count(tree));
    }
}
