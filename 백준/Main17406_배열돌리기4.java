import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] matrix, op;
	private static int N, M, K, min;
	
	private static boolean[] selected;
	private static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < M+1; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		op = new int[K][3]; //r, c, s
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			op[i][0] = Integer.parseInt(st.nextToken());
			op[i][1] = Integer.parseInt(st.nextToken());
			op[i][2] = Integer.parseInt(st.nextToken());
		}
		
		selected = new boolean[K];
		order = new int[K];
		min = Integer.MAX_VALUE;
		permutation(0);

		System.out.println(min);
	}
	
	private static void permutation(int cnt) {
		if (cnt == K) {
			int[][] temp = new int[N+1][];
			for (int i = 0; i < N+1; i++) {
				temp[i] = Arrays.copyOf(matrix[i], M+1);
			}
			for (int i = 0; i < K; i++) {
				for (int j = op[order[i]][2]; j > 0; j--) {
					rotate(temp, op[order[i]][0], op[order[i]][1], j);
				}
			}
			
			for (int i = 1; i < N+1; i++) {
				min = Math.min(min, solve(temp, i));
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			order[cnt] = i;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	private static void rotate(int[][] m, int r, int c, int s) {
		int temp = m[r-s][c-s];
		for (int i = 0; i < 2*s; i++) {
			m[r-s+i][c-s] = m[r-s+i+1][c-s];
		}
		for (int i = 0; i < 2*s; i++) {
			m[r+s][c-s+i] = m[r+s][c-s+i+1];
		}
		for (int i = 0; i < 2*s; i++) {
			m[r+s-i][c+s] = m[r+s-i-1][c+s];
		}
		for (int i = 0; i < 2*s; i++) {
			m[r-s][c+s-i] = m[r-s][c+s-i-1];
		}
		m[r-s][c-s+1] = temp;
	}
	
	private static int solve(int[][] m, int n) {
		int sum = 0;
		for (int i = 1; i < M+1; i++) {
			sum += m[n][i];
		}
		return sum;
	}
	
}