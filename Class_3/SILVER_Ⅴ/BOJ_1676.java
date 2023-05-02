import java.io.*;
import java.math.BigInteger;
import java.lang.*;

public class BOJ_1676 {
    
    static int n;
    static BigInteger[] fact;
    
    private static void memoization() {
        fact[0] = BigInteger.ONE;
        BigInteger result;
        for (int i = 1; i <= n; i++) {
            result = BigInteger.valueOf(i).multiply(fact[i - 1]);
            fact[i] = result;
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        
        fact = new BigInteger[n + 1];
        memoization();
        BigInteger num = fact[n];
        int count = 0;
        
        while (num.compareTo(BigInteger.ZERO) > 0) {
            if (num.mod(BigInteger.valueOf(Long.parseLong("10"))).equals(BigInteger.ZERO)) {
                count++;
            } else {
                break;
            }
            num = num.divide(BigInteger.valueOf(Long.parseLong("10")));
        }

//        sb.append(count).append('\n');
//        System.out.println(sb);
        
        int count2 = 0;
        while (n >= 5) {
            count2 += n / 5;
            n /= 5;
        }
        sb.append(count2).append('\n');
        System.out.println(sb);
        
        br.close();
    }
}