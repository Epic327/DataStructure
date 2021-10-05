package algorithmExam;

import java.util.Scanner;


public class MtExam01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    char[] ch = s.toCharArray();
    int len = ch.length;

    int count = 0;

    for (int i = 0; i < len ; i++) {
      for (int j = i; j < len; j++) {
        String subS = s.substring(i,j+1);
        if (subS.equals("")){
          continue;
        }
        int num = Integer.parseInt(subS);
        if (num % 22 ==  0){
          count++;
        }
      }
    }
    System.out.println(count);
  }
  public static boolean isDivide(String s){
    long num =  Integer.parseInt(s);
    if (num / 22==0){
      return true;
    }
    return false;
  }
}
