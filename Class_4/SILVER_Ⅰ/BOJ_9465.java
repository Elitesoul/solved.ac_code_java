import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_9465 {
    
    static int t, n;
    static int answer;
    static int[][] mat, dp;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            mat = new int[2][n + 1];
            dp = new int[2][n + 1];
            
            for (int i = 0; i < 2; i++) {
                array = br.readLine().split("\\s+");
                for (int j = 1; j <= n; j++) {
                    mat[i][j] = Integer.parseInt(array[j - 1]);
                }
            }
            dp[0][1] = mat[0][1];
            dp[1][1] = mat[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + mat[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + mat[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}