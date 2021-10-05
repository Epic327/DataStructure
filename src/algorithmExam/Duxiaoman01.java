package algorithmExam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.ParseException;

import java.util.*;

/**
 * @author Epic
 * @create 2021-09-27 16:07
 */
public class Duxiaoman01 {
    public static boolean[] vis;
    public static boolean res;
    public static void main(String[] args) throws ParseException {
      Scanner sc = new Scanner(System.in);
      int m = sc.nextInt();
      int n = sc.nextInt();
      SimpleDateFormat format = new SimpleDateFormat("HH:mm");
      Date[][] dates = new Date[m + n][2];
      for(int i = 0; i < n + m; ++i) {
        String s = sc.next();
        String[] ss = s.split("-");
        dates[i][0] = format.parse(ss[0]);
        dates[i][1] = format.parse(ss[1]);
      }
      Arrays.sort(dates, new Comparator<Date[]>() {
        @Override
        public int compare(Date[] o1, Date[] o2) {
          if(o1[0].before(o2[0])) {
            return -1;
          }
          else if(o1[0].after(o2[0])) {
            return 1;
          }
          else {
            return 0;
          }
        }
      });
      List<Date[]> res = new ArrayList<>();
      for(int i = 0; i < m + n; ++i) {
        Date left = dates[i][0];
        Date right = dates[i][1];
        if(res.size() == 0 || left.compareTo(res.get(res.size() - 1)[1]) >= 0) {
          res.add(dates[i]);
        }
        else {
          if(!res.get(res.size() - 1)[1].before(right)) {
            res.remove(res.size() - 1);
            res.add(dates[i]);
          }
        }
      }
      System.out.println(res.size());
    }
}
