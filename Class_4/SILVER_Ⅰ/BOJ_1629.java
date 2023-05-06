import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1629 {
    
    static long a, b, c;
    static long answer;
    static int[][] mat;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static long pow(long a, long b) {
        if (b == 1) {
            return a % c;
        }
        
        long num = pow(a, b / 2);
        
        if (b % 2 == 1) {
            return (num * num % c) * a % c;
        }
        return num * num % c;
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        a = Long.parseLong(array[0]);
        b = Long.parseLong(array[1]);
        c = Long.parseLong(array[2]);
        
        sb.append(pow(a, b));
        
        System.out.println(sb);
        br.close();
    }
}