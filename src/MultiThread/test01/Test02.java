package MultiThread.test01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;

/**
 * @author Epic
 * @create 2021-09-28 17:19
 */
public class Test02 {
  @Test
  public void test1() {
    Arrays.asList(4,5,9,10).parallelStream()
        .filter(m -> {System.out.println(m);return (m > 1);})
        .map(m -> m+1)
        .collect(Collectors.groupingBy(x -> x %10))
        .forEach((x,y) -> System.out.println(y));
  }

  private static int x = 0;
  public static void main(String[] args){
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          x++;
          System.out.println(x + Thread.currentThread().getName());
        }
      }
    };

    Thread t1 = new Thread(runnable,"线程1");
    Thread t2 = new Thread(runnable,"线程2");

    t1.start();
    t2.start();
//    System.out.println(x);
  }

  @Test
  public void test2(){
    int[] value = new int[]{1,2};
    AtomicIntegerArray arr = new AtomicIntegerArray(value);
    arr.getAndSet(0,3);
    System.out.println(arr.get(0));
    System.out.println(value[0]);
    int minValue = -Integer.MIN_VALUE;
    int s =  2 -3;
  }
}
