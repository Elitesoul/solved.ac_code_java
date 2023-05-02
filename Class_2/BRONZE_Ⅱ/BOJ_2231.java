import java.io.*;
import java.lang.*;

public class BOJ_2231 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum, temp;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            temp = i;
            sum = temp;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        br.close();
    }
}