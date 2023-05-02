import java.io.*;
import java.lang.*;

public class BOJ_2108 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[8001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp;
        double sum = 0;
        
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            sum += temp;
            array[temp + 4000]++;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        
        int count = 0;
        int maxMode = 0;
        boolean modeFlag = false;
        int modeValue = Integer.MAX_VALUE;
        int middleValue = Integer.MAX_VALUE;
        
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (array[i] > 0) {
                if (count < (n + 1) / 2) {
                    count += array[i];
                    middleValue = i - 4000;
                }
                
                if (maxMode < array[i]) {
                    maxMode = array[i];
                    modeValue = i - 4000;
                    modeFlag = true;
                } else if (maxMode == array[i] && modeFlag) {
                    modeValue = i - 4000;
                    modeFlag = false;
                }
            }
        }
        sb.append((int) Math.round(sum / n)).append('\n');
        sb.append(middleValue).append('\n');
        sb.append(modeValue).append('\n');
        sb.append(max - min).append('\n');
        System.out.println(sb);
        br.close();
    }
}