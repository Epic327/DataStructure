package algorithmExam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Epic
 * @create 2021-09-23 18:39
 */
public class QiAnXin02and1 {
  private static ArrayList<String> res;
  public static String[] Permutation (char[] seed, int size) {
    res = new ArrayList<String>();
    Arrays.sort(seed);
    //for(int i = 0; i < seed.length; i++){
    dfs(res, new StringBuilder(), seed, size);
    return res.toArray(new String[res.size()]);
  }
  private static void dfs(ArrayList<String> res, StringBuilder sb, char[] seed, int size){
    if(sb.length() >= size){
      res.add(sb.toString());
      return;
    }
    for(int j = 0; j < seed.length; j++){
      boolean isExist = false;
      for(int k = 0; k < sb.length(); k++){
        if(sb.charAt(k) == seed[j]){
          isExist = true;
          break;
        }
      }
      if(!isExist){
        sb.append(seed[j]);
        dfs(res, sb, seed, size);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
