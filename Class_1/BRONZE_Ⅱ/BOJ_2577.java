import java.io.*;
import java.lang.*;

public class BOJ_2577 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        long result = a * b * c;
        while (result > 0) {
            count[(int) (result % 10)]++;
            result /= 10;
        }
        
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
        br.close();
    }
}