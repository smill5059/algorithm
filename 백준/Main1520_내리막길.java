package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1520_내리막길 {
	private static int N, M;
	private static int[][] map, mem;
	
	// 상, 우, 하, 좌
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mem = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mem[i][j] = -1;
			}
		}
		
		dfs(0, 0);
		System.out.println(mem[0][0]);
		
	}
	
	private static int dfs(int r, int c) {
		if (r==N-1 && c==M-1) {
			return 1;
		}
		
		if (mem[r][c] == -1) {
			mem[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if (map[nr][nc] < map[r][c]) {
					mem[r][c] += dfs(nr, nc);
				}
			}
		}
		
		return mem[r][c];
	}
}
