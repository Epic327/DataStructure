package algorithmExam;

import com.sun.applet2.preloader.event.PreloaderEvent;

import org.omg.IOP.ComponentIdHelper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-23 15:53
 */
public class QiAnXin02 {
  public static void main(String[] args) {
    char[] seed = new char[]{'0','1','2'};
    int size = 2;
    String[] str = Permutation(seed, size);

  }
  public static String[] Permutation (char[] seed, int size) {
    // write code here
      StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    Deque<Character> path = new ArrayDeque<>();
    dfs(0,size,path,seed,res);
    System.out.println(res);
    String s1 = res.get(1);
    System.out.println(s1);

    return new String[size];
  }

  public static void dfs(int index,int n,Deque<Character> path, char[] seed,
                         List<String> res){

    if (path.size() == n){
      res.add(new String(String.valueOf(path)));
      return;
    }
    for (int i = index; i < seed.length; i++) {
      if (path.contains(seed[i])){
        continue;
      }
      path.add(seed[i]);
      dfs(0,n,path,seed,res);
      path.removeLast();
    }
  }



}
