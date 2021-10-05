package algorithmExam;

/**
 * @author Epic
 * @create 2021-09-23 16:08
 */
public class QiAnXin01 {
  public static void main(String[] args) {
    int m = 5;
    int n = 3;
    int i = DoPermute(3, 5);
    System.out.println(i);
  }
  public static int DoPermute (int M, int N) {
    // write code here
    if(N == 1){
      return 1;
    }
    int index = 0;
    for(int i =2;i <=M;i++){
      index = (index+N) % i;
    }
    return index+1;
  }
}
