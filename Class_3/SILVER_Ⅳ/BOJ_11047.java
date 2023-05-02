import java.io.*;
import java.lang.*;

public class BOJ_11047 {
    
    static int n, k;
    static String[] array;
    static int[] coins;
    static int count;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        k = Integer.parseInt(array[1]);
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count += (k / coins[i]);
            k %= coins[i];
        }
        System.out.println(count);
        br.close();
    }
}