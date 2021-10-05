package algorithmExam;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-14 14:59
 */
public class Quna01 {
  public static void main(String[] args) {

  }
  public String so(int[] d) {
    Arrays.sort(d);
    StringBuilder sb = new StringBuilder();
    for (int i = d.length-1; i >0; i--) {
      if (d[i] % 3==0){
        sb.append(d[i]);
      }
    }
    return sb.toString();

  }
  public String so1(int[] d) {
    List<Integer>[] res = new List[3];
    for (int i = 0; i < 3; i++) {
      res[i] = new ArrayList<>();
    }
    int sum = 0;
    //求和
    for (int i : d) {
      res[i % 3].add(i);
      sum += i;
    }
    //排序
    for (int i = 0; i < 3; i++) {
      Collections.sort(res[i], Collections.reverseOrder());
    }
    int flag = sum % 3;
    //
    if (flag != 0) {
      if (res[flag].size() > 0) {
        res[flag].remove(res[flag].size() - 1);
      } else if (res[3 - flag].size() > 1) {
        res[3 - flag].remove(res[3 - flag].size() - 1);
      }
    } else {
      res[1].clear();
      res[2].clear();
    }
    res[0].addAll(res[1]);
    res[0].addAll(res[1]);
    Collections.sort(res[0],Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (int i : res[0]){
      sb.append(i);
    }
    if (sb.length()!=0 && sb.charAt(0)=='0'){
      return "0";
    }
    return sb.toString();
  }

}
