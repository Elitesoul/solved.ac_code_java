import java.io.*;
import java.lang.*;

public class BOJ_2869 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int v = Integer.parseInt(array[2]);
        
        int day = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            day++;
        }
        
        sb.append(day).append('\n');
        System.out.println(sb);
        
        br.close();
    }
}