//BOJ 1330 두 수 비교하기

import java.io.*;
import java.util.*;

public class BOJ_1330 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (a > b) {
            System.out.println(">");
        } else if (a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
        
        br.close();
    }
}
