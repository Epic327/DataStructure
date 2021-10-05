package codeTrain.dfsExam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-19 21:46
 */
public class ArraySum {
  public static void main(String[] args) {
    int target = 5;
    //初始化，len,栈，res，
    int[] num = {1, 2, 3};
  }
  // 剪枝优化
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(candidates); // 先进行排序
      backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
      return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates,
                              int target, int sum, int idx) {
      // 找到了数字和为 target 的组合
      if (sum == target) {
        res.add(new ArrayList<>(path));
        return;
      }

      for (int i = idx; i < candidates.length; i++) {
        // 如果 sum + candidates[i] > target 就终止遍历
        if (sum + candidates[i] > target) {
          break;
        }
        path.add(candidates[i]);
        backtracking(res, path, candidates, target, sum + candidates[i], i);
        path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
      }
    }
  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    int len = candidates.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }

    // 排序是剪枝的前提 因为排了序之后 如果前一个数已经超了 就不用去试探下一个数字了
    Arrays.sort(candidates);
    Deque<Integer> path = new ArrayDeque<>();
    dfs(candidates, 0, len, target, path, res);
    return res;
  }

    //或者这样写，dfs
  private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
    // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = begin; i < len; i++) {
      // 重点理解这里剪枝，前提是候选数组已经有序，
      if (target - candidates[i] < 0) {
        break;
      }

      path.addLast(candidates[i]);
      dfs(candidates, i, len, target - candidates[i], path, res);
      path.removeLast();
    }
  }


}
