import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569 {
    
    static int m, n, h;
    static int count, days;
    static int[][][] box;
    static Queue<int[]> queue;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        m = Integer.parseInt(array[0]);
        n = Integer.parseInt(array[1]);
        h = Integer.parseInt(array[2]);
        box = new int[h][n][m];
        count = 0;
        days = 0;
        queue = new LinkedList<>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                array = br.readLine().split("\\s+");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(array[k]);
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    } else if (box[i][j][k] == 0) {
                        count++;
                    }
                }
            }
        }
        
        while (!queue.isEmpty() && count > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                
                for (int j = 0; j < 6; j++) {
                    int cz = cur[0] + dz[j];
                    int cy = cur[1] + dy[j];
                    int cx = cur[2] + dx[j];
                    
                    if (cz < 0 || cy < 0 || cx < 0 || cz >= h || cy >= n || cx >= m
                        || box[cz][cy][cx] != 0) {
                        continue;
                    }
                    count--;
                    box[cz][cy][cx] = 1;
                    queue.add(new int[]{cz, cy, cx});
                }
            }
            days++;
        }
        sb.append(count == 0 ? days : -1);
        System.out.println(sb);
        br.close();
    }
}