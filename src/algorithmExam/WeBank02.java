package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-10 21:06
 */

public class WeBank02 {
  static int res=0;
  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String[] str=scanner.nextLine().split(" ");
    int n=Integer.parseInt(str[0]);
    int m=Integer.parseInt(str[1]);
    int x=Integer.parseInt(str[2]);
    int y=Integer.parseInt(str[3]);
    int[][] arr=new int[n][m];
    for(int i=0;i<n;i++){
      String[] s=scanner.nextLine().split(" ");
      for(int j=0;j<m;j++){
        arr[i][j]=Integer.parseInt(s[j]);
      }
    }
    String command=scanner.nextLine();
    char[] com=command.toCharArray();
    dfs(arr,com[0],com,arr.length-1,0,0,x,y);
    System.out.println(res);
  }

  public static void dfs(int[][] arr,char last,char[] com,int i,int j,int index,int x,int y){
    if(index>=com.length) return;
    char cur=com[index];
    if(cur!=last){
      res+=x;
    }
    if(cur=='h'){
      //向左移动一格
      if(j<=0||arr[i][j-1]==-1){
        res+=y;
        res+=arr[i][j];
        dfs(arr,cur,com,i,j,index+1,x,y);
      }else {
        res+=Math.max(arr[i][j],arr[i][j-1]);
        dfs(arr,cur,com,i,j-1,index+1,x,y);
      }

    }else if(cur=='j'){
      //向下移动一格
      if(i>=arr.length-1||arr[i+1][j]==-1){
        res+=y;
        res+=arr[i][j];
        dfs(arr,cur,com,i,j,index+1,x,y);
      }else {
        res+=Math.max(arr[i][j],arr[i+1][j]);
        dfs(arr,cur,com,i+1,j,index+1,x,y);
      }
    }else if(cur=='k'){
      //向上移动一格
      if(i<=0||arr[i-1][j]==-1){
        res+=y;
        res+=arr[i][j];
        dfs(arr,cur,com,i,j,index+1,x,y);
      }else {
        res+=Math.max(arr[i][j],arr[i-1][j]);
        dfs(arr,cur,com,i-1,j,index+1,x,y);
      }
    }else if(cur=='l'){
      //向右移动一格
      if(j>=arr[0].length-1||arr[i][j+1]==-1){
        res+=y;
        res+=arr[i][j];
        dfs(arr,cur,com,i,j,index+1,x,y);
      }else {
        res+=Math.max(arr[i][j],arr[i][j+1]);
        dfs(arr,cur,com,i,j+1,index+1,x,y);
      }
    }
  }
}
