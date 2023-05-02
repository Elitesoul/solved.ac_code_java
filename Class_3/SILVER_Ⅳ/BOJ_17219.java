import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_17219 {
    
    static int n, m;
    static String[] array;
    static Map<String, String> map;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            map.put(array[0], array[1]);
        }
        
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}