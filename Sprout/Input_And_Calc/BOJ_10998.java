//BOJ 10998 A×B

import java.io.*;
import java.util.*;

public class BOJ_10998 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int result = Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
        System.out.println(result);
        br.close();
    }
}
