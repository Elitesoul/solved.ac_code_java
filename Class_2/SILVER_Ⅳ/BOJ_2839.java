import java.io.*;
import java.lang.*;

public class BOJ_2839 {

//    재귀함수 호출용
//    static int max = Integer.MAX_VALUE;
//    static int res;
//    static int[] dp;
//
//    static int solve(int pos, int count) {
//        if (pos < 0) {
//            return 0;
//        }
//        if (dp[pos] != -1) {
//            return dp[pos];
//        }
//        if (pos == 0) {
//            res = Math.min(res, count);
//            return res;
//        }
//        dp[pos] = Math.min(solve(pos - 5, count + 1), solve(pos - 3, count + 1));
//        return res;
//    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = n;
        
        int count = 0;
        while (true) {
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                break;
            } else {
                n -= 3;
                count++;
            }
            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }

//        재귀함수 호출용
//        dp = new int[m + 1];
//        Arrays.fill(dp, -1);
//        res = max;
//        System.out.println(solve(m, 0) == max ? -1 : res);
        
        br.close();
    }
}