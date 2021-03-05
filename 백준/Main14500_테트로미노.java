import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*테트로미노*/
public class Main {
	
	static int N, M;
	static int[][] matrix;
	static boolean[][] selected;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max, cnt, sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		selected = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				selected[i][j] = true;
				dfs(i, j, 1, matrix[i][j]);
				selected[i][j] = false;
				
				checkExtra(i, j);
			}
		}
		
		System.out.println(max);
	}

	private static void checkExtra(int x, int y) {
		
		
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0: //ㅏ
				if (x-1>=0 && x+1<N && y+1<M)
					sum = matrix[x][y] + matrix[x-1][y] + matrix[x+1][y] + matrix[x][y+1];
				break;
			case 1: //ㅜ
				if (x+1<N && y-1>=0 && y+1<M)
					sum = matrix[x][y] + matrix[x+1][y] + matrix[x][y-1] + matrix[x][y+1];
				break;
			case 2: //ㅓ
				if (x-1>=0 && x+1<N && y-1>=0)
					sum = matrix[x][y] + matrix[x-1][y] + matrix[x+1][y] + matrix[x][y-1];
				break;
			case 3: //ㅗ
				if (x-1>=0 && y-1>=0 && y+1<M)
					sum = matrix[x][y] + matrix[x-1][y] + matrix[x][y-1] + matrix[x][y+1];
				break;
			}
			if (sum > max) max = sum;
		}
	}

	private static void dfs(int x, int y, int cnt, int sum) {
				
		if (cnt == 4) {
			if (sum > max) max = sum;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX<0 || newX>=N || newY<0 || newY>=M) continue;
			if (selected[newX][newY] == false) {
				selected[newX][newY] = true;
				dfs(newX, newY, cnt+1, sum+matrix[newX][newY]);
				selected[newX][newY] = false;
			}
		}
	}
	
}