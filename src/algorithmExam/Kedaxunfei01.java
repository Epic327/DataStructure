package algorithmExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-26 19:54
 * @Description 科大讯飞笔试01 ，ac代码
 */
public class Kedaxunfei01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int k = sc.nextInt();
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      List<Integer> l1 = new ArrayList<>();
      l1.add(a1);
      l1.add(a2);
      list.add(l1);
    }
    for (int i = 0; i < list.size(); i++) {
      List<Integer> s1 = list.get(i);
      int p1 = s1.get(0);
      int p2 = s1.get(1);
      if(p1 == x){
        int temp = p1;
        p1 = p2;
        p2 = temp;
        x= p1;
      }else if(p2 == x){
        int temp = p1;
        p1 = p2;
        p2 = temp;
        x = p2;
      }else{
        continue;
      }
    }
    System.out.println(x);

  }
}
