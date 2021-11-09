package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2583_영역구하기 {
	private static int M, N, map[][];
	
	private static int dr[] = {-1, 0, 1, 0};
	private static int dc[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			makeRect(x1, M-y1, x2, M-y2);
		}
		
		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					cnt++;
					list.add(bfs(i, j, cnt));
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	private static void makeRect(int x1, int y1, int x2, int y2) {
		for (int i = y2; i < y1; i++) {
			for (int j = x1; j < x2; j++) {
				map[i][j] = -1;
			}
		}
	}
	
	private static int bfs(int i, int j, int cnt) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		map[i][j] = cnt;
		
		int size = 1;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=M || nc<0 || nc>=N) continue;
				if (map[nr][nc] == 0) {
					q.offer(nr);
					q.offer(nc);
					map[nr][nc] = cnt;
					size++;
				}
			}
		}
		
		return size;
	}
}
