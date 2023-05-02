import java.io.*;
import java.lang.*;

public class BOJ_11727 {
    
    static int n;
    static String[] array;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        array = br.readLine().split("\\s+");
        n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(3);
        } else {
            dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
            }
            
            System.out.println(dp[n]);
        }
        
        br.close();
    }
}