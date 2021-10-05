package codeTrain.arrayExam;

/**
 * @author Epic
 * @create 2021-09-13 14:31
 * @Description 像素翻转
 */
public class TransForm {
  public static void main(String[] args) {
    int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    int n = 3;
    int[][] ints = transformImage(a, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(ints[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static int[][] transformImage(int[][] mat, int n) {
    // write code here
    int[][] a = new int[n][n];
    for (int i =  0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[j][n-i-1] = mat[i][j];
      }
    }
    return a;
  }

}
