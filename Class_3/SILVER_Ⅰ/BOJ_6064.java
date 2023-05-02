import java.io.*;
import java.lang.*;

public class BOJ_6064 {
    
    static int t, m, n, x, y;
    static int year, last, answer;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            array = br.readLine().split("\\s+");
            m = Integer.parseInt(array[0]);
            n = Integer.parseInt(array[1]);
            x = Integer.parseInt(array[2]);
            y = Integer.parseInt(array[3]);
            
            year = x;
            last = lcm(m, n);
            
            while (true) {
                if (year > last) {
                    sb.append(-1).append('\n');
                    break;
                } else if (((year % n) == 0 ? n : year % n) == y) {
                    sb.append(year).append('\n');
                    break;
                }
                year += m;
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}