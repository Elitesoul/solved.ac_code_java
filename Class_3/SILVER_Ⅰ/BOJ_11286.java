import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11286 {
    
    static int n, x;
    static int answer;
    static PriorityQueue<Integer> queue;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        queue = new PriorityQueue<>(
            (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2)
                : Integer.compare(Math.abs(o1), Math.abs(o2)));
        
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                sb.append(!queue.isEmpty() ? queue.poll() : 0).append('\n');
//                if (!queue.isEmpty()) {
//                    sb.append(queue.poll()).append('\n');
//                } else {
//                    sb.append(0).append('\n');
//                }
            } else {
                queue.add(x);
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}