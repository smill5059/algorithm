

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17281_야구 {
	private static int N, max, numbers[], board[][];
	private static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[9];
		isSelected = new boolean[9];
		isSelected[0] = true; //1번은 4번투수로 내정
		permutation(0);
		System.out.println(max);
	}
	
	private static void permutation(int cnt) {		
		if (cnt == 9) {
			max = Math.max(max, solve());
			return;
		}
		
		if (cnt == 3) {
			permutation(cnt+1);
		} else {
			for (int i = 1; i < 9; i++) {
				if (isSelected[i]) continue;
				
				numbers[cnt] = i;
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
		
	}
	
	private static int solve() {
		int taja = 0;
		int score = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			boolean[] ground = new boolean[4];
			while (true) {
				if (out == 3) break;
				
				int result = board[i][numbers[taja]];
				if (result == 0) { //아웃
					out++;
				} else if (result == 4) { //홈런
					for (int r = 1; r < 4; r++) {
						if (ground[r]) {
							ground[r] = false;
							score++;
						}
					}
					score++;
				} else { //안타
					Queue<Integer> q = new LinkedList<>();
					for (int r = 1; r < 4; r++) {
						if (ground[r]) {
							ground[r] = false;
							int next = r+result;
							if (next >= 4) {
								score++;
							} else {
								q.offer(next);
							}
						}
					}
					while (!q.isEmpty()) {
						ground[q.poll()] = true;
					}
					ground[result] = true;
				}
				
				taja = (taja+1) % 9;
			}
		}
		
		return score;
	}
}
