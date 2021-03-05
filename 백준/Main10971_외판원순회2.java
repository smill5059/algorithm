import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] W;
	static boolean[] visited;
	
	static int start, min;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		W = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			start = i;
			visited[start] = true;
			dfs(i, 0, 0);
		}
		if (flag == false) min = 0;
		System.out.println(min);
	}
	
	private static void dfs(int x, int total, int cnt) {		
		if (total > min) {
			return;
		}
		
		if (cnt == N) {
			if (x == start && total < min) {
				min = total;
				flag = true;
			}
			return;
		}
		
		if (cnt == N-1) {
			visited[start] = false;
		}
		
		for (int i = 0; i < N; i++) {
			if (W[x][i] <= 0) continue;
			if (visited[i] == true) continue;
			visited[i] = true;
			dfs(i, total+W[x][i], cnt+1);
			if (i != start) visited[i] = false;
		}
		
	}
}