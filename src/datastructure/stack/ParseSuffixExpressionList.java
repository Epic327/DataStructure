package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**@Description 将中缀表达式转为后缀表达式
 * @author Epic
 * @create 2021-03-03 16:04
 */
public class ParseSuffixExpressionList {
    public static void main(String[] args) {
        String expression  = "1+((22+3)*4)-5";
        List<String> toList = toList(expression);
        System.out.println(toList);
        List<String> toPasreSuffix = toPasreSuffix(toList);
        System.out.println(toPasreSuffix);

    }
    //定义一个方法，将expression转为list
    public static List<String> toList(String exp){
        //先创建一个列表来存放
        List<String> array = new ArrayList<>();
        //定义一个指针，来辅助遍历
        int i  = 0;
        //定义一个String，来进行拼接
        String str ;
        //定义一个char，来存放遍历到的每一个字符
        char c;
        //do-while循环，执行顺序 1——3——4——2  1.初始化条件，2.循环条件，3.循环体，4.迭代条件
        do{
            //如果是非数字，则加入到array,根据asc码来判断
            if ((c = exp.charAt(i)) < 48 ||(c = exp.charAt(i)) > 57 ){
                array.add(""+ c);
                //指针后移
                i++;
            }else {
                //如果是数字，则先考虑是不是多位数
                str = "";//先将str 置成"" '0'[48]->'9'[57]
                while (i < exp.length() && (c = exp.charAt(i)) >= 48 && (c = exp.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                array.add(str);
            }
        }while (i < exp.length());
        return array;
    }

    //定义一个方法，将中缀表达式转为后缀表达式
    //定义一个符号栈，s1，定义一个list用来存我们最终的结果
    public static List<String> toPasreSuffix(List<String> al){
        //符号栈s1
        Stack<String> s1 = new Stack<>();
        //存储中间的结果的s2
        List<String> s2 = new ArrayList<>();

        //遍历
        for (String item : al){
            //如果是数字，就加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());  //这一步是为了把"+"号加入s2
                }
                s1.pop();//弹出小括号”(“,正好消除一队括号
            }else{
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                //把item压入栈
                s1.push(item);
            }
        }

        //最后把S1剩余的元素加入S2中
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List

    }

}
//定义一个运算符优先级的类
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }
}
