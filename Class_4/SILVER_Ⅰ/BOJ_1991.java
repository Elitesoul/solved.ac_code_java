import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1991 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    static class Node {
        
        String data;
        Node left, right;
        
        public Node(String data) {
            this.data = data;
        }
    }
    
    static class Tree {
        
        Node root;
        
        public void searchNode(Node root, String data, String left, String right) {
            if (root == null) {
                return;
            } else if (root.data.equals(data)) {
                if (!left.equals(".")) {
                    root.left = new Node(left);
                }
                if (!right.equals(".")) {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root.left, data, left, right);
                searchNode(root.right, data, left, right);
            }
        }
        
        public void add(String data, String left, String right) {
            if (root == null) {
                root = new Node(data);
                if (!left.equals(".")) {
                    root.left = new Node(left);
                }
                if (!right.equals(".")) {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root, data, left, right);
            }
        }
        
        public void preOrderTraversal(Node node) { //전위
            if (node != null) {
                sb.append(node.data);
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }
        
        public void inOrderTraversal(Node node) { //중위
            if (node != null) {
                inOrderTraversal(node.left);
                sb.append(node.data);
                inOrderTraversal(node.right);
            }
        }
        
        public void postOrderTraversal(Node node) { //후위
            if (node != null) {
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                sb.append(node.data);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            tree.add(array[0], array[1], array[2]);
        }
        
        tree.preOrderTraversal(tree.root);
        sb.append("\n");
        tree.inOrderTraversal(tree.root);
        sb.append("\n");
        tree.postOrderTraversal(tree.root);
        sb.append("\n");
        
        System.out.println(sb);
        br.close();
    }
}