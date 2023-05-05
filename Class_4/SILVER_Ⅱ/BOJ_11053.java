import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_11053 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static int[] seq, dp;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        array = br.readLine().split("\\s+");
        seq = new int[n];
        dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(array[i]);
        }
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        sb.append(max);
        System.out.println(sb);
        br.close();
    }
}