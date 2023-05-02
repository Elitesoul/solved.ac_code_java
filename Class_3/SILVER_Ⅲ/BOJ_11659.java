import java.io.*;
import java.lang.*;

public class BOJ_11659 {
    
    static int n, m, i, j;
    static String[] array;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        dp = new int[n + 1];
        dp[0] = 0;
        array = br.readLine().split("\\s+");
        for (int k = 1; k <= n; k++) {
            dp[k] = dp[k - 1] + Integer.parseInt(array[k - 1]);
        }
        
        for (int k = 0; k < m; k++) {
            array = br.readLine().split("\\s+");
            i = Integer.parseInt(array[0]);
            j = Integer.parseInt(array[1]);
            sb.append(dp[j] - dp[i - 1]).append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}