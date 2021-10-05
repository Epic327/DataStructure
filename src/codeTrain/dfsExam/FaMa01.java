package codeTrain.dfsExam;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

/**
 * @author Epic
 * @create 2021-09-25 21:07
 */
public class FaMa01 {
  public static void main(String[] args) {
    int[] arr = {1,2,5,11,3};
    int target = 11;
    int minCount = getMinCount(target, arr);
    System.out.println(minCount);
  }
  public static int getMinCount(int target,int[] arr){
    int sum = 0;
    ArrayDeque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> count  = new ArrayList<>();
    //原生数组转包装类数组: int[] 2 Integer[]
  // Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
  //Arrays.sort(array, Collections.reverseOrder());
    dfs(target,sum, arr, path,res,count);

    Optional<Integer> min = count.stream().min(Integer::compareTo);
    System.out.println(count);
    return min.get();
  }
  public static void dfs(int target, int sum, int[] arr, Deque<Integer> path,
                         List<List<Integer>> res,List<Integer> count){
    if( sum == target){
      res.add(new ArrayList<>(path));
      count.add(path.size());
      return;
    }
    if (sum  > target){
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      path.add(arr[i]);
      dfs(target,sum+arr[i],arr,path,res,count);
      path.removeLast();
    }

  }

}
