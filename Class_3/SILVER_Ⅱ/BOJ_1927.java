import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1927 {
    
    static int n, x;
    static String[] array;
    static PriorityQueue<Integer> queue;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        queue = new PriorityQueue<>();
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(x);
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}