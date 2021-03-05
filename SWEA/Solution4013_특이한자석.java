import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            int K = Integer.parseInt(in.readLine()); //회전 횟수
            int[][] magnet = new int[4][8];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int m = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                choiceRotate(magnet, m-1, d); //배열index
            }
             
            int result = 0;
            for (int i = 0; i < 4; i++) {
                if (magnet[i][0] == 1) result = result|(1<<i);
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
             
        }
         
        System.out.print(sb);
         
    }
     
    private static void choiceRotate(int[][] magnet, int m, int d) {
        int[] direction = new int[4];
        direction[m] = d;
         
        //left
        int cur = magnet[m][6], curd = d;
        for (int i = m-1; i >= 0; i--) {
            if (cur == magnet[i][2]) break;
            direction[i] = -1*curd;
            curd = direction[i];
            cur = magnet[i][6];
        }
        //right
        cur = magnet[m][2]; curd = d;
        for (int i = m+1; i < 4; i++) {
            if (cur == magnet[i][6]) break;
            direction[i] = -1*curd;
            curd = direction[i];
            cur = magnet[i][2];
        }
         
        for (int i = 0; i < 4; i++) {
            if (direction[i] == 0) continue;
            rotate(magnet, i, direction[i]);
        }
    }
     
    private static void rotate(int[][] magnet, int m, int d) {
        if (d == 1) {
            int temp = magnet[m][7];
            for (int i = 7; i > 0; i--) {
                magnet[m][i] = magnet[m][i-1];
            }
            magnet[m][0] = temp;
        } else {
            int temp = magnet[m][0];
            for (int i = 0; i < 7; i++) {
                magnet[m][i] = magnet[m][i+1];
            }
            magnet[m][7] = temp;
        }
    }
}