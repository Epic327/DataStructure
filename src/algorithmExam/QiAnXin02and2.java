package algorithmExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-23 18:47
 */
public class QiAnXin02and2 {

  public String[] Permutation (char[] seed, int size) {
    // write code here
    if (seed == null || seed.length == 0 || size > seed.length) {
      return new String[]{};
    }

    int[] flag = new int[seed.length];
    List<String> ans = new ArrayList<>();
    Arrays.sort(seed);
    backtrack(flag, seed, size, new StringBuilder(), ans);

    String[] arr = new String[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      arr[i] = ans.get(i);
    }
    return arr;
  }
  public void backtrack(int[] flag, char[]seed, int size, StringBuilder sb, List<String> ans) {
    if (sb.length() == size) {
      ans.add(sb.toString());
      return;
    }

    for (int i = 0; i < seed.length; i++) {
      if (flag[i] != 1) {
        if (i > 0 && (seed[i] == seed[i - 1] && flag[i - 1] == 0)) {
          continue;
        }
        //字符存在
        if (-1 != sb.indexOf(seed[i] + "")) {
          continue;
        }
        sb.append(seed[i]);
        flag[i] = 1;
        backtrack(flag, seed, size, sb, ans);
        flag[i] = 0;
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
