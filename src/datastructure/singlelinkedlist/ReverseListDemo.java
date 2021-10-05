package com.datastructure.singlelinkedlist;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-02-21 15:18
 */
public class ReverseListDemo {
    @Test
    public void test(){
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建单链表的对象
        SingleLinkedList list = new SingleLinkedList();
        list.add(hero1);
        list.add(hero4);
        list.add(hero2);
        list.add(hero3);
        //创建反转链表的对象
        ReverseListDemo revList = new ReverseListDemo();
        revList.reverseList(list.getHead());

        list.show();

    }
    public void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            //先把cur.next保存起来
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur 连接到新的链表上
            reverseHead.next = cur;
            //让cur后移
            cur = next;
        }
        //再将head.next指向reverse.next，实现单链表的反转
        head.next = reverseHead.next;
    }

}
