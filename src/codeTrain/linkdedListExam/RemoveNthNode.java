package codeTrain.linkdedListExam;

import java.util.List;

import algorithmExam.ListNode;

/**
 * @author Epic
 * @create 2021-09-16 10:32
 */
public class RemoveNthNode {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode fast = dum;
    ListNode slow = dum;

    //先让fast走n步，
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    //然后fast和slow一起走，这样，slow到的位置就是倒数第n+1个
    while (fast.next != null){
      fast = fast.next;
      slow = slow.next;
    }
    //删除倒数第n个节点
    slow.next = slow.next.next;
    //返回头节点即可
    return dum.next;
  }
}
