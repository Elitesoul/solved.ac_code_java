import java.io.*;
import java.lang.*;

public class BOJ_1436 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        long[] array = new long[n];
        array[0] = 666;
        for (int i = 1; i < array.length; i++) {
            long temp = array[i - 1];
            while (true) {
                temp++;
                if (Long.toString(temp).contains("666")) {
                    array[i] = temp;
                    break;
                }
            }
        }
        sb.append(array[n - 1]).append('\n');
        System.out.println(sb);
        br.close();
    }
}