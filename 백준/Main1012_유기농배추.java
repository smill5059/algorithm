package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012_¿Ø±‚≥ÛπË√ﬂ {
	private static int N, M, K, map[][];
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];

			K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		map[i][j] = 0;
		
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if (map[nr][nc] == 0) continue;
				
				q.offer(nr);
				q.offer(nc);
				map[nr][nc] = 0;
			}
		}
	}
}
