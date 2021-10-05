package algorithmExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-26 20:43
 * @Description 科大讯飞笔试02，ac代码
 */
public class Kedaxunfei02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    //排序
    Arrays.sort(arr);
    HashMap<Integer ,Integer > map = new HashMap<>();
    int max = 0;
    for (int i = 0; i < n; i++) {
      if(map.containsKey(arr[i])){
        map.put(arr[i],map.get(arr[i])+1);
      }else{
        map.put(arr[i],1);
      }
    }
    for (Integer m: map.values()) {
      max = Math.max(max,m);
    }
    System.out.println(max);


  }
}
