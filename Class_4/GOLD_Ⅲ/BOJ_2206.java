import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_2206 {
    
    static class Node {
        
        int x;
        int y;
        int dist;
        boolean destroyed;
        
        public Node(int x, int y, int dist, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroyed = destroyed;
        }
    }
    
    static int n, m;
    static int answer;
    static int[][] map;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] visited;
    
    static Queue<Node> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs() {
        
        if (n == 1 && m == 1) {
            sb.append(1);
            return;
        }
        
        queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (cur.x == n - 1 && cur.y == m - 1) {
                sb.append(cur.dist);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                
                if (map[nextX][nextY] == 0) {
                    if (!cur.destroyed && !visited[nextX][nextY][0]) {
                        queue.add(new Node(nextX, nextY, cur.dist + 1, false));
                        visited[nextX][nextY][0] = true;
                    } else if (cur.destroyed && !visited[nextX][nextY][1]) {
                        queue.add(new Node(nextX, nextY, cur.dist + 1, true));
                        visited[nextX][nextY][1] = true;
                    }
                } else {
                    if (!cur.destroyed) {
                        queue.add(new Node(nextX, nextY, cur.dist + 1, true));
                        visited[nextX][nextY][1] = true;
                    }
                }
            }
        }
        sb.append(-1);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        visited = new boolean[n][m][2];
        bfs();
        
        System.out.println(sb);
        br.close();
    }
}