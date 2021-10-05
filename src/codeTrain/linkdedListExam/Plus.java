package codeTrain.linkdedListExam;


/**
 * @author Epic
 * @create 2021-09-15 20:03
 */
public class Plus {
  public static void main(String[] args) {
    ListNode1 n1 = new ListNode1(1);
    n1.next = new ListNode1(2);
    n1.next.next = new ListNode1(3);

    ListNode1 n2 = new ListNode1(3);
    n2.next = new ListNode1(2);
    n2.next.next = new ListNode1(1);
    ListNode1 listNode1 = plusAB(n1, n2);
    while (listNode1 != null){
      System.out.println(listNode1.val);
      listNode1 = listNode1.next;
    }

  }
  public static ListNode1 plusAB(ListNode1 a, ListNode1 b) {
    // write code here
    if(a==null||b==null) {
      return null;
    }
    ListNode1 cur=a;
    int temp=0;
    while(cur!=null){
      if(b==null) {
        break;//b链表结束，咱就退出
      }
      temp+=cur.val+b.val;//当前位累加
      cur.val=temp%10;//a链表存储和
      temp=temp/10;//取进位
      if(cur.next==null&&b.next!=null) {
        cur.next=new ListNode1(0);//a长度没b长就增加长度
      }
      if(cur.next==null&&b.next==null&&temp!=0) {
        cur.next=new ListNode1(temp);//加到末尾，如果有进位，就增加进位节点
      }
      cur=cur.next;
      b=b.next;
    }
    return a;

  }
}
class ListNode1 {
  int val;
  ListNode1 next = null;

  ListNode1(int val) {
    this.val = val;
  }
}