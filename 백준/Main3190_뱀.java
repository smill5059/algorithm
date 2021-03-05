import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_3190.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		Map<Integer, String> cmd = new HashMap<>();
		int L = Integer.parseInt(in.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			cmd.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Deque<int[]> snake = new LinkedList<>();
		board[0][0] = 1;
		snake.offerLast(new int[] {0, 0});
		int d = 1;
		int time = 0;
		while (true) {
			time++;
			int[] head = snake.peekLast();
			int hi = head[0] + di[d];
			int hj = head[1] + dj[d];
			if (!(0<=hi && hi<N && 0<=hj && hj<N)) break;
			if (board[hi][hj] == 1) break;
			if (board[hi][hj] != 2) {
				int[] tail = snake.pollFirst();
				board[tail[0]][tail[1]] = 0;
			}
			board[hi][hj] = 1;
			snake.offerLast(new int[] {hi, hj});
			String dir = cmd.get(time);
			if (dir != null) d = dir.equals("D")?(d+1)%4:(d+3)%4;
		}
		System.out.println(time);
		in.close();
	}
	
}