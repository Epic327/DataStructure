package algorithmExam;

/**
 * @author Epic
 * @create 2021-09-17 21:06
 */
public class Wangyi01 {
  public static void main(String[] args) {
    String s1 = "helllo";
    String s2 = "ll";
    str(s1,s2);

  }
  public static void str(String s1,String s2){
    for (int i = 0; i < s1.length(); i++) {
      for (int j = i; j < s1.length(); j++) {
        String temp = s1.substring(i,j);
        if (temp.equals(s2)){
          System.out.println(i);
          return;
        }
      }
    }
  }

}
