import java.io.*;
import java.util.*;
import java.lang.*;


public class BOJ_1620 {
    
    static int n, m;
    static String[] array;
    static Map<Integer, String> hash1;
    static Map<String, Integer> hash2;
    static String pokemon;
    static String question;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        hash1 = new HashMap<>();
        hash2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            pokemon = br.readLine();
            hash1.put(i, pokemon);
            hash2.put(pokemon, i);
        }
        for (int i = 0; i < m; i++) {
            question = br.readLine();
            if (question.matches("\\d+")) {
                sb.append(hash1.get(Integer.parseInt(question))).append('\n');
            } else {
                sb.append(hash2.get(question)).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}