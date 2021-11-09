package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2210_숫자판점프 {
	private static int board[][];
	private static Set<String> set;
	
	private static int dr[] = {-1, 0, 1, 0};
	private static int dc[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, "", 0);
			}
		}
		
		System.out.println(set.size());
	}
	
	private static void dfs(int r, int c, String str, int cnt) {
		if (cnt == 6) {
			set.add(str);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr<0 || nr>=5 || nc<0 || nc>=5) continue;
			
			dfs(nr, nc, str+board[nr][nc], cnt+1);
		}
	}
}
