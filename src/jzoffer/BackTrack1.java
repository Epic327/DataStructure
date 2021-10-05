package jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-08 16:48
 */
public class BackTrack1 {
  public List<List<String>> partition(String s) {
    int len  = s.length();
    //分割字符串
    int index = 0;
    char[] arr = s.toCharArray();
    //某一条路径集合
    Deque<String> path = new ArrayDeque<>();
    //所有路径的集合
    List<List<String>> res = new ArrayList<>();

    dfs(arr,index,len,path,res);

    return res;

  }

  private void dfs(char[] arr, int index, int len, Deque<String> path, List<List<String>> res) {
    //结束查找的条件
    if(index == len){
      res.add(new ArrayList<>(path));
      return;
    }
    //开始查找
    for(int i = index; i < len; i++){
      //判断是否是回文串
      if(!isPrime(arr,index,i)){
        continue;
      }
      //是回文串
      //选择路径,并把选择的字符串(即要分割的字符串)加入选择列表，选择队列是因为，后进先出，为了放遍回溯
      path.addLast(new String(arr,index,i - index +1));
      //递归下一层决策树
      dfs(arr,i+1,len,path,res);
      //撤销选择,为了回溯后可以重新选择原来的数，这也说明了为什么要用栈来存放路径
      path.removeLast();
    }
  }

  public boolean isPrime(char[] arr,int left, int right){
    while (left < right){
      if(arr[left] != arr[right] ){
        return  false;
      }
      left++;
      right--;
    }
    return true;
  }

}
