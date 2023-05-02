//X보다 작은 수

import java.io.*;

public class BOJ_10871 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int N = Integer.parseInt(array[0]);
        int X = Integer.parseInt(array[1]);
        
        array = br.readLine().split("\\s+");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(array[i]);
            if (a < X) {
                System.out.println(a);
            }
        }
        
        br.close();
    }
}