//BOJ 2420 사파리월드

import java.io.*;
import java.util.*;
import java.lang.Math;

public class BOJ_2420 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        long a = Long.parseLong(array[0]);
        long b = Long.parseLong(array[1]);
        long diff = a - b;
        System.out.println(Math.abs(diff));
        
        br.close();
    }
}
