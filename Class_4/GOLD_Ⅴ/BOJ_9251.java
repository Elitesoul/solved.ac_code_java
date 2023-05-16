import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_9251 {
    
    static int n;
    static int answer;
    static int[][] dp;
    static char[] str1, str2;
    static int len1, len2;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void lcs_bottomup() {
        dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        answer = dp[len1][len2];
    }
    
    public static int lcs_topdown(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }
        
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            
            if (str1[x] == str2[y]) {
                dp[x][y] = lcs_topdown(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(lcs_topdown(x - 1, y), lcs_topdown(x, y - 1));
            }
        }
        
        return dp[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        
        len1 = str1.length;
        len2 = str2.length;
        
        /*
        dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(dp[i], -1);
        }
        answer = lcs_topdown(len1 - 1, len2 - 1);
        */
        
        lcs_bottomup();
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}