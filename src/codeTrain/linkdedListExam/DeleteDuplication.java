package codeTrain.linkdedListExam;


import algorithmExam.ListNode;

/**
 * @author Epic
 * @create 2021-09-15 21:25
 * @Description 删除链表中重复的节点
 */
public class DeleteDuplication {
//  public ListNode deleteDuplication(ListNode pHead) {
//
//  }
//  public static ListNode getNode(ListNode node){
//    while (node != null){
//      if (node.val == node.next.val){
//        node = node.next;
//      }else {
//        return node;
//      }
//    }
//    return node.next  ;
//  }
//  public static boolean isDup(ListNode node){
//    if (node.val != node.next.val){
//      return false;
//    }
//    return true;
//  }
//  public ListNode deleteDuplication(ListNode pHead){
//
//    if (pHead==null || pHead.next==null){return pHead;}
//    ListNode Head = new ListNode(0);
//    Head.next = pHead;
//    ListNode pre  = Head;
//    ListNode last = Head.next;
//    while (last!=null){
//      if(last.next!=null && last.val == last.next.val){
//        // 找到最后的一个相同节点
//        while (last.next!=null && last.val == last.next.val){
//          last = last.next;
//        }
//        pre.next = last.next;
//        last = last.next;
//      }else{
//        pre = pre.next;
//        last = last.next;
//      }
//    }
//    return Head.next;
//  }

}
