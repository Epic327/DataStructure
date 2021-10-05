package com.datastructure.singlelinkedlist;

/**
 * @author Epic
 * @create 2021-02-21 11:22
 */
public class SingleLinkedList {
    //首先初始化一个头节点、
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public  HeroNode getHead() {
        return head;
    }

    /**
     * @Describe 添加节点到单向链表
     * @Logistic 思路:当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode) {
        //因为头节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表找到最后
        while (true) {
            if (temp.next == null) {
                break; //说明找到了最后
            }
            //没有找到，temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的 节点
        temp.next = heroNode;

    }

    /**
     * @Describe 根据排名将英雄插入到指定位置
     * @Logistic (如果有这个排名 ， 则添加失败 ， 并给出提示)
     */

    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明编号已经存在
                flag = false;
                break;
            }
            //上述情况都不满足,temp后移
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.println("准备插入的英雄编号" + heroNode.no + "已经存在，不能加入");
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }
    /**
     * @Describe 修改节点的信息, 根据no编号来修改，即no编号不能改
     * @Logistic 根据 newHeroNode 的 no 来修改即可
     */

    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;//找到编号
            }
            //没有找到，temp后移
            temp = temp.next;
        }
        //根据flag来判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.println("没有找到编号为" + newHeroNode.no + "的节点");
        }
    }

    /**
     * @Describe 删除节点
     * @Logistic 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 	         2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
     */

    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                //找到待删除的节点
                flag = true;
                break;
            }
            //没找到，temp后移
            temp = temp.next;
        }
        //根据flag判断
        if(flag){
            //找到，可以删除
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的" + no + "号节点不存在");
        }
    }

    /**
     * @Describe 显示链表
     * @logistics 遍历
     */

    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，需要一个辅助节点temp来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }





}
