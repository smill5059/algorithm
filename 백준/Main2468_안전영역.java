import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*안전 영역*/
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = map[0][0], max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > max) max = map[i][j];
				if (map[i][j] < min) min = map[i][j];
			}
		}
		
		int cntSafetyZone = 0, maxSafetyZone = 1;
		for (int rain = min; rain < max; rain++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > rain && visited[i][j] == false) {
						bfs(i, j, rain);
						++cntSafetyZone;
					}
				}
			}
			
			if (cntSafetyZone > maxSafetyZone) maxSafetyZone = cntSafetyZone;
			//초기화
			cntSafetyZone = 0;
			for (int i = 0; i < N; i++) {				
				Arrays.fill(visited[i], false);
			}
		}
		System.out.println(maxSafetyZone);
		
	}//end main
	
	private static void bfs(int r, int c, int rain) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int[] start = {r, c};
		queue.offer(start);
				
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int tempR = temp[0];
			int tempC = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int newR = tempR + dr[i];
				int newC = tempC + dc[i];
				if (newR>=0 && newR<N && newC>=0 && newC<N
						&& map[newR][newC]>rain && visited[newR][newC] == false) {
					
					int[] newSafetyZone = {newR, newC};
					queue.offer(newSafetyZone);
					visited[newR][newC] = true;
				}
			}//end for
			
		}//end while
		
	}//end bfs
}