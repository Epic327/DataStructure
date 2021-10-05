package algorithmExam;
import java.util.*;

/**
 * @author Epic
 * @create 2021-09-09 21:12
 */
class Node{
  int val;
  Node next;
  Node(int a){val = a;}
}
public class Xm012{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Node head1 = f(sc.nextLine().split(" "));//将输入的数字都存入链表
    Node head2 = f(sc.nextLine().split(" "));
    Node p1 = head1, p2 = head2, res = null;//用res保存合并后链表的头指针
    if(head1.val <= head2.val){//较小的一个当作头指针
      res = head1;
      p1 = p1.next;
    }else{
      res = head2;
      p2 = p2.next;
    }
    Node r = res;//用r保存合并后链表的尾指针
    while(p1 != null && p2 != null){
      if(p1.val <= p2.val){//总是压入较小的一个
        r.next = p1;
        r = r.next;
        p1 = p1.next;
      }else{
        r.next = p2;
        r = r.next;
        p2 = p2.next;
      }
    }
    if(p1 != null) r.next = p1;//将剩下仍然没压完的一条链，全部压入
    if(p2 != null) r.next = p2;
    System.out.print(res.val);//打印第一个结果
    res = res.next;
    while(res != null){
      System.out.print(" ");//打印中间的空格
      System.out.print(res.val);
      res = res.next;
    }
  }
  public static Node f(String[] s){//将输入的数字都存入链表
    Node head = new Node(Integer.valueOf(s[0]));
    Node temp = head;
    for(int i = 1; i < s.length; ++i){
      temp.next = new Node(Integer.valueOf(s[i]));
      temp = temp.next;
    }
    return head;
  }
}
