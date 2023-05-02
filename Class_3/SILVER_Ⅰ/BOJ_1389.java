import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1389 {
    
    static int n, m, a, b, answer;
    static String[] array;
    static ArrayList<ArrayList<Integer>> friends;
    static boolean[] visited;
    static int[] result;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(int find, int start, int end, int count) {
        visited[find] = true;
        if (start == end) {
            result[find] += count;
            return;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i : friends.get(start)) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            bfs(find, queue.poll(), end, count + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        friends = new ArrayList<>();
        visited = new boolean[n + 1];
        result = new int[n + 1];
        
        for (int i = 1; i < n + 2; i++) {
            friends.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[1]);
            friends.get(a).add(b);
            friends.get(b).add(a);
            //System.out.println(friends);
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    continue;
                }
                Arrays.fill(visited, false);
                bfs(i, i, j, 0); // find, start, end, count;
            }
        }
        
        answer = 1;
        for (int i = 1; i < n + 1; i++) {
            answer = result[answer] > result[i] ? i : answer;
        }
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}