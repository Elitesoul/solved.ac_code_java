import java.io.*;
import java.lang.*;

public class BOJ_10250 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String[] array = br.readLine().split("\\s+");
            int h = Integer.parseInt(array[0]);
            int n = Integer.parseInt(array[2]);
            int y = (n % h == 0) ? h : n % h;
            int x = (n % h == 0) ? n / h : (n / h) + 1;
            System.out.printf("%d%02d\n", y, x);
        }
        
        br.close();
    }
}