import java.io.*;
import java.lang.*;

public class BOJ_2798 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        int near = -1;
        array = br.readLine().split("\\s+");
        //int[] num = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        int[] num = new int[array.length];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(array[i]);
        }
        
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum = num[i] + num[j] + num[k];
                    if (sum <= m) {
                        near = Math.max(near, sum);
                    }
                }
            }
        }
        System.out.println(near);
        br.close();
    }
}