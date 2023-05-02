import java.io.*;
import java.lang.*;

public class BOJ_2775 {
    
    static int resident(int k, int n) {
        if (k == 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        return resident(k - 1, n) + resident(k, n - 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(resident(k, n));
        }
        br.close();
    }
}