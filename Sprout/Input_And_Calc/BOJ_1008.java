//BOJ 1008 A/B

import java.io.*;
import java.util.*;

public class BOJ_1008 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        double result = Double.parseDouble(array[0]) / Double.parseDouble(array[1]);
        System.out.println(result);
        br.close();
    }
}
