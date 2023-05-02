import java.io.*;
import java.util.*;

public class BOJ_1931 {
    
    static int caseNum;
    static int[][] meetings;
    
    public static int schedule(int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int earliest = -1;
        int selected = 0;
        for (int i = 0; i < caseNum; i++) {
            if (earliest <= meetings[i][0]) {
                earliest = meetings[i][1];
                selected++;
            }
        }
        return selected;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(br.readLine());
        meetings = new int[caseNum][2];
        
        for (int i = 0; i < caseNum; i++) {
            String[] array = br.readLine().split("\\s+");
            meetings[i][0] = Integer.parseInt(array[0]);
            meetings[i][1] = Integer.parseInt(array[1]);
        }
        
        System.out.println(schedule(meetings));
        
        br.close();
    }
}
