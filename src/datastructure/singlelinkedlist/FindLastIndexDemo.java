package com.datastructure.singlelinkedlist;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-02-21 16:16
 */
public class FindLastIndexDemo {
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
        FindLastIndexDemo indexDemo = new FindLastIndexDemo();
        HeroNode lastIndexNode = indexDemo.findLastIndexNode(list.getHead(), 2);
        System.out.println(lastIndexNode);
    }

    /**
     * @Describe 查找单链表中的倒数第k个结点 【新浪面试题】
     * @Logistic    1. 编写一个方法，接收head节点，同时接收一个index
     * 	            2. index 表示是倒数第index个节点
     * 	            3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 	            4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 	            5. 如果找到了，则返回该节点，否则返回nulll
     * @param head
     * @param index
     * @return
     */
    public HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            return null;
        }
        //获取链表的有效长度
        int size = GetlLengthDemo.getLength(head);
        //先做一个index校验
        if (index <= 0 || index > size){
            return  null;
        }
        HeroNode  cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return  cur;

    }
}
