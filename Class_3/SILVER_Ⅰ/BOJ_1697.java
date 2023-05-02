import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1697 {
    
    static int n, k;
    static int answer;
    static int[] status, result;
    static String[] array;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        result[num] = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            status[0] = cur + 1; // 앞으로 한 칸
            status[1] = cur - 1; // 뒤로 한 칸
            status[2] = cur * 2; // 순간이동
            
            for (int i = 0; i < 3; i++) {
                if (status[i] == k) {
                    answer = result[cur];
                    sb.append(answer);
                    return;
                }
                
                if (status[i] < 0 || status[i] >= result.length || result[status[i]] != 0) {
                    continue;
                }
                
                queue.add(status[i]);
                result[status[i]] = result[cur] + 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        k = Integer.parseInt(array[1]);
        status = new int[3];
        result = new int[100001];
        
        if (n == k) {
            answer = 0;
            sb.append(answer);
        } else {
            bfs(n);
        }
        
        System.out.println(sb);
        br.close();
    }
}