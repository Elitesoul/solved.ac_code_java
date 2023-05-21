import java.io.*;
import java.lang.*;
import java.util.*;

//https://st-lab.tistory.com/252

public class BOJ_11444 {
    
    static long n;
    static long answer;
    static int[][] map;
    
    static long MOD = 1_000_000_007;
    static long[][] mat = {{1, 1}, {1, 0}};
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] ret = new long[2][2];
        
        ret[0][0] = ((m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0])) % MOD;
        ret[0][1] = ((m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1])) % MOD;
        ret[1][0] = ((m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0])) % MOD;
        ret[1][1] = ((m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1])) % MOD;
        
        return ret;
    }
    
    public static long[][] fibo(long[][] result, long exp) {
        if (exp == 1 || exp == 0) {
            return result;
        }
        
        long[][] temp = fibo(result, exp / 2);
        
        temp = multiply(temp, temp);
        
        if (exp % 2 == 1L) {
            temp = multiply(temp, mat);
        }
        return temp;
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Long.parseLong(br.readLine());
        
        long[][] result = {{1, 1}, {1, 0}};
        
        answer = fibo(result, n - 1)[0][0];
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}