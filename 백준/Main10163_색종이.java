import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] board = new int[101][101];
		int N = Integer.parseInt(in.readLine());
		for (int cp = 1; cp <= N; cp++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = r; i < r+w; i++) {
				for (int j = c; j < c+h; j++) {
					board[i][j] = cp;
				}
			}
		}
		
		int[] area = new int[N+1];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				area[board[i][j]]++;
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(area[i] + "\n");
		}
		System.out.print(sb.toString());
	}
}