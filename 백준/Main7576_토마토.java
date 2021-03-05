import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*2차원 토마토*/
public class Main {
	static int N, M;
	static int[][] box;
	static boolean[][] visited;

	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 행
		box = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (box[i][j] == 1) {
					queue.offer(i);
					queue.offer(j);
					queue.offer(0);
					++cnt;
				}
			}
		}
		
		if (cnt == (M*N)) {
			System.out.println(0);
			return;
		}
		
		int day = bfs();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(day);

	}// end main

	private static int bfs() {
	
		int day = 0;
		while (!queue.isEmpty()) {	
			int tempX = queue.poll();
			int tempY = queue.poll();
			day = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = tempX + dx[i];
				int newY = tempY + dy[i];
				if (newX >= 0 && newX < M && newY >= 0 && newY < N && box[newX][newY] != -1
						&& visited[newX][newY] == false) {
					queue.offer(newX);
					queue.offer(newY);
					queue.offer(day+1);
					visited[newX][newY] = true;
					box[newX][newY] = 1;
				}
			}
		}
		return day;
		
	}// end bfs
}