package com.datastructure.singlelinkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Epic
 * @create 2021-02-21 11:11
 */
public class ReversePrintDemo {

    @Test
    //逆序打印
    public void test(){
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList list = new SingleLinkedList();
        list.add(hero1);
        list.add(hero4);
        list.add(hero2);
		list.add(hero3);

        ReversePrintDemo reverse = new ReversePrintDemo();
        reverse.reversePrint(list.getHead());

    }


    public void reversePrint(HeroNode head){
        //判断
        if (head == null){
            System.out.println("链表为空，不能打印");
        }
        HeroNode cur = head.next;
        //创建一个栈
        Stack<HeroNode> stack = new Stack<>();
       //入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        //出栈
        while (stack.size() > 0){
            HeroNode pop = stack.pop();
            System.out.println(pop);
        }
    }

}
