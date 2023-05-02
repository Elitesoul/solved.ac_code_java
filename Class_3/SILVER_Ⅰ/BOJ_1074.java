import java.io.*;
import java.lang.*;

public class BOJ_1074 {
    
    static int n, r, c;
    static int count = 0;
    static String[] array;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void visitCount(int size, int row, int col) {
        if (size == 1) {
            sb.append(count);
            return;
        }
        int newSize = size / 2;
        if (r < row + newSize && c < col + newSize) { // 2 quadrant
            visitCount(newSize, row, col);
        } else if (r < row + newSize && c >= col + newSize) { // 1 quadrant
            count += (size * size) / 4;
            visitCount(newSize, row, col + newSize);
        } else if (r >= row + newSize && c < col + newSize) { // 3 quadrant
            count += ((size * size) / 4) * 2;
            visitCount(newSize, row + newSize, col);
        } else { // 4 quadrant
            count += ((size * size) / 4) * 3;
            visitCount(newSize, row + newSize, col + newSize);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        r = Integer.parseInt(array[1]);
        c = Integer.parseInt(array[2]);
        
        visitCount((int) Math.pow(2, n), 0, 0);
        
        System.out.println(sb);
        br.close();
    }
}