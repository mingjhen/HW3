/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class W3_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        String str, rstr = "", ws, wi, rnum;
        HashMap hashmap = new HashMap();
        int i, t = 0, opt;
        try {
            FileReader file = new FileReader("test.txt");
            BufferedReader readf = new BufferedReader(file);
            i = 0;
            while (readf.ready()) {
                String s = readf.readLine();
                if (s.matches("[0-9]+")) {
                    rnum = s;
                    if (i % 2 == 1) {
                        hashmap.put(rstr, rnum);
                    }
                } else {
                    rstr = s;
                }
                i++;
            }
            file.close();
        } catch (IOException ioe) {
        }
        String search;
        while (true) {
            System.out.print("(1)Add  (2)Search (3)Output All (-1)break: ");
            opt = scanner.nextInt();
            if (opt == -1) {
                FileWriter file = new FileWriter("test.txt");
                try {
                    BufferedWriter bufwriter = new BufferedWriter(file);//建立緩衝區//
                    for (Object key : hashmap.keySet()) {
                        ws = key.toString();
                        wi = hashmap.get(key).toString();
                        bufwriter.write(ws);
                        bufwriter.newLine();
                        bufwriter.write(wi);
                        bufwriter.newLine();
                    }
                    bufwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("test.txt" + "寫檔發生錯誤");
                }
                break;
            } else if (opt == 1) {
                System.out.print("Input : ");
                str = bufferedreader.readLine();
                String[] straddtoken = str.split("\\.|/|,|;|\\?|\\'|:|\\[|\\]|\\{|\\}|=| ");
                for (i = 0; i < straddtoken.length; i++) {
                    straddtoken[i] = straddtoken[i].toLowerCase();
                    if (hashmap.get(straddtoken[i]) == null) {
                        hashmap.put(straddtoken[i], 1);
                    } else {
                        t = Integer.parseInt(hashmap.get(straddtoken[i]).toString());
                        t += 1;
                        hashmap.put(straddtoken[i], t);
                    }
                }
            } else if (opt == 2) {
                System.out.print("Search:");
                search = scanner.next();
                search = search.toLowerCase();
                System.out.println(hashmap.get(search));
            } else if (opt == 3) {
                System.out.println(hashmap);
            }
        }
    }
}
