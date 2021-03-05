import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, total;
	
	//가로, 대각선, 세로
	private static int[] dr = {0, 1, 1};
	private static int[] dc = {1, 1, 0};

	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0);
		System.out.println(total);
	}
	
	private static void dfs(int r, int c, int d) {
		if (r == N && c == N) {
			total++;
			return;
		}
		
		if (d == 0) {
			for (int i = 0; i <= 1; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<1 || nr>N || nc<1 || nc>N || map[nr][nc] == 1) continue;
				if (i==1 && (map[r+dr[0]][c+dc[0]]==1 || map[r+dr[1]][c+dc[1]]==1 || map[r+dr[2]][c+dc[2]]==1)) continue;
				dfs(nr, nc, i);
			}
		} else if (d == 1) {
			for (int i = 0; i <= 2; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<1 || nr>N || nc<1 || nc>N || map[nr][nc] == 1) continue;
				if (i==1 && (map[r+dr[0]][c+dc[0]]==1 || map[r+dr[1]][c+dc[1]]==1 || map[r+dr[2]][c+dc[2]]==1)) continue;
				dfs(nr, nc, i);
			}
		} else if (d == 2) {
			for (int i = 1; i <= 2; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<1 || nr>N || nc<1 || nc>N || map[nr][nc] == 1) continue;
				if (i==1 && (map[r+dr[0]][c+dc[0]]==1 || map[r+dr[1]][c+dc[1]]==1 || map[r+dr[2]][c+dc[2]]==1)) continue;
				dfs(nr, nc, i);
			}
		}
	}
}