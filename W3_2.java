/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Ming
 */
public class W3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Scanner scanner = new Scanner(System.in);
        String[] name = new String[100];
        String search;
        HashMap hashmap = new HashMap();
        int[] score = new int[100];
        int i, c = 0;
        while (true) {
            System.out.print("Name:");
            name[c] = scanner.next();
            if (name[c].equals("-1")) {
                break;
            }
              System.out.print("Score:");
            score[c] = scanner.nextInt();
            while(score[c] < 0||score[c]>100) {
                System.out.print("Score must be between 0 and 100:");
            score[c] = scanner.nextInt();
            }
            c++;
        }
        for (i = 0; i < c; i++) {
            hashmap.put(name[i], score[i]);
        } 
        System.out.println(hashmap);
        while (true) {
            System.out.print("Name: (-1)break");
            search = scanner.next();
            if (search.equals("-1")) {
                break;
            }
            System.out.println(hashmap.get(search));
        }
        
    }

}
