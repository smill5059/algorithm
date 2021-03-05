import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] field = new boolean[N][M];
             
            int[] di = {-2, 2, 0, 0};
            int[] dj = {0, 0, -2, 2};
             
            int cnt = 0;
            for (int i = 0; i < N; i++) {
next:           for (int j = 0; j < M; j++) {
                     
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (ni<0 || ni>=N || nj<0 || nj>=M) continue;
                        if (field[ni][nj]) continue next;
                    }
                    field[i][j] = true;
                    cnt++;
                     
                }
            }
             
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
             
        }
         
        System.out.print(sb);
    }
}