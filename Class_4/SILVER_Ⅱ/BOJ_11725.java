import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_11725 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static boolean[] visited;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> tree;
    static Queue<Integer> queue;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int index) {
        visited[index] = true;
        for (int num : tree.get(index)) {
            if (visited[num]) {
                continue;
            }
            parents[num] = index;
            dfs(num);
        }
    }
    
    public static void bfs() {
        queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int i = 0; i < tree.get(cur).size(); i++) {
                int next = tree.get(cur).get(i);
                if (!visited[next]) {
                    parents[next] = cur;
                    queue.add(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parents = new int[n + 1];
        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            array = br.readLine().split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        //dfs(1);
        bfs();
        
        for (int i = 2; i < n + 1; i++) {
            sb.append(parents[i]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}