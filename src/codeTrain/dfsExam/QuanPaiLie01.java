package codeTrain.dfsExam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-16 20:53
 */
public class QuanPaiLie01 {
  public static void main(String[] args) {
    int[] ints = new int[]{1,2,3};
    List<List<Integer>> lists = permute(ints);
    System.out.println(lists);

  }
  public static List<List<Integer>> permute(int[] nums) {
      //new 一个动态数组用来，保存所有的结果；
    List<List<Integer>> res= new ArrayList<>();
    //数组的长度
    int len = nums.length;
    //new 一个栈，用来保存路径
    Deque<Integer> path = new ArrayDeque<>(len);
    //new 一个used数组，用来标记已经选择的数据
    boolean[] used = new boolean[len];
    //开始回溯+ dfs
    dfs(nums,0,len,used,path,res);
    return res;
  }

  /**
   *
   * @param num
   * @param depth
   * @param len
   * @param path
   * @param res
   * @param used
   */
  public static void dfs(int[] num, int depth, int len,boolean[] used, Deque<Integer> path,
                         List<List<Integer>> res) {
    //首先写结束递归的条件，把路径加入res
    if (depth == len) {
      res.add(new ArrayList<>(path));
      return;
    }
    //一共len 个选择,1,2,3
    for (int i = 0; i < len; i++) {
      if (!used[i]) {//如果还没有标记
        path.add(num[i]); //加入队列
        used[i] = true;  //标记为true

        System.out.println("  递归之前 => " + path);
        //开始递归
        dfs(num, depth + 1, len, used, path, res);
        //回溯
        //取消标记
        used[i] = false;
        path.removeLast();
        System.out.println("递归之后 => " + path);
      }
    }
  }
}
