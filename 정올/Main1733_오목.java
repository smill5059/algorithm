import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
     
    static int[][] board;
     
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};
     
    static boolean flag;
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                 
                for (int dir = 0; dir < 4; dir++) {
                    int newX = i + dx[dir];
                    int newY = j + dy[dir];
                    if (newX<0 || newX>=19 || newY<0 || newY>=19) continue;
                    if (board[newX][newY] != 0) {
                        int tempX = i - dx[dir];
                        int tempY = j - dy[dir];
                        if (tempX>=0 && tempX<19 && tempY>=0 && tempY<19
                                && board[tempX][tempY] == board[newX][newY]) continue;
                        dfs(i, j, dir, 1);
                        if (flag) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        }
                    }
                }
                 
            }
        }
         
        System.out.println(0);
    }
     
    private static void dfs(int x, int y, int dir, int cnt) {
        int nextX = x + dx[dir];
        int nextY = y + dy[dir];
         
        if (nextX<0 || nextX>=19 || nextY<0 || nextY>=19) {
            if (cnt == 5) flag = true;
            return;
        }
         
        if (board[nextX][nextY] == board[x][y]) {
            dfs(nextX, nextY, dir, cnt+1);
        } else {
            if (cnt == 5) flag = true;
            return;
        }
    }
}