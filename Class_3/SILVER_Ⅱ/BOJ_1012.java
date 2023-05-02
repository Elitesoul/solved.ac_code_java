import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1012 {
    
    static int t, m, n, k, x, y;
    static String[] array;
    static int[][] cabbages;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int changedX = x + dx[i];
            int changedY = y + dy[i];
            
            if (changedX >= 0 && changedY >= 0 && changedX < m && changedY < n) {
                if (!visited[changedX][changedY] && cabbages[changedX][changedY] == 1) {
                    dfs(changedX, changedY);
                }
            }
        }
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visited[x][y] = true;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int changedX = x + dx[i];
                int changedY = y + dy[i];
                
                if (changedX >= 0 && changedY >= 0 && changedX < m && changedY < n) {
                    if (!visited[changedX][changedY] && cabbages[changedX][changedY] == 1) {
                        q.add(new int[]{changedX, changedY});
                        visited[changedX][changedY] = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        array = br.readLine().split("\\s+");
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            array = br.readLine().split("\\s+");
            m = Integer.parseInt(array[0]);
            n = Integer.parseInt(array[1]);
            k = Integer.parseInt(array[2]);
            cabbages = new int[m][n];
            visited = new boolean[m][n];
            
            count = 0;
            for (int j = 0; j < k; j++) {
                array = br.readLine().split("\\s+");
                x = Integer.parseInt(array[0]);
                y = Integer.parseInt(array[1]);
                cabbages[x][y] = 1;
            }
            
            for (x = 0; x < m; x++) {
                for (y = 0; y < n; y++) {
                    if (cabbages[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        //bfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}