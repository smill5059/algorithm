import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0}; //상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	
	static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}
		
		
		System.out.println(-total);
		int[] temp = new int[-total];
		for (int i = 0; i > total; i--) {
			//그냥 프린트 아니라 정렬 후 프린트
			temp[-i] = countHouse(i-1);
		}
		Arrays.sort(temp);
		for (int i = 0; i < -total; i++) {
			System.out.println(temp[i]);
		}
		
	}//end main
	
	private static int countHouse(int num) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == num) ++cnt;
			}
		}
		return cnt;
	}//end coundHouse

	private static void bfs(int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		--total;
		
		queue.offer(x);
		queue.offer(y);
		map[x][y] = total;
		
		while (!queue.isEmpty()) {
			int tempX = queue.poll();
			int tempY = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = tempX + dx[i];
				int newY = tempY + dy[i];
				if (newX>=0 && newX<N && newY>=0 && newY<N
						&& map[newX][newY] == 1 && visited[newX][newY] == false) {
					queue.offer(newX);
					queue.offer(newY);
					visited[newX][newY] = true;
					map[newX][newY] = total;
				}
			}
		}
	}//end bfs
}