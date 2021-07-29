package 二叉树右视图;

import demo.defaultDemo;

import java.util.*;

public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @return int整型一维数组
     */
    class Node{
        int val;
        Node left, right;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println(defaultDemo.prop2);
        int[] x = {1,2,4,5,3}, z = {4,2,5,1,3};
        int[] solve = new Solution().solve(x, z);
        System.out.println(Arrays.toString(solve));
    }
    public int[] solve (int[] qianxu, int[] zhongxu) {
        // write code here
        Node root = recreateTree(qianxu,0,qianxu.length-1,zhongxu,0,zhongxu.length-1);
        return bfs(root, qianxu.length);
    }

    private int[] bfs(Node root, int sz){
        ArrayList<Node> q = new ArrayList<>();
        Node t = root;
        q.add(t);
        int[] r = new int[sz];
        int ri=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node cur = q.remove(0);
                if(i==size-1){
                    r[ri++]=cur.val;
                }
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return Arrays.copyOf(r, ri);
    }

    private Node recreateTree(int[] pre, int ps, int pe, int[] in, int is, int ie){
        for(int i=is; i<=ie; i++){
            if(in[i]==pre[ps]){
                Node root = new Node(in[i]);
                root.left = recreateTree(pre, ps+1, ps+i-is, in, is, i-1);
                root.right = recreateTree(pre, ps+i-is+1, pe, in, i+1, ie);
                return root;
            }
        }
        return null;
    }
}
