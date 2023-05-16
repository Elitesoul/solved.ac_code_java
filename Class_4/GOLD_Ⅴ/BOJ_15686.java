import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_15686 {
    
    static class Loc {
        
        int x;
        int y;
        
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int n, m;
    static int answer;
    static int[][] map;
    static ArrayList<Loc> house, chicken;
    static boolean[] visited;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int index, int count) {
        if (count == m) {
            int dist = 0;
            
            for (Loc h : house) {
                int temp = Integer.MAX_VALUE;
                for (Loc c : chicken) {
                    if (visited[chicken.indexOf(c)]) {
                        temp = Math.min(temp, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
                    }
                }
                dist += temp;
            }
            answer = Math.min(answer, dist);
            return;
        }
        
        for (int i = index; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                switch (array[j]) {
                    case "1":
                        house.add(new Loc(i, j));
                        break;
                    case "2":
                        chicken.add(new Loc(i, j));
                        break;
                }
            }
        }
        
        visited = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
        
        dfs(0, 0);
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}