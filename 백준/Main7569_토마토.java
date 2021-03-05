import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*3차원 토마토*/
public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static class Tomato {
		int x;
		int y;
		int z;
		
		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static Queue<Tomato> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //열
		M = Integer.parseInt(st.nextToken()); //행
		H = Integer.parseInt(st.nextToken());
		
		box = new int[M][N][H];
		visited = new boolean[M][N][H];
		
		queue = new LinkedList<Tomato>();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < H; k++) {
					if (box[i][j][k] == 1) {
						queue.offer(new Tomato(i, j, k));
						cnt++;
					}
				}
			}
		}
		
		//이미 모두 익어있는 경우
		if (cnt == M*N*H) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		//모두 익지 못하는 경우
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < H; k++) {
					if (box[i][j][k] == 0) {						
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		//최소 며칠?
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < H; k++) {
					if (box[i][j][k] > max) {						
						max = box[i][j][k];
					}
				}
			}
		}
		System.out.println(max-1);
		
		
	}//end main

	private static void bfs() {
		Tomato t;
		
		while (!queue.isEmpty()) {
			t = queue.poll();
			for (int i = 0; i < 6; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				int z = t.z + dz[i];
				if (x>=0 && x<M && y>=0 && y<N && z>=0 && z<H
						&& box[x][y][z] == 0 && visited[x][y][z] == false) {
					queue.offer(new Tomato(x, y, z));
					visited[x][y][z] = true;
					box[x][y][z] = box[t.x][t.y][t.z] + 1;
				}
			}
			
		}
	}
	
}