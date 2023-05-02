//BOJ 5597 과제 안 내신 분..?

import java.io.*;
import java.util.*;

public class BOJ_5597 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[31];
        array[0] = 0;
        for (int i = 1; i < 31; i++) {
            array[i] = i;
        }
        for (int i = 0; i < 28; i++) {
            int a = Integer.parseInt(br.readLine());
            array[a] = 0;
        }
        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if (array[i] != 0) {
                result[count++] = array[i];
            }
        }
        Arrays.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
        br.close();
    }
}