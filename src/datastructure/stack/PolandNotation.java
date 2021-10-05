package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**@Description 后缀表达式，又称逆波兰表达式
 * @author Epic
 * @create 2021-03-01 22:33
 */
public class PolandNotation {
    public static void main(String[] args) {
        //给出一个expression
        String expression = "2 6 + 5 * 2 -";
        List<String> stringList = splitList(expression);
        int cal = calculate(stringList);
        System.out.println(cal);
    }

    //定义一个分割字符串的方法,并返回一个分割后的列表
    public  static List<String> splitList(String exp){
        String[] split = exp.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String item : split){
            list.add(item);
        }
        return  list;
    }
    //定义一个方法，用于返回最后表达式的值，目前规定是int型
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls){
            //判断  这里使用正则表达式来取出数
            if (item.matches("\\d+")){  //这里使用正则表达式来取出数
                //即入栈
                stack.push(item);
            }else {
                //pop出两个数运算后再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }

                stack.push("" +res);
            }
        }
        //最后返回栈中的值
        return Integer.parseInt(stack.pop());
    }


}


