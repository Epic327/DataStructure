package algorithmExam;

/**
 * @author Epic
 * @create 2021-10-09 20:47
 */
public class Sanfor02 {
  public static void main(String[] args) {
    String s = "Def g";
    String res = "Cfg h";
    int up_chr_offset = -1;
    int low_chr_offset = 1;
    String dec = dec(s, -1, 1);
    System.out.println(dec);
  }
  public static String dec (String str, int up_chr_offset, int low_chr_offset) {
    // write code here
    String[] s = str.split(" ");
    int len  = s.length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < s[i].length(); j++) {
        if (s[i].charAt(j) >= 'A' && s[i].charAt(j) <= 'Z'){
          int i1 = s[i].charAt(j) + up_chr_offset;
          char l1 = (char) i1;
          sb.append(l1);
        }else {
          int i2 = s[i].charAt(j) + low_chr_offset;
          char l2 = (char) i2;
          sb.append(l2);
        }
      }
      sb.append(' ');
    }
    return sb.toString();
  }

}
