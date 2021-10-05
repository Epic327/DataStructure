package com.datastructure.stack;

import java.util.Scanner;

/**@Description 数组模拟栈
 * @author Epic
 * @create 2021-02-27 21:03
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String key  = " ";
        while (loop){
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();

            switch (key){
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res = stack.pop();
                    System.out.printf("出栈的数据是 %d\n", res);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

}

class ArrayStack{
    private int[] stack;
    private int top = -1;
    private int maxSize;

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top ==- 1;
    }

    //入栈push
    public void push(int value){
        //判断栈是否满
        if (isFull()){
            System.out.println("栈满");
        }
        top++;
        stack[top] = value;
    }

    //出栈pop，将栈顶的数据返回
    public int pop(){
        //判断栈是否为空
        if (isEmpty()){
            System.out.println("栈空，不能取出数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，遍历时，需要从栈顶开始显示数据
    public void show(){
        //判断栈是否为空
        if (isEmpty()){
            System.out.println("栈空，不能取出数据");
        }
        for (int i = top ; i > -1; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }

    }



}
