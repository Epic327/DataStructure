//package jzoffer;
//
//import javax.swing.tree.TreeNode;
//import java.awt.desktop.PreferencesEvent;
//import java.util.HashMap;
//
///**
// * @author Epic
// * @create 2021-05-10 21:13
// */
//public class BinaryTree {
//    int[] preOrder;
//    HashMap<Integer, Integer> dic = new HashMap<>();
//    public TreeNode buildTree(int[] preOrder, int[] inOrder){
//        this.preOrder = preOrder;
//
//        for (int i = 0; i < inOrder.length; i++) {
//            dic.put(inOrder[i],i);
//        }
//        return recur(0,0,inOrder.length-1);
//    }
//
//    public TreeNode recur(int root, int left, int right) {
//        //根据preOrder的root得到inOrder中的根节点对应的索引,根据i 来划分左右子树
//        int i = dic.get(preOrder[root]);
//        //新建一个以root为根节点的树
//        TreeNode node = new TreeNode(root);
//        //左子树递归(当前左子树的根节点，左边界，右边界)
//        //左子树的根的索引为先序中的根节点+1
//        //递归左子树的左边界为原来的中序in_left
//        //递归右子树的右边界为中序中的根节点索引-1
//        node.left = recur(root+1,left,i-1);
//
//        //右子树递归(当前右子树根节点，左边界，右边界)
//        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
//        //递归右子树的左边界为中序中当前根节点+1
//        //递归右子树的有边界为中序中原来右子树的边界
//        node.right = recur(root + i - left + 1,i+1,right);
//
//        //递归的终止条件
//        if(left > right){
//            return null;
//        }
//
//        return node;
//
//
//    }
//}
//
