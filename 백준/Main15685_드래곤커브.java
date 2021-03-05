import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] matrix;
	static ArrayList<Integer> direction;
	
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input_bj_15685.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		matrix = new boolean[101][101];
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(st.nextToken()); //column
			int r = Integer.parseInt(st.nextToken()); //row
			int d = Integer.parseInt(st.nextToken()); //시작 방향
			int g = Integer.parseInt(st.nextToken()); //세대
			
			direction = new ArrayList<Integer>();
			direction.add(d);
			matrix[r][c] = true;
			r += dr[d];
			c += dc[d];
			matrix[r][c] = true;
			createCurve(r, c, g);
		}
		
		int result = count();
		System.out.println(result);
		
	}
	
	private static int count() {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j] && matrix[i][j+1] && matrix[i+1][j] && matrix[i+1][j+1]) sum++;
			}
		}
		return sum;
	}

	private static void createCurve(int r, int c, int g) {
		int nr = r, nc = c;
		for (int i = 1; i <= g; i++) {
			int cnt = direction.size();
			for (int j = 0; j < cnt; j++) {
				int d = (direction.get(cnt-j-1)+1) % 4;
				direction.add(d);
				nr += dr[d];
				nc += dc[d];
				matrix[nr][nc] = true;
			}
		}
	}
	
}