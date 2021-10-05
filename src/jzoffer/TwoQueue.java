package jzoffer;

import java.util.Deque;
import java.util.Stack;

/**
 * @author Epic
 * @create 2021-05-10 22:30
 */
public class TwoQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public void   CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}
