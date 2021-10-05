package codeTrain.stringExam;

import java.util.Stack;

/**
 * @author Epic
 * @create 2021-09-12 20:51
 * @Description 原串反转
 */
public class ReverseString {
  public static void main(String[] args) {
    String s1 = "This is nowcoder";
    String s = reverseString(s1);
    System.out.println(s);
  }
  public static String reverseString(String iniString) {
    // write code here
    //可以考虑一下栈的后进先出
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < iniString.length(); i++) {
      char c = iniString.charAt(i);
      stack.push(c);
    }
    char[] chars = new char[iniString.length()];
    for (int i = 0; i < iniString.length(); i++) {
      Character pop = stack.pop();
      chars[i] = pop;
    }
    String res = new String(chars);
    return res;
  }
  public static String reverseString1(String iniString){
    StringBuilder sb = new StringBuilder();
    for(int i=iniString.length()-1;i>=0;i--){
      sb.append(iniString.charAt(i));
    }
    return sb.toString();
    //return sb.reverse().toString();
  }
}
