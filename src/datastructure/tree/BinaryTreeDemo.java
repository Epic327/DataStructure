package com.datastructure.tree;

/**@Description 二叉树的遍历、查找、删除
 * @author Epic
 * @create 2021-03-28 22:48
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        System.out.println("前序查找");
//        binaryTree.preOrderSearch(5);
//        System.out.println("中序查找");
//        binaryTree.infixOrderSearch(5);
//        System.out.println("后序查找");
//        binaryTree.postOrderSearch(5);
        binaryTree.deleteNode(3);
        binaryTree.preOrder();




    }


}
//二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void deleteNode(int no){
        if (this.root != null && this.root.getNo() == no){
            this.root = null;
        }
        if (this.root != null){
            this.root.deleteNode(no);
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        HeroNode resNode = null;
        if (this.root != null){
            resNode = this.root.preOrderSearch(no);
            if (resNode != null){
                System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
            }else {
                System.out.printf("没有找到 no = %d 的英雄", no);
            }
        }else{
            System.out.println("二叉树为空,");
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.root != null){
            resNode = this.root.infixOrderSearch(no);
            if (resNode != null){
                System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
            }else {
                System.out.printf("没有找到 no = %d 的英雄", no);
            }
        }else{
            System.out.println("二叉树为空,");
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.root != null){
            resNode = this.root.postOrderSearch(no);
            if (resNode != null){
                System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
            }else {
                System.out.printf("没有找到 no = %d 的英雄", no);
            }
        }else{
            System.out.println("二叉树为空,");
        }
        return resNode;
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
//heroNode树节点
class HeroNode{
    private int  no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //删除节点
    public void deleteNode(int no){
        if (this.left != null && this.left.no == no){
            this.left =null;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
        }
        if (this.left != null){
            this.left.deleteNode(no);
        }
        if (this.right != null){
            this.right.deleteNode(no);
        }
    }

    //前序遍历查找
    public HeroNode  preOrderSearch(int no){
        //进入前序查找
        System.out.println("进入前序查找");
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            //如果不为空就说明找到了
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return  resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            //说明在左子树找到
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            //说明在左子树找到
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            //说明在右子树找到
            return resNode;
        }
        System.out.println("进入后序查找");
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    //前序遍历
    public void preOrder(){
        //输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        //递归向左子树后序遍历
        if (this.left != null){
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if(this.right != null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=" + name + "}";
    }


}
