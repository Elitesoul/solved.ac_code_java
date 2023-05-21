import java.io.*;
import java.lang.*;
import java.util.*;

public class Template {
    
    static class Node {
        
        int end;
        int weight;
        
        public Node(int end, int wegiht) {
            this.end = end;
            this.weight = wegiht;
        }
    }
    
    static int n;
    static int answer;
    static int[][] map;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        System.out.println(sb);
        br.close();
    }
}