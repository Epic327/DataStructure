package algorithmExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Epic
 * @create 2021-09-16 14:18
 */
public class Xuanwu01 {
  public static void main(String[] args) {
      Integer[] num = {3,4,5,2};
      sortArray4(num);
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void sortArray(Integer[] arr,int flag) {
    int temp = 0;
    if (flag == -1) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
          if (arr[j + 1] > arr[j]) {
            temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
    } else if (flag == 1) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
          if (arr[j + 1] < arr[j]) {
            temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
    } else {
      return;
    }
  }
  public static void sortArray2(Integer[] arr , int flag){
    if (flag == 1){
      Arrays.sort(arr);
    }else if (flag == -1){
      Arrays.sort(arr,Collections.reverseOrder());
    }else{
      return;
    }
  }
  public static void sortArray3(Integer[] arr) {

    Arrays.sort(arr, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1-o2;
      }
    });
  }
  public static void sortArray4(Integer[] arr) {

    Arrays.sort(arr, (o1,o2) -> o1>o2 ? -1:1);
  }

}
