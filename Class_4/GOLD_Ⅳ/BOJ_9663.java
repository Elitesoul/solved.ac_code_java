import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_9663 {
    
    static int n;
    static int answer;
    static int[][] map;
    
    static int[] queen;
    static boolean[] checkX, checkDiff, checkSum;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void nqueen1(int y) { //행을 옮기며 이동
        if (y >= n) { //행이 마지막에 오면 answer++
            answer++;
            return;
        }
        
        for (int x = 0; x < n; x++) { //열을 옮기며 이동
            if (checkX[x] || checkDiff[x - y + n] || checkSum[x + y]) {
                continue;
            }
            
            //우하향 대각선 : x - y의 값이 항상 같음 -> (2,1)과 (1,0)은 같은 대각선 상에 있음
            //우상향 대각선 : x + y의 값이 항상 같음 -> (1,2)와 (2,1)은 같은 대각선 상에 있음
            
            checkX[x] = true; //같은 열에 퀸을 놓음
            checkDiff[x - y + n] = true; //우하향 대각선에 퀸을 놓음, 보정값으로 n을 더함
            checkSum[x + y] = true; //우상향 대각선에 퀸을 놓음
            
            nqueen1(y + 1);
            
            checkX[x] = false;
            checkDiff[x - y + n] = false;
            checkSum[x + y] = false;
        }
    }
    
    public static boolean isPossible(int index) {
        for (int i = 0; i < index; i++) {
            if (queen[index] == queen[i]) { // 같은 행에 위치한 경우
                return false;
            } else if (Math.abs(index - i) == Math.abs(queen[index] - queen[i])) {
                //열의 차와 행의 차가 같은 경우 같은 대각선 상에 있음
                //(1,0)과 (2,1) & (1,2)와 (2,1) 등
                return false;
            }
        }
        return true;
    }
    
    public static void nqueen2(int index) { //queen의 index를 지나면서 열을 이동
        if (index == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            queen[index] = i;
            
            if (isPossible(index)) {
                nqueen2(index + 1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        answer = 0;
        
        /*
        checkX = new boolean[100];
        checkDiff = new boolean[100];
        checkSum = new boolean[100];
        nqueen1(0);
        */
        
        queen = new int[n];
        //queen[열] = 행; -> (열, 행)
        //queen[0] = 2; -> (0,2), 0번째 열의 2번째 행에 퀸을 놓았음
        nqueen2(0);
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}