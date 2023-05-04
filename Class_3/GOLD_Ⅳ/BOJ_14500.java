import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_14500 {
    
    static int n, m;
    static int answer;
    static int[][] mat;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        System.out.println(sb);
        br.close();
    }
}