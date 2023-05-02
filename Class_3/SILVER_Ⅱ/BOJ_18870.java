import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_18870 {
    
    static int n;
    static String[] array;
    
    static int[] origin;
    static int[] sorted;
    static HashMap<Integer, Integer> hashMap;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        origin = new int[n];
        sorted = new int[n];
        hashMap = new HashMap<>();
        array = br.readLine().split("\\s+");
        
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(array[i]);
            sorted[i] = Integer.parseInt(array[i]);
        }
        
        Arrays.sort(sorted);
        
        int rank = 0;
        for (int x : sorted) {
            if (!hashMap.containsKey(x)) {
                hashMap.put(x, rank);
                rank++;
            }
        }
        
        for (int key : origin) {
            rank = hashMap.get(key);
            sb.append(rank).append(' ');
        }
        
        System.out.println(sb);
        br.close();
    }
}