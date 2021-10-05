package jzoffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-08 18:52
 */
public class Exam1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nodes1 = br.readLine().trim().split(" ");
    int len1 = nodes1.length;
    int[] node1 = new int[len1];
    for (int i = 0; i < len1 ; i++) {
        node1[i] = Integer.parseInt(nodes1[i]);
    }
    String[] nodes2 = br.readLine().trim().split(" ");
    int len2 = nodes2.length;
    int[] node2 = new int[len2];
    for (int i = 0; i < len2 ; i++) {
      node2[i] = Integer.parseInt(nodes2[i]);
    }
    int[] n = mergre(node1, node2);
    Arrays.stream(n).forEach(x -> System.out.print(x + " "));

  }
  public static int[] mergre(int[] n1, int[] n2){
    int[] n  = new int[n1.length + n2.length];
    for (int i = 0; i < n1.length ; i++) {
        n[i] = n1[i];
    }
    for (int j = n1.length; j < (n1.length+n2.length); j++) {
      n[j] = n2[j - n1.length];
    }
    Arrays.sort(n);
    return n;
  }

}

