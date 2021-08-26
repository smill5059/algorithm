package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026_적록색약 {
	private static int N;
	private static char picture[][];
	private static boolean isVisited[][], isVisitedBlind[][];
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		picture = new char[N][N];
		for (int i = 0; i < N; i++) {
			picture[i] = in.readLine().toCharArray();
		}
		
		int cnt = 0, cntBlind = 0;
		isVisited = new boolean[N][N];
		isVisitedBlind = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					bfs(i, j, picture[i][j]);
					cnt++;
				}
				if (!isVisitedBlind[i][j]) {
					bfsBlind(i, j, picture[i][j]);
					cntBlind++;
				}
			}
		}
		sb.append(cnt).append(" ").append(cntBlind);
		
//		cnt = 0;
//		isVisitedBlind = new boolean[N][N];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!isVisitedBlind[i][j]) {
//					bfsBlind(i, j, picture[i][j]);
//					cnt++;
//				}
//			}
//		}
//		sb.append(cnt);
		
		System.out.println(sb);
		
	}
	
	private static void bfs(int i, int j, char rgb) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		isVisited[i][j] = true;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if (isVisited[nr][nc]) continue;
				
				if (rgb == picture[nr][nc]) {
					q.offer(nr);
					q.offer(nc);
					isVisited[nr][nc] = true;
				}
			}
		}
	}
	
	private static void bfsBlind(int i, int j, char rgb) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		isVisitedBlind[i][j] = true;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if (isVisitedBlind[nr][nc]) continue;
				
				if (rgb == picture[nr][nc] || (rgb == 'R' && picture[nr][nc] == 'G')
						|| (rgb == 'G' && picture[nr][nc] == 'R')) {
					q.offer(nr);
					q.offer(nc);
					isVisitedBlind[nr][nc] = true;
				}
			}
		}
	}
}
