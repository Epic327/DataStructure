package algorithmExam;

import java.util.Locale;

/**
 * @author Epic
 * @create 2021-09-14 20:00
 */
public class Shenxf01 {
  public static void main(String[] args) {
    String s = "I am a Student.";
    String res = "am I Student. a";
//
//    String s1 = reverseWords(s);
//    System.out.println(s1);
//    int test = test(1, 2, 3);
//    System.out.println(test);
    tes2();
  }
  public static String reverseWords (String s) {
//    // write code here
    s = s.trim();
    int m  = 0;
    int j = s.length()-1,l = j;

    StringBuilder sb = new StringBuilder();

    while (m < s.length()){
      while (l >= 0 &&  s.charAt(l) !=' ') {
        l--;
      }
      sb.append(s.substring(l + 1, j + 1) + " ");
      while (l >= 0 && s.charAt(l) == ' '){
        l--;
      }
      j = l;
    }
    return sb.toString().trim();

//    String[] s1 = s.split(" ");
//    for (int j = 0; j < i; j++) {
//      String temp = s1[0];
//      s1[0] = s1[i-1];
//      s1[i-1] = temp;
//    }
//    for (int j = i; j <s1.length ; j++) {
//      String temp = s1[0];
//      s1[i] = s1[s1.length-1];
//      s1[s1.length-1] = temp;
//    }
  }
  public String reverseWords1 (String s, int i){
//    String[] s1 = s.split(" ");
//    String[] s2 = null;
//    for (int j = 0; j < i ; j++) {
//      s2[j] =
//    }
//
//    s = s.trim();
//    int m  = 0;
//    int j = s.length()-1,l = j;
//
//    StringBuilder sb = new StringBuilder();
//
//    while (m < s.length()){
//      while (l >= 0 &&  s.charAt(l) !=' ') {
//        m++;
//      }
//      sb.append(s.substring(l + 1, j + 1) + " ");
//      while (l >= 0 && s.charAt(l) == ' '){
//        l--;
//      }
//      j = l;
//    }
//    return sb.toString().trim();
  return null;
  }
  public static void test1(String a ,String b){
    System.out.println(a);
    System.out.println(b);
  }
  public static void tes2(){
    String s1 = "hello";
    test1(s1,s1+="world");
  }

}
