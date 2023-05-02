import java.io.*;
import java.lang.*;

public class BOJ_2292 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 2;
        if (n == 1) {
            System.out.println(1);
        } else {
            while (range <= n) {
                range += (6 * count);
                count++;
            }
            System.out.println(count);
        }
        br.close();
    }
}