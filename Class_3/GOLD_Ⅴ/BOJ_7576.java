import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {
    
    static int m, n;
    static int count, days;
    static int[][] box;
    static Queue<int[]> queue;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        m = Integer.parseInt(array[0]);
        n = Integer.parseInt(array[1]);
        box = new int[n][m];
        count = 0;
        days = 0;
        queue = new LinkedList<>();
        
        for (int j = 0; j < n; j++) {
            array = br.readLine().split("\\s+");
            for (int k = 0; k < m; k++) {
                box[j][k] = Integer.parseInt(array[k]);
                if (box[j][k] == 1) {
                    queue.add(new int[]{j, k});
                } else if (box[j][k] == 0) {
                    count++;
                }
            }
        }
        
        while (!queue.isEmpty() && count > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                
                for (int j = 0; j < 4; j++) {
                    int cy = cur[0] + dy[j];
                    int cx = cur[1] + dx[j];
                    
                    if (cy < 0 || cx < 0 || cy >= n || cx >= m
                        || box[cy][cx] != 0) {
                        continue;
                    }
                    count--;
                    box[cy][cx] = 1;
                    queue.add(new int[]{cy, cx});
                }
            }
            days++;
        }
        
        sb.append(count == 0 ? days : -1);
        System.out.println(sb);
        br.close();
    }
}