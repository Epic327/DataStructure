package com.datastructure.hashtab;

import java.util.Scanner;

/**@Description 创建一个hash表
 * @author Epic
 * @create 2021-03-23 20:41
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.find(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
//创建一个Hashtab
class HashTab{
    //定义数组的最大容量
    private int maxSize;
   //定义一个链表数组
    private  EmplinkedList[] EmpArray;

    public HashTab(int maxSize) {
        this.maxSize = maxSize;
        EmpArray = new EmplinkedList[maxSize];
        //初始化数组里面的每个链表,要不然会有空指针异常
        for (int i = 0; i < maxSize; i++) {
            EmpArray[i] = new EmplinkedList();
        }
    }

    //创建一个散列函数,取模来确定要存入hashtab中的哪个链表
    public int hashFun(int id){
        int linkedListNo = id % maxSize;
        return linkedListNo;
    }
    //定义hashtab的add方法
    public void add(Emp emp){

        //放入哪条链表
        int linkedNo = hashFun(emp.id);
        EmpArray[linkedNo].add(emp);
    }
    //定义hashtab的list方法
    public void list(){
        //遍历数组，依次输出每条链表包含的所有节点
        for (int i = 0; i < maxSize; i++) {
            EmpArray[i].list(i);
        }
    }

    //定义hashtab的findbyid方法
    public void find(int id ){
        //确定查找那条列
        int linkedNo = hashFun(id);
        Emp emp = EmpArray[linkedNo].find(id);
        if (emp != null){
            //说明找到了
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (linkedNo+ 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

}

//创建一个Emp
class Emp{
    public int id;
    public String name;
    public Emp next; //next默认为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建一个Emp链表
class EmplinkedList{
    //头节点默认为空
    private  Emp head;

    //链表的add方法,此处假设id是自增长，就没有考虑根据id添加
    public void add(Emp emp){
        //判断链表是否为空
        if (head ==null){
            head = emp;
        }
        //链表不为空，则就把emp加入到链表的最后
        //定义一个辅助指针
        Emp curEmp = head;
        while (true){
            //判断
            if (curEmp.next ==null){
                //说明遍历到了最后一个节点，把emp加入到最后即可
                break;
            }
            //如果没有到最后，curEmp后移
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //链表的list方法
    public void list(int no) {
        if(head == null) { //说明链表为空
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }
    //Emp链表的find方法，根据Emp的id来查找
    public Emp find(int id){
        //判断链表是否为空
        if (head == null){
            System.out.println("链表为空");
        }
        //不为空，则遍历链表，找到id = emp.id即可
        //定义一个辅助指针
        Emp curEmp = head;
        while (true){
            if (id  == curEmp.id){
                //即找到了对应的id节点，返回当前Emp
                break;
            }
            //否则就后移
            curEmp = curEmp.next;
        }
        //退出循环后，返回emp
        return curEmp;
    }

    //链表的删除delete方法,根据id删除
    public void delete(int id) throws Exception {
        //判断链表是否为空
        if (head == null){
            throw new Exception("链表为空不能删除");
        }
        //不为空，则遍历链表，找到对应id的emp删除
        //定义一个辅助指针,指在头节点的前一个
        Emp curEmp = null;
        while (true){
            //找到待删除的节点
            if (curEmp.next.id == id) {
                break;
            }
            //后移
            curEmp = curEmp.next;
        }
        //跳过待删除的节点，
        curEmp.next = curEmp.next.next;
    }

}
