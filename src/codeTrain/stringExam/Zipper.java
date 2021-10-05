package codeTrain.stringExam;

/**
 * @author Epic
 * @create 2021-09-13 10:25
 * @Description 基本字符串压缩
 */
public class Zipper {
  public static void main(String[] args) {
    String s = "aabcccccaaa";
    String s1 = zipString(s);
    System.out.println(s1);
  }
  public static String zipString(String iniString) {
    // write code here
    //考虑用StringBuffer来做
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iniString.length(); i++) {
      char temp = iniString.charAt(i);
      int count = 1;
      //两个判断条件，i<len-1，当前的等于后面一位，i<len-1要放在前面，防止数组越界
      while (i < iniString.length()-1 && iniString.charAt(i+1) == iniString.charAt(i)){
        count++;
        i++;
      }
      sb.append(temp).append(count);
    }
    //返回是要做判断，如果压缩后长度没有改变，那就返回原字符串
    return iniString.length() > sb.toString().length() ? sb.toString() : iniString;
  }
}
