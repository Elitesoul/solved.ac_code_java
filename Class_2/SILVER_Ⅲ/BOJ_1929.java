import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1929 {
    
    static int primeSize = 1000001;
    
    static void fillSieve(boolean[] prime) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= primeSize - 1; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= primeSize - 1; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int m = Integer.parseInt(array[0]);
        int n = Integer.parseInt(array[1]);
        boolean[] prime = new boolean[primeSize];
        fillSieve(prime);
        
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sb.append(i).append('\n');
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}