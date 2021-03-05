import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int N;
    static char[][] table;
    static boolean[][] visited;
     
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
     
    public static void main(String[] args) throws IOException {
//      System.setIn(new FileInputStream("res/input_swea_1868.txt"));
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            /*입력*/
            N = Integer.parseInt(in.readLine());
            table = new char[N][];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                table[i] = in.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (table[i][j] == '.') table[i][j] = '0';
                }
            }
             
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (table[i][j] == '*') count(i, j);
                }
            }
             
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && table[i][j] == '0') {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (table[i][j] == '*') continue;
                    if (!visited[i][j]) result++;
                }
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
             
        }
         
        System.out.print(sb);
         
    }
     
    private static void count(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
            if (table[nr][nc] == '*') continue;
            table[nr][nc]++;
        }
    }
     
    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if (table[r][c] != '0') return;
         
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
            if (table[nr][nc] == '*' || visited[nr][nc]) continue;
            dfs(nr, nc);
        }
    }
}