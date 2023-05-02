import java.io.*;
import java.lang.*;

public class BOJ_2675 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("\\s+");
            int repeat = Integer.parseInt(array[0]);
            String[] repeatArray = array[1].split("");
            for (int j = 0; j < repeatArray.length; j++) {
                for (int k = 0; k < repeat; k++) {
                    System.out.print(repeatArray[j]);
                }
            }
            System.out.println();
        }
        
        br.close();
    }
}