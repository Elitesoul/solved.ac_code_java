import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1978 {
    
    static void fillSieve(boolean[] prime) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("\\s+");
        boolean[] prime = new boolean[1001];
        fillSieve(prime);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(array[i]);
            if (prime[index]) {
                count++;
            }
        }
        
        sb.append(count).append('\n');
        System.out.println(sb);
        br.close();
    }
}