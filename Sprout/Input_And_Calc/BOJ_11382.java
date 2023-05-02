//BOJ 11382 꼬마 정민

import java.io.*;
import java.util.*;

public class BOJ_11382 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            result += Long.parseLong(array[i]);
        }
        System.out.println(result);
        br.close();
    }
}
