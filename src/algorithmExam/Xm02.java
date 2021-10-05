package algorithmExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Epic
 * @create 2021-09-08 20:06
 * @Description 替换字符串
 */
public class Xm02 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine().trim();
    String res = replace(s);
    System.out.println(res);
  }

  public static String replace(String s) {
    StringBuilder res = new StringBuilder();
    for (Character c : s.toCharArray()) {
      if (c == ' ') {
        res.append("%20");
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }
}
