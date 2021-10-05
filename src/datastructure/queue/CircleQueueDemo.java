package com.datastructure.queue;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-02-19 15:31
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleQueue queue = new CircleQueue(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}


class CircleQueue{
    private int maxSize; //数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    //创建队列的构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;// front 指向队列的第一个元素.
        rear = 0;// rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做为约定
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //rear 后移，这里必须考虑取模，因为是环形队列
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取出数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //判断是否为空
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        //遍历
        for (int i = front  ; i < front + size()  ; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }


    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];
    }

}
