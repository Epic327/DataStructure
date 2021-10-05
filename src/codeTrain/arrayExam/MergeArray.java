package codeTrain.arrayExam;

import java.util.Arrays;

/**
 * @author Epic
 * @create 2021-09-28 11:33
 * @Description 合并两个有序数组，有个bug，不能从0开始
 */
public class MergeArray {
  public static void main(String[] args) {
    int[] arr1 = {0,1,2,5};
    int[] arr2 = {1,3,4,4,5,6};
    int[] res = mergeArray(arr1,arr2);
//    Arrays.sort(res);
    Arrays.stream(res).forEach(System.out::print);
  }

  private static int[] mergeArray(int[] arr1, int[] arr2) {
    int[] res = new int[arr1.length+arr2.length];
    int i = 0, j = 0, k = 0;
    while (i < arr1.length && j < arr2.length){
      if (arr1[i] == arr2[j]){
        res[k] = arr1[i];
        res[k+1] = arr2[j];
      }else if (arr1[i] < arr2[j]){
        res[k] = arr1[i];
        res[k+1] = arr2[j];
      }else {
        res[k] = arr2[j];
        res[k+1] = arr1[i];
      }
      i++;
      j++;
      k+=2;
    }
    //退出循环后，肯定有一个数组还没排完,找出较短和较长的哪一个，把较长的那一个数组，剩余的给加到res里面
    int[] long1 = arr1.length > arr2.length ? arr1:arr2;
    int[] short1 = arr1.length < arr2.length ? arr1:arr2;
    int s1  = short1.length;
    int l1 = long1.length;
    while ( k < res.length && s1 < l1 ){
      res[k] = long1[s1];
      k++;
      s1++;
    }
    return res;
  }
}
