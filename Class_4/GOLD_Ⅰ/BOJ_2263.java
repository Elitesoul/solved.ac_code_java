import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_2263 {
    
    static int n;
    static int answer;
    static int[][] map;
    
    static List<Integer> inorder;
    static List<Integer> postorder;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void printPostOrder(List<Integer> preorder, List<Integer> inorder) {
        int N = preorder.size();
        if (N == 0) {
            return;
        }
        int root = preorder.get(0);
        int L = inorder.indexOf(root);
        int R = N - L - 1;
        printPostOrder(preorder.subList(1, L + 1), inorder.subList(0, L));
        printPostOrder(preorder.subList(L + 1, N), inorder.subList(L + 1, N));
        System.out.printf("%d ", root);
    }
    
    public static void printPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        
        if (inStart > inEnd) {
            return;
        }
        
        int P = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder.get(i).equals(postorder.get(postEnd))) {
                P = i;
                break;
            }
        }
        
        int L = P - inStart;
        int R = inEnd - P;
        
        sb.append(postorder.get(postEnd)).append(" ");
        printPreOrder(inStart, P - 1, postStart, postStart + L - 1);
        printPreOrder(P + 1, inEnd, postEnd - R, postEnd - 1);
        
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        inorder = new ArrayList<>();
        postorder = new ArrayList<>();
        
        array = br.readLine().split("\\s+");
        for (String s : array) {
            inorder.add(Integer.parseInt(s));
        }
        
        array = br.readLine().split("\\s+");
        for (String s : array) {
            postorder.add(Integer.parseInt(s));
        }
        
        printPreOrder(0, n - 1, 0, n - 1);
        
        System.out.println(sb);
        br.close();
    }
}