package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1303_¿¸¿Ô¿¸≈ı {
	private static int N, M, power[];
	private static char map[][];
	private static boolean isVisited[][];
	
	private static int dr[] = {-1, 0, 1, 0};
	private static int dc[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		isVisited = new boolean[N][M];
		power = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isVisited[i][j]) bfs(i, j);
			}
		}
		
		System.out.println(power[0] + " " + power[1]);
	}
	
	private static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		isVisited[i][j] = true;
		
		char color = map[i][j];
		int cnt = 1;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if (isVisited[nr][nc]) continue;
				
				if (map[nr][nc] == color) {
					q.offer(nr);
					q.offer(nc);
					isVisited[nr][nc] = true;
					cnt++;
				}
			}
		}
		
		if (color == 'W') {
			power[0] += (cnt*cnt);
		} else {
			power[1] += (cnt*cnt);
		}
	}
}
