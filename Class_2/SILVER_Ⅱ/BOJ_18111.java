import java.io.*;
import java.lang.*;

public class BOJ_18111 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        int b = Integer.parseInt(array[2]);
        
        int[][] blocks = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                blocks[i][j] = Integer.parseInt(array[j]);
                min = (min > blocks[i][j]) ? blocks[i][j] : min;
                max = (max < blocks[i][j]) ? blocks[i][j] : max;
            }
        }
        
        int time = Integer.MAX_VALUE;
        int height = 0;
        int spentTime;
        int inventory;
        for (int i = min; i <= max; i++) {
            spentTime = 0;
            inventory = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (blocks[j][k] < i) {
                        spentTime += i - blocks[j][k];
                        inventory -= i - blocks[j][k];
                    } else if (blocks[j][k] > i) {
                        spentTime += (blocks[j][k] - i) * 2;
                        inventory += blocks[j][k] - i;
                    }
                }
            }
            if (inventory > -1 && spentTime <= time) {
                time = spentTime;
                height = i;
            }
        }
        sb.append(time).append(' ').append(height).append('\n');
        System.out.println(sb);
        br.close();
    }
}