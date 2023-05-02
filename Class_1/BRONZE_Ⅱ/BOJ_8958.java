import java.io.*;
import java.lang.*;

public class BOJ_8958 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int sum = 0;
            String[] array = br.readLine().split("X");
            for (int j = 0; j < array.length; j++) {
                sum += (array[j].length() * (array[j].length() + 1)) / 2;
            }
            System.out.println(sum);
        }
        br.close();
    }
}