package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-15 15:12
 */
public class Shein01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int index = sc.nextInt();
    int[] node = new int[n];
    for (int i = 0; i < n; i++) {
      node[i] = sc.nextInt();
    }
    Node1 head = intToNode(node,n);
    Node1 dum = new Node1(0);

    Node1 pre = head;
    Node1 cur = head.next;
    int count = 1;
    while (cur != null){
      if (count == index - 1){
        pre.next = cur.next;
        break;
      }
      count++;
      pre = pre.next;
      cur = cur.next;
    }
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }
  public  static Node1 intToNode(int[] node ,int n){
    Node1 head = new Node1(node[0]);
    Node1 temp = head;
    for (int i = 1; i < n; i++) {
      temp.next = new Node1(node[i]);
      temp = temp.next;
    }
    return head;
  }
}

class Node1{
  int val;
  Node1 next;

  public Node1(int val) {
    this.val = val;
  }


}
