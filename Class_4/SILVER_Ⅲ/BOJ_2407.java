import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_2407 {
    
    static int n, m;
    static int answer;
    static int[][] mat;
    
    static BigInteger mul, div;
    static BigInteger[][] dp;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void comb_math() {
        for (int i = 0; i < m; i++) {
            mul = mul.multiply(new BigInteger(String.valueOf(n - i)));
            div = div.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        sb.append(mul.divide(div));
    }
    
    public static void comb_dp() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j].add(dp[i - 1][j - 1]);
                }
            }
        }
        sb.append(dp[n][m]);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        mul = BigInteger.ONE;
        div = BigInteger.ONE;
        dp = new BigInteger[101][101];
        
        //comb_math();
        comb_dp();
        
        System.out.println(sb);
        br.close();
    }
}