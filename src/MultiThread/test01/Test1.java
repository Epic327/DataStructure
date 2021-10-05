package MultiThread.test01;

/**
 * @author Epic
 * @create 2021-09-27 22:15
 */
public class Test1 {
  public static void main(String[] args) {
    Thread t = new Thread( () -> {
      System.out.println("hello world");
    });

    t.start();
    t.start();
  }
}
