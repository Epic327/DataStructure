package algorithmExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-26 15:51
 */
public class Duxiaom02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(i+1);
    }
    int count = 1;
    int index = 0;
    while (list !=null){
      if (list.size()==1){
        break;
      }
      if (count % 2 != 0){
        index = (index + a- 1)%n; // 一个环求走了 a步的下标
      }else{
        index = (index + b -1)%n;  // 一个环求走了 b步的下标
      }
      list.remove(index); // 移除这个下标的元素
      count++;  //轮数加1
      n--;   //list个数-1
    }
    System.out.println(list.get(0));
  }


//  int idx = 0;
//  int temp = 0;
//        while (list.size() > 1){
//    temp++;
//    //偶数
//    if(temp % 2 == 0){
//      idx = (idx + b - 1) % n;
//    }else {
//      idx = (idx + a - 1) % n;
//    }
//    list.remove(idx);
//
//    n--;
//  }
//        System.out.println(list.get(0));
}
