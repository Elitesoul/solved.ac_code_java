//BOJ 2753 윤년

import java.io.*;
import java.util.*;

public class BOJ_2753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
        
        br.close();
    }
}
