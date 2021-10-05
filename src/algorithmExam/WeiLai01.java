package algorithmExam;
import java.util.*;
/**
 * @author Epic
 * @create 2021-09-11 19:43
 */
public class WeiLai01 {
  public static void main(String[] args) {
    int[] arr = new int[]{23,34,78,56,99,300,258};
    int k = 100;
    int max = getMax(arr, k);
    System.out.println(max);
  }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定一个整数数组arr和一个数K，返回数组中小于K的最大的两个数之和。如果不存在小于K的两数之和，返回-1。
     * @param arr int整型一维数组 数组
     * @param k int整型 相加的上限
     * @return int整型
     */
    public static int getMax (int[] arr, int k) {
      // write code here

      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] < k){
          list.add(arr[i]);
        }
      }
      if (list == null || list.size() ==1){
        return -1;
      }
      //集合转数组
      Integer[] lists = list.toArray(new Integer[list.size()]);
      Arrays.sort(lists);
      int res = lists[lists.length-1]+lists[lists.length-2];
      return res;
    }

  public int getMax1 (int[] arr, int k) {
      if (arr == null || arr.length ==0){
        return -1;
      }
      Arrays.sort(arr);
      int l = 0;
      int r = arr.length-1;
      int res = Integer.MIN_VALUE;
      while(l<r){
        if(arr[l]+arr[r] >=k){
          r--;
        }else {
          res  = Math.max(res,arr[l] + arr[r]);
          l++;
        }
      }
      return res == Integer.MIN_VALUE ? -1 : res;
  }


  public static  String[] split (String str) {
    // write code here
    char[] ch = str.toCharArray();
    int len = ch.length;
    int l = 0;
    int r = ch.length-1;
    List<String> ans = new ArrayList<>();
    List<List<Character>> lists = new ArrayList<>();

    for (int i = 0,j = 0 ; i < len; i++) {
      if (str.charAt(i) !='{'){
        lists.add(new ArrayList<>(Arrays.asList(str.charAt(i))));
      }else {
        j = i;
        while (j < len && str.charAt(j) !='}'){
          j++;
        }
        String sub = str.substring(i+1,j);
        String[] ss = sub.split(",");
        List<Character> list = new ArrayList<>();
        for (String s : ss){
          list.add(s.charAt(0));
        }
        //加入后排序
        list.sort((c1,c2) -> Character.compare(c1,c2));
        lists.add(list);
        i = j;
      }
    }
    dfs(0,new StringBuilder(),lists,ans);
    String[] res = new String[ans.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = ans.get(i);
    }
    return res;

  }
  private static void dfs(int id,StringBuilder sb,List<List<Character>> lists,List<String> res){
      //所有的list，遍历完加入res
    if(id == lists.size()){
      res.add(sb.toString());
      return;
    }
    for (int i = 0; i<lists.get(id).size();i++){
      sb.append(lists.get(id).get(i));
      dfs(id+1,sb,lists,res);
    }
    sb.setLength(sb.length()-1);

  }


}
