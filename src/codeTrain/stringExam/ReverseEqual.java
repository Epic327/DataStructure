package codeTrain.stringExam;

/**
 * @author Epic
 * @create 2021-09-13 11:58
 * @Description 反转子串
 */
public class ReverseEqual {
  public static void main(String[] args) {
    String s1 = "Hello world";
    String s2 = "worldhello ";
    String s3 = "waterbottle";
    String s4 = "erbottlewat";

    boolean b = checkReverseEqual(s3, s4);
    System.out.println(b);
  }
  public static boolean checkReverseEqual(String s1, String s2) {
    // write code here
    if (s1.length()==0 || s2.length()==0 || s1.length()!=s2.length()){
      return false;
    }
    String temp =  s1 + s1;
    if (temp.contains(s2)){
      return true;
    }
    return false;
  }

}
