import java.io.*;
import java.lang.*;

public class BOJ_2609 {
    
    private static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int gcd = getGCD(a, b);
        int lcm = a * b / gcd;
        System.out.printf("%d %d\n", gcd, lcm);
        br.close();
    }
    
    
}