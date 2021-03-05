import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] board;
	static boolean[] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		visited = new boolean['Z'+1];
        visited[board[0][0]] = true;
		move(0, 0, 1);
		System.out.println(max);
	}
	
	private static void move(int r, int c, int cnt) {
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
			char temp = board[nr][nc];
			if (visited[temp]) continue;
			visited[temp] = true;
			move(nr, nc, cnt+1);
			visited[temp] = false;
		}
		
		if (cnt > max) max = cnt;
	}
}