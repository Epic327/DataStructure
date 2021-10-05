package jzoffer;

/**
 * @author Epic
 * @create 2021-03-10 21:05
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        String replace = replace(s);
        System.out.println(replace);
    }

    public static String replace(String s){
        StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            for (Character cha :chars){
                if (cha == ' '){
                    res.append("%20");
                }else {
                    res.append(cha);
                }
            }
            return res.toString();
        }
}
