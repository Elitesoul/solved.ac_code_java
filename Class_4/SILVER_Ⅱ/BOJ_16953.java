import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_16953 {
    
    static long a, b, count;
    static int answer;
    static int[][] mat;
    
    static Queue<Long> queue;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(long a, long b) {
        queue = new LinkedList<>();
        queue.add(b);
        count = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                long cur = queue.poll();
                if (cur == a) {
                    sb.append(count);
                    return;
                }
                
                if (cur % 2 == 0 && cur / 2 >= a) {
                    queue.add(cur / 2);
                }
                if (cur % 10 == 1 && cur / 10 >= a) {
                    queue.add(cur / 10);
                }
            }
            count++;
        }
        sb.append(-1);
    }
    
    public static void math(long a, long b) {
        count = 1;
        
        while (a != b) {
            if (b < a) {
                sb.append(-1);
                return;
            }
            
            if (b % 10 == 1) {
                b /= 10;
            } else if (b % 2 == 0) {
                b /= 2;
            } else {
                sb.append(-1);
                return;
            }
            count++;
        }
        sb.append(count);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        a = Long.parseLong(array[0]);
        b = Long.parseLong(array[1]);
        
        //bfs(a, b);
        math(a, b);
        
        System.out.println(sb);
        br.close();
    }
}