import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_12865 {
    
    static int n, k;
    static int answer;
    static int[][] dp;
    static int[] w, v;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dp_bottomup() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        answer = dp[n][k];
    }
    
    public static int dp_topdown(int i, int r) {
        if (i < 0) {
            return 0;
        }
        
        if (dp[i][r] == -1) {
            if (r < w[i]) {
                dp[i][r] = dp_topdown(i - 1, r);
            } else {
                dp[i][r] = Math.max(dp_topdown(i - 1, r), dp_topdown(i - 1, r - w[i]) + v[i]);
            }
        }
        return dp[i][r];
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        k = Integer.parseInt(array[1]);
        
        /*
        w = new int[n];
        v = new int[n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            w[i] = Integer.parseInt(array[0]);
            v[i] = Integer.parseInt(array[1]);
        }
        
        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        answer = dp_topdown(n - 1, k);
        */
        
        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            array = br.readLine().split("\\s+");
            w[i] = Integer.parseInt(array[0]);
            v[i] = Integer.parseInt(array[1]);
        }
        dp_bottomup();
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}