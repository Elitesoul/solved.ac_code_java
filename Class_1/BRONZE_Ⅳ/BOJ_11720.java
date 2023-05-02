import java.io.*;
import java.lang.*;

public class BOJ_11720 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(array[i]);
        }
        System.out.println(sum);
        br.close();
    }
}