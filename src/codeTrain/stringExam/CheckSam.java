package codeTrain.stringExam;

import java.util.HashMap;

/**
 * @author Epic
 * @create 2021-09-12 21:05
 * @Description 确定两串乱序重构
 */
public class CheckSam {
  public static void main(String[] args) {
    String s1 =  "Here you are";
    String s2 = "Are you here";
    boolean b = checkSam(s1, s2);
    System.out.println(b);
  }
  public static boolean checkSam(String stringA, String stringB) {
    // write code here
    if (stringA.length() != stringB.length()){
      return false;
    }
    HashMap<Character, Integer> mapA = getMap(stringA);
    HashMap<Character, Integer> mapB = getMap(stringB);

    for (Character key : mapA.keySet()){
      //包装类型间的相等判断应该用equals，而不是'!='
      if (!mapA.get(key).equals(mapB.get(key))){
        return false;
      }
    }
    return true;
  }
  private static HashMap<Character,Integer> getMap(String str){
    char[] array = str.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(array[i])){
        Integer old = map.get(array[i]);
        map.put(array[i],old+1);
      }
      map.put(array[i],1);
    }
    return map;
  }

}
