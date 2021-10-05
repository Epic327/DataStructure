package com.datastructure.singlelinkedlist;

/**
 * @author Epic
 * @create 2021-02-21 16:09
 */
public class GetlLengthDemo {
    /**
     * @Describe  获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     * @param head
     * @return length
     */
    public static  int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

}
