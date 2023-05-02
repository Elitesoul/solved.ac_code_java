import java.io.*;
import java.lang.*;

public class BOJ_5525 {
    
    static int n, m;
    static int count, index, answer;
    static int[] hash;
    
    static String line;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void getHash() {
        hash = new int[m];
        index = 0;
        for (int i = 0; i < m; i++) {
            if (array[i].equals("I")) {
                hash[index] = i;
                index++;
            }
        }
        
        count = 0;
        answer = 0;
        for (int i = 1; i < index; i++) {
            if (hash[i] - hash[i - 1] == 2) {
                count++;
            } else {
                count = 0;
            }
            if (count >= n) {
                answer++;
            }
        }
    }
    
    public static void getCharCount() {
        count = 0;
        answer = 0;
        for (int i = 0; i < m - 2; i++) {
            if (array[i].equals("I") && array[i + 1].equals("O") && array[i + 2].equals("I")) {
                count++;
                if (count == n) {
                    count--;
                    answer++;
                }
                i++;
            } else {
                count = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        array = br.readLine().split("");
        
        //getHash();
        getCharCount();
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}