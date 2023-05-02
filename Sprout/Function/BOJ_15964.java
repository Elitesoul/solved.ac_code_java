//이상한 기호

import java.io.*;
import java.lang.*;

public class BOJ_15964 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        long a = Integer.parseInt(array[0]);
        long b = Integer.parseInt(array[1]);
        sb.append((a + b) * (a - b)).append('\n');
        System.out.println(sb);
        br.close();
    }
}