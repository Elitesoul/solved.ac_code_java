import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11399 {
    
    static int n;
    static String[] array;
    static int[] times;
    static int current, total;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        times = new int[n];
        array = br.readLine().split("\\s+");
        
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(times);
        total = times[0];
        current = times[0];
        for (int i = 1; i < n; i++) {
            total += times[i] + current;
            current += times[i];
        }
        System.out.println(total);
        br.close();
    }
}