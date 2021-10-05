package com.datastructure.singlelinkedlist;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-02-24 15:34
 */
public class CircleSingleLinkedList {
    //定义一个first节点，当前没有编号
    private Boy first = null;
    @Test
    public void test(){
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.countBoy(1,2,5);
    }

    /**
     * @Describe 根据用户的输入，计算小孩出圈的顺序
     * @param startNo 从第几个小孩开始数
     * @param countNum 数几下
     * @param num 最初一共有多少个小孩在圈中
     */
   public void countBoy(int startNo, int countNum, int num){
        //先对数据进行校验
       if (first == null || startNo < 1 || startNo > num || countNum < 1 || countNum >num){
           System.out.println("参数输入有误，请重新输入");
       }
       //创建辅助指针，帮助小孩出圈
       Boy helper = first;
       //事先helper应该指向环形链表的最后这个节点
       while (true){
           if (helper.getNext() == first){
               break;
           }
           helper = helper.getNext();
       }
       //小孩报数前，我们要确定startNo在哪一位，假如定位到第二个节点开始报，则需要遍历 2 - 1 次
       //来确定first和helper的位置
       for (int i = 1 ; i <= startNo -1 ; i++){
           first = first.getNext();
           helper = helper.getNext();
       }
       //小孩开始报数了，我们要根据countNum来确定第几个小孩出圈，则first和helper指针需要
       //移动countNum - 1 次 ，first指针指到的那个小孩出圈
       while (true){
           if (helper == first){
               //圈里只有一个节点了
               break;
           }
           //让 first 和 helper 指针同时 的移动 countNum - 1
           for (int j = 0; j < countNum - 1; j++) {
               first = first.getNext();
               helper = helper.getNext();
           }
           //这是first指向的就是要出圈的小孩
           System.out.println("小孩"+first.getNo() + "出圈");
           //把first后移
           first = first.getNext();
           //help.next指向first
           helper.setNext(first);
       }
       System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

   }

    /**
     * @Describe 添加小孩到环里的方法，构建一个环形的单向链表
     * @param num 小孩的个数
     */
    public void addBoy(int num){
        //先做一个num校验
        if (num < 1){
            System.out.println("num的值不对");
            return;
        }
        //定义一个辅助指针curBoy,帮组构建环形链表
        Boy curBoy = null;
        //使用for来创建我们的环形链表
        for (int i = 1 ; i <= num ; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1){
                //first指向boy
                first = boy;
                //first.next指向first
                first.setNext(first);
                //curBoy指向第一个小孩
                curBoy = first;
            }else {
                //如果不是第一个小孩了，curBoy.next指向下一个小孩
                curBoy.setNext(boy);
                //boy.next指向first
                boy.setNext(first);
                //curBoy再指向boy,即后移
                curBoy = boy;

            }
        }
    }

    /**
     * @Describe 遍历当前的环形链表
     */
    public void showBoy(){
        //判断当前环形链表是否为空
        if (first == null){
            System.out.println("当前链表为空");
        }
        //因为first不能动，因此我们任然使用一个辅助指针来完成遍历
        Boy curBoy = first;
        //遍历
        while (true){
            System.out.printf("小孩的编号 %d \n" ,curBoy.getNo());
            //如果curBoy.next指向了first，即遍历结束
            if (curBoy.getNext() == first){
                break;
            }
            //如果还没到最后，curBoy就后移
            curBoy = curBoy.getNext();
        }
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}