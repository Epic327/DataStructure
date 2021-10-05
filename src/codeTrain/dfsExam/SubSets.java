package codeTrain.dfsExam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-22 15:43
 */
public class SubSets {
  public static void main(String[] args) {
    int[] num = {1,2,3};
    List<List<Integer>> subsets = subsets(num);
    System.out.println(subsets);
  }
  public  static List<List<Integer>> subsets(int[] nums) {
    //new一个栈path,用来存放路径
    Deque<Integer> path = new ArrayDeque<>();
    //new一个res用来存放所有路径
    List<List<Integer>>  res = new ArrayList<>();

    //定义一个数组长度
    int len = nums.length;
    //调dfs回溯
    dfs(nums,0,path,res,len);
    return res;
  }
  public static void dfs(int[] nums,int level,Deque<Integer> path,List<List<Integer>> res,int len){
    res.add(new ArrayList<>(path));
    //结束递归条件,也可以不用写，
    if(level > nums.length){
      return;
    }
    for (int i = level ;i <len ; i++) {
      System.out.println("选择前" + path);
      //做出选择
      path.add(nums[i]);
      //到下层决策树
      dfs(nums,i+1,path,res,len);
      System.out.println("选择后" +path);
      //撤回选择
      path.removeLast();
//      System.out.println("选择后" +path);
    }
  }

}
