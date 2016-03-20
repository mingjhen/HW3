/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Ming
 */
public class W3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("input : ");
        str = scanner.nextLine();
        String[] strtoken = str.split("\\.|/|,|;|\\?|\\'|:|\\[|\\]|\\{|\\}|=| ");
        String[] strnum = new String[strtoken.length];

        int i, k = 0, j, sums = 0;
        for (i = 0; i < strtoken.length; i++) {
            System.out.println(strtoken[i]);
            strtoken[i] = strtoken[i].toLowerCase();

            if (strtoken[i].matches("[0-9]+")) {
                strnum[k] = strtoken[i];
                k++;
            }
        }
        int[] sumnum = new int[k];
        int t, n;
        System.out.println("\noutput:");
        for (i = 0; i < k; i++) {//一組陣列串各各數字做相加
            System.out.println(strnum[i]);
            sumnum[i] = 0;
            t = 0;
            char[] num = strnum[i].toCharArray();
            for (j = 0; j < num.length; j++) {
                n = (int) num[j] - 48;
                t += n;
                if (j < num.length - 1) {
                    System.out.print(n + "+");
                } else {
                    System.out.print(n);
                }
            }

            sumnum[i] = t;
            System.out.println("=" + sumnum[i]);
        }
        System.out.println();
        for (i = 0; i < k; i++) {//一組一組數字字串座相加
            if (i < k - 1) {
                System.out.print(strnum[i] + "+");
            } else {
                System.out.print(strnum[i]);
            }
            sums = sums + Integer.parseInt(strnum[i]);
        }
        System.out.println("=" + sums);

    }
}
