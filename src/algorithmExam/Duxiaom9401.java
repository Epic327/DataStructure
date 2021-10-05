package algorithmExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-26 14:11
 */
public class Duxiaom9401 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String xo = scanner.nextLine();
    Integer m = Integer.valueOf(scanner.nextLine());
    ArrayList<String> arrayList = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      arrayList.add(scanner.nextLine());
    }

    // OOXX
    char[] xoChars = xo.toCharArray();
    boolean flag = true;

    for (int i = 0; i < arrayList.size(); i++) {
      // 1100
      char[] chars = arrayList.get(i).toCharArray();

      for (int j = 0; j < chars.length; j++) {
        // NO的情况
        if (xoChars[j] == 'X' && chars[j] != '0') {
          System.out.println("NO");
          flag = false;
          break;
        }
      }
      if (flag) {
        System.out.println("YES");
      }
      flag = true;
    }
  }
}
