import java.io.*;
import java.lang.*;

public class BOJ_2884 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int hour = Integer.parseInt(array[0]);
        int minute = Integer.parseInt(array[1]);
        int result = minute - 45;
        if (result < 0) {
            System.out.printf("%d %d", (hour - 1 < 0) ? 23 : (hour - 1), result + 60);
        } else {
            System.out.printf("%d %d", hour, result);
        }
        br.close();
    }
}