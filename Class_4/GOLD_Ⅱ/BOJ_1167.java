import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1167 {
    
    static class Node {
        
        int end, weight;
        
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    
    static int n;
    static int answer, farNode;
    static int[][] map;
    static ArrayList<ArrayList<Node>> arrayList;
    static boolean[] visited;
    static int[] dims;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void makeTree() throws IOException {
        arrayList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arrayList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]);
            
            for (int j = 1; j < array.length; j += 2) {
                if (array[j].equals("-1")) {
                    break;
                }
                
                int v = Integer.parseInt(array[j]);
                int w = Integer.parseInt(array[j + 1]);
                
                arrayList.get(u).add(new Node(v, w));
                arrayList.get(v).add(new Node(u, w));
            }
        }
    }
    
    public static void dfs(int index, int count) {
        if (answer < count) {
            answer = count;
            farNode = index;
        }
        
        for (Node node : arrayList.get(index)) {
            if (!visited[node.end]) {
                visited[node.end] = true;
                dfs(node.end, count + node.weight);
            }
        }
    }
    
    public static void getDFS() {
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        
        answer = 0;
        farNode = -1;
        visited[1] = true;
        
        dfs(1, 0);
        answer = 0;
        Arrays.fill(visited, false);
        visited[farNode] = true;
        dfs(farNode, 0);
    }
    
    public static void bfs(int index) {
        queue = new LinkedList<>();
        dims[index] = 0;
        queue.add(index);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node node : arrayList.get(cur)) {
                if (dims[node.end] == -1) {
                    dims[node.end] = dims[cur] + node.weight;
                    queue.add(node.end);
                }
            }
        }
    }
    
    public static void getBFS() {
        dims = new int[n + 1];
        Arrays.fill(dims, -1);
        
        bfs(1);
        answer = 0;
        farNode = -1;
        for (int i = 0; i <= n; i++) {
            if (answer < dims[i]) {
                answer = dims[i];
                farNode = i;
            }
        }
        
        Arrays.fill(dims, -1);
        bfs(farNode);
        for (int i = 0; i <= n; i++) {
            if (answer < dims[i]) {
                answer = dims[i];
                farNode = i;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            answer = 0;
        } else {
            makeTree();
            
            //getDFS();
            getBFS();
        }
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}