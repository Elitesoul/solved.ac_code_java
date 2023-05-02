import java.io.*;
import java.lang.*;

public class BOJ_2920 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        String output = "";
        for (int i = 0; i < array.length - 1; i++) {
            if (Integer.parseInt(array[i]) == Integer.parseInt(array[i + 1]) - 1) {
                output = "ascending";
            } else if (Integer.parseInt(array[i]) == Integer.parseInt(array[i + 1]) + 1) {
                output = "descending";
            } else {
                output = "mixed";
                break;
            }
        }
        System.out.println(output);
        br.close();
    }
}