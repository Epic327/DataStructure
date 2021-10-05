package algorithmExam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-10 19:47
 * @Description mt41射击训练
 */
public class Mt02to41 {
  public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    while(scan.hasNext()){
      int n=Integer.valueOf(scan.nextLine()); //n 打了n枪
      int[]data=new int[n];
      String s=scan.nextLine();
      String[]strs=s.split(" ");
      for(int i=0;i<n;i++){
        data[i]=Integer.valueOf(strs[i]);
      }
      System.out.println(get(n,data));
    }
  }
  public static int get(int n,int[]data){
    int count=0;
    long tem=0;
    Arrays.sort(data);
    int[]help=new int[1000005];
    for(int i=0;i<n;i++){
      help[data[i]]=1; //边界条件 当等于打的环数任意中的一个时，即为1
    }
    for(int i=0;i<n;i++){ //三种状态，对应三重for
      for(int j=i+1;j<n;j++){
        for(int k=j+1;k<n;k++){
          tem=data[i]*data[j]*data[k]; //状态选择
          if(tem>1000005){
            break;
          }
          else {
            int temh=(int)tem;
            if(help[temh]==1){
              count++;
            }
          }
        }
      }
    }
    return count;
  }
}
