import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; //상, 하, 좌, 우, 대각선...
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {		
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if (W == 0 && H == 0) break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						bfs(i, j);
						++cnt;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}//end main
	
	private static void bfs(int h, int w) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(h);
		queue.offer(w);
		visited[h][w] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 8; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (newX>=0 && newX<H && newY>=0 && newY<W
						&& map[newX][newY] == 1 && visited[newX][newY] == false) {
					queue.offer(newX);
					queue.offer(newY);
					visited[newX][newY] = true;
				}
			}
		}
	}
}