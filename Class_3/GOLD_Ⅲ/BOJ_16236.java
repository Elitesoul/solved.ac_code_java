import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_16236 {
    
    static int n, size, time, eat;
    static int answer;
    static int sharkY, sharkX;
    static int nearY, nearX, nearDis;
    static int[][] mat, dist;
    static boolean[][] visited;
    
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    
    static Queue<int[]> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(int y, int x) {
        queue = new LinkedList<>();
        queue.add(new int[]{sharkY, sharkX});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int cy = cur[0] + dy[i];
                int cx = cur[1] + dx[i];
                
                if (cy >= 0 && cx >= 0 && cy < n && cx < n && mat[cy][cx] <= size
                    && dist[cy][cx] == 0) {
                    dist[cy][cx] = dist[cur[0]][cur[1]] + 1;
                    
                    if (mat[cy][cx] != 0 && mat[cy][cx] < size) {
                        if (nearDis > dist[cy][cx]) {
                            nearDis = dist[cy][cx];
                            nearY = cy;
                            nearX = cx;
                        } else if (nearDis == dist[cy][cx]) {
                            if (nearY == cy) {
                                if (nearX > cx) {
                                    nearX = cx;
                                }
                            } else if (nearY > cy) {
                                nearY = cy;
                                nearX = cx;
                            }
                        }
                    }
                    
                    queue.add(new int[]{cy, cx});
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        mat = new int[n][n];
        visited = new boolean[n][n];
        size = 2;
        eat = 0;
        time = 0;
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(array[j]);
                if (mat[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    mat[i][j] = 0;
                }
            }
        }
        
        while (true) {
            dist = new int[n][n];
            nearY = Integer.MAX_VALUE;
            nearX = Integer.MAX_VALUE;
            nearDis = Integer.MAX_VALUE;
            
            bfs(sharkY, sharkX);
            
            if (nearY == Integer.MAX_VALUE && nearX == Integer.MAX_VALUE) {
                break;
            } else {
                eat++;
                mat[nearY][nearX] = 0;
                sharkY = nearY;
                sharkX = nearX;
                time += dist[nearY][nearX];
                
                if (eat == size) {
                    size++;
                    eat = 0;
                }
            }
        }
        
        sb.append(time);
        System.out.println(sb);
        br.close();
    }
}