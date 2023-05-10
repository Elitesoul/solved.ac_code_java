import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_5639 {
    
    static class Node {
        
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    static class Tree {
        
        Node root;
        
        public boolean findNode(int data) {
            if (root == null) {
                return false;
            }
            
            Node cur = root;
            
            while (cur.data != data) {
                if (data < cur.data) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
                
                if (cur == null) {
                    return false;
                }
            }
            return true;
        }
        
        public void add(int data) {
            
            if (this.root == null) {
                this.root = new Node(data);
            } else {
                Node cur = this.root;
                
                while (true) {
                    
                    if (data < cur.data) {
                        if (cur.left == null) {
                            cur.left = new Node(data);
                            return;
                        } else {
                            cur = cur.left;
                        }
                    } else {
                        if (cur.right == null) {
                            cur.right = new Node(data);
                            return;
                        } else {
                            cur = cur.right;
                        }
                    }
                }
            }
        }
        
        public void postOrderTraversal(Node node) { //후위
            if (node != null) {
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                sb.append(node.data).append("\n");
            }
        }
    }
    
    static String str;
    static int n;
    static int answer;
    static int[][] mat;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        Tree tree = new Tree();
        
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            
            n = Integer.parseInt(str);
            tree.add(n);
        }
        
        tree.postOrderTraversal(tree.root);
        
        System.out.println(sb);
        br.close();
    }
}