package com.datastructure.stack;

/**@Description 一个加减乘除计算器
 * @author Epic
 * @create 2021-02-28 20:13
 */
public class Calculator {
    public static void main(String[] args) {
        //新建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack =  new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //用于扫描
        int index = 0;
        //用于存放每次扫描得到char
        char ch = ' ';
        //用来拼接多位数
        String keepNum = "";
        //定义两个num用来pop
        int num1 = 0;
        int num2 = 0;
        int oper = 0;//字符可以用数字来表示
        int res = 0; //用于存放计算结果
        String expression = "23+6*2-1";
        //循环遍历expression,如果发现时数字就直接入栈，如果发现是符号就考虑如下几种情况
        while(true){
            //依次得到expression每个字符
            ch = expression.substring(index,index+1).charAt(0);
            //如果是运算符的话
            if (operStack.isOper(ch)){
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //再从符号栈中pop出一个符号，进行运算，将得到的结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peak())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                         res = numStack.cal(num1,num2,oper);//计算结果
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                        operStack.push(ch);
                    }
                }else{
                    //如果符号栈为空的话直接入栈
                    operStack.push(ch);
                }
            }else {
                //是数字的话

                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //处理多位数
                keepNum += ch;

                //如果已经到最后一个字符了，再往后就会空指针异常,就直接入栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //如果index的下一位是运算符
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            //如果index已经到最后一个字符，就退出循环
            if (index == expression.length()){
                break;
            }
        }
        //当表达式扫描完毕后，就顺序的从数栈和符号栈中pop相应的数和符号，并运行
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        //将数栈的最后数pop出来，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);

    }









}

class ArrayStack2 {
    private int[] stack;
    private int top = -1;
    private int maxSize;

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回在栈顶的值
    public int peak(){
        return stack[top];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //定义计算规则
    public int cal(int num1,int num2 ,int oper){
        int res = 0;
        switch (oper){
            case '*':
                res = num1 * num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case  '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
        }
        return res;
    }
    //运算符的优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }
        return -1;
    }

    //判断是否为符号
    public boolean isOper(char index){
        return index == '*' || index == '-' || index == '+' || index == '/';
    }
    //入栈push
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
        }
        top++;
        stack[top] = value;
    }

    //出栈pop，将栈顶的数据返回
    public int pop() {
        //判断栈是否为空
        if (isEmpty()) {
            System.out.println("栈空，不能取出数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，遍历时，需要从栈顶开始显示数据
    public void show() {
        //判断栈是否为空
        if (isEmpty()) {
            System.out.println("栈空，不能取出数据");
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }
}
