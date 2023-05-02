//검증수

import java.io.*;
import java.lang.*;

public class BOJ_2745 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += (int) Math.pow(Double.parseDouble(array[i]), 2);
        }
        System.out.println(sum % 10);
        br.close();
    }
}