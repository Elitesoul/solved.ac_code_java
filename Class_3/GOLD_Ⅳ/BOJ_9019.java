import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_9019 {
    
    static int t, a, b;
    static int answer;
    static int[][] mat;
    static boolean[] visited;
    static Queue<Integer> queue;
    static String[] array, command;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(int a, int b) {
        queue.add(a);
        visited[a] = true;
        
        while (!queue.isEmpty() && !visited[b]) {
            int cur = queue.poll();
            int D = (cur * 2) % 10000;
            int S = (cur == 0) ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + cur / 10;
            
            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                command[D] = command[cur] + "D";
            }
            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                command[S] = command[cur] + "S";
            }
            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                command[L] = command[cur] + "L";
            }
            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                command[R] = command[cur] + "R";
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            array = br.readLine().split("\\s+");
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[1]);
            
            queue = new LinkedList<>();
            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");
            
            bfs(a, b);
            
            sb.append(command[b]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}