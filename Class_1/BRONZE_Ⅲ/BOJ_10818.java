import java.io.*;
import java.lang.*;

public class BOJ_10818 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int max = -1000001;
        int min = 1000001;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Integer.parseInt(array[i]));
            min = Math.min(min, Integer.parseInt(array[i]));
        }
        System.out.printf("%d %d", min, max);
        br.close();
    }
}