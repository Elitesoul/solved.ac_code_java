//BOJ 10869 사칙연산

import java.io.*;
import java.util.*;

public class BOJ_10869 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        System.out.println(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));
        System.out.println(Integer.parseInt(array[0]) - Integer.parseInt(array[1]));
        System.out.println(Integer.parseInt(array[0]) * Integer.parseInt(array[1]));
        System.out.println(Integer.parseInt(array[0]) / Integer.parseInt(array[1]));
        System.out.println(Integer.parseInt(array[0]) % Integer.parseInt(array[1]));
        br.close();
    }
}
