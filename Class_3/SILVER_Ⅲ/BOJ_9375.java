import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_9375 {
    
    static int t, n, result;
    static String[] array;
    static HashMap<String, Integer> map;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        array = br.readLine().split("\\s+");
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            map = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            
            for (int j = 0; j < n; j++) {
                array = br.readLine().split("\\s+");
                
                if (map.containsKey(array[1])) {
                    map.put(array[1], map.get(array[1]) + 1);
                } else {
                    map.put(array[1], 1);
                }
            }
            
            result = 1;
            
            for (int cloth : map.values()) {
                result *= (cloth + 1);
            }
            
            sb.append(result - 1).append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}