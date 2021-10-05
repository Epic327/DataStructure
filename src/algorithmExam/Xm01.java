package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-09 17:34
 * @Description 合并两个有序链表
 */
public class Xm01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s1 = sc.nextLine().trim().split(" ");
    String[] s2 = sc.nextLine().trim().split(" ");

    int len1 = s1.length;
    int[] node1 = new int[len1];
    for (int i = 0; i < len1 ; i++) {
      node1[i] = Integer.parseInt(s1[i]);
    }

    int len2 = s2.length;
    int[] node2 = new int[len2];
    for (int i = 0; i < len2 ; i++) {
      node2[i] = Integer.parseInt(s2[i]);
    }
    ListNode t1 = arrayToNode(node1);
    ListNode t2 = arrayToNode(node2);

    ListNode dum = new ListNode(0);
    ListNode cur = dum;

    while (t1 != null && t2 != null){
      if(t1.val < t2.val) {
        cur.next = t1;
        t1 = t1.next;
      }else{
        cur.next = t2;
        t2 = t2.next;
      }
      cur = cur.next;
    }
    //退出循环，t1,t2必定有一个是为null
    cur.next = t1 != null ? t1 : t2;
    ListNode res = dum.next;
    while (res != null){
      System.out.print(res.val);
      System.out.print(" ");
      res = res.next;
    }
  }

  //把数组变成链表
  public static ListNode arrayToNode(int[] array){
    ListNode head = new ListNode(array[0]);
    ListNode temp = head;
    for (int i = 1; i <array.length ; i++) {
      temp.next = new ListNode(array[i]);
      temp = temp.next;
    }
    return head;
  }

}

