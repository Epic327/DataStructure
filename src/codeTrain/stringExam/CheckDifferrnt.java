package codeTrain.stringExam;

import java.util.HashSet;

/**
 * @author Epic
 * @create 2021-09-12 20:41
 * @Description 确定字符串互异
 */
public class CheckDifferrnt {
  public static void main(String[] args) {
    String s1 =   "BarackObama";
    boolean b = checkDifferent(s1);
    System.out.println(b);
  }

  public static boolean checkDifferent(String iniString) {
    // write code here
    HashSet<Character> set = new HashSet<>();
    int len = iniString.length();
    for (int i = 0; i < len; i++) {
      if (set.contains(iniString.charAt(i))){
        return false;
      }
      set.add(iniString.charAt(i));
    }
    return true;
  }
}
