package codeTrain.stringExam;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Epic
 * @create 2021-10-12 21:36
 * @Description 计算器
 */
public class Calcu02 {
  public static void main(String[] args) {
    String s = "(9 + 3) + 2 * 5";
    int cal = cal(s);
    System.out.println(cal);
  }
  public static int cal(String s){
    //双栈法,num存数字，op存符号，map存放运算符优先级
    Stack<Integer> nums = new Stack<>();
    Stack<Character> ops = new Stack<>();
    HashMap<Character, Integer> map = new HashMap<>();
    //为了防止第一个数为负数，先忘nums加个 0
    nums.add(0);
    //定义运算符的优先级
    map.put('+',1);
    map.put('-',1);
    map.put('*',2);
    map.put('/',2);

    int len = s.length();
    char[]  chars = s.toCharArray();
    for (int i = 0; i <len; i++) {
      char ch = chars[i];
      //如果遇到空格就跳过
      if (ch== ' ') {
        continue;
      }
      if (ch == '('){
        //直接加入ops
        ops.add(ch);
      }else if (ch == ')'){
        //在while循环里面做运算，直到找到离ch最近的一个（,退出循环， （弹出栈
        while (!ops.isEmpty()){
          if (ops.peek() != '('){
            eval(nums,ops);
          }else{
            ops.pop();
            break;
          }
        }
      }else {
        if (isNumber(ch)){
          //如果是数字的话，就要考虑多位数，将其拼起来
          int x = 0;// 定义一个x来保存真实值
          int j = i;// 定义一个指针来扫描多位数
          while ( j < len && isNumber(chars[j])){
            x = x * 10 + chars[j] - '0';
            j++;
          }
          //加入nums,同时 i = j-1
          nums.add(x);
          i = j-1;
        }else{
          //如果不是数字，就是操作符，就考虑前一个char是不是一下几种情况,然后把0加进去
          if (i > 0 && (chars[i-1] =='(' || chars[i-1] == '+' || chars[i-1] == '-')){
            nums.add(0);
          }
          //然后判断当前操作符的优先级 与ops栈顶的优先级谁高,
          while (!ops.isEmpty() && ops.peek()!='('){
            char peek = ops.peek();
            //栈顶优先级高，就运算
            if (map.get(peek) >= map.get(ch)){
              eval(nums,ops);
            }else {
              break;
            }
          }
          //当前操作符优先级高，就加入栈，不作运算
          ops.add(ch);
        }
      }
    }
    //将剩余的计算完
    while (!ops.isEmpty()){
      eval(nums,ops);
    }
    return nums.peek();
  }

  public static void eval(Stack<Integer> nums, Stack<Character> ops){
    if(nums.isEmpty() || nums.size()<2){
      return;
    }
    if (ops.isEmpty()){
      return;
    }
    int b = nums.pop(), a = nums.pop();
    char op = ops.pop();
    int ans = 0;
    if (op == '+'){
      ans = a + b;
    }else if (op == '-'){
      ans = a - b;
    }else if (op == '*'){
      ans = a * b;
    }else if(op == '/'){
      ans = a / b;
    }
    nums.push(ans);
  }
  public static boolean isNumber(char c){
    return Character.isDigit(c);
  }
}
