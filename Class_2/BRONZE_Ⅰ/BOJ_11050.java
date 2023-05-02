import java.io.*;
import java.lang.*;

public class BOJ_11050 {
    
    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    private static int binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        } else {
            return factorial(n) / (factorial(k) * factorial(n - k));
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int n = Integer.parseInt(array[0]);
        int k = Integer.parseInt(array[1]);
        
        sb.append(binomialCoefficient(n, k)).append('\n');
        System.out.println(sb);
        br.close();
    }
    
}