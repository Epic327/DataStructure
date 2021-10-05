package algorithmExam;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Epic
 * @create 2021-10-02 16:43
 */
public class ShenceData01 {
  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String str = sc.next();
    String str = "((1)";
    int count = 0;
    char temp = ' ';
    //new 一个栈来存放（
    Stack<Integer> stack = new Stack<>();
    //new 一个map，用来存放(下标,和）下标
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      temp =str.charAt(i);
      if (temp == '(') {
        stack.push(i);
        count++;
      }else if (temp == ')'){
        map.put(stack.pop(),i);
      }
    }
    System.out.println(count);
    for(Integer key : map.keySet()){
      System.out.println(key);
      System.out.println(map.get(key));
    }
  }
}
