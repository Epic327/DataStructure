package MultiThread.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-27 10:38
 */
public class KedaTest01 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    for (String item : list){
      if ("1".equals(item)){
        list.remove(item);
        System.out.println("删除1成功");
      }
    }
    for (String item : list){
      if ("2".equals(item)){
        list.remove(item);
        System.out.println("删除2成功");
      }
    }
  }
}
