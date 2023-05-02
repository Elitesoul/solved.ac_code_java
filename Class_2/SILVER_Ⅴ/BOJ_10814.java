import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10814 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] clients = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("\\s+");
            clients[i][0] = array[0];
            clients[i][1] = array[1];
        }
        
        Arrays.sort(clients, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            sb.append(clients[i][0]).append(' ').append(clients[i][1]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}