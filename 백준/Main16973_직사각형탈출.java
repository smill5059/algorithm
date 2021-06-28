package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16973_직사각형탈출 {
	private static class Rect {
		int r;
		int c;
		int cnt;
		public Rect(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int N, M, H, W;
	private static int[][] board;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());
		
		int result = bfs(sr, sc, fr, fc);
		System.out.println(result);
	}
	
	private static int bfs(int sr, int sc, int fr, int fc) {
		Queue<Rect> q = new LinkedList<>();
		visited[sr][sc] = true;
		q.offer(new Rect(sr, sc, 0));
		
		while (!q.isEmpty()) {
			Rect rect = q.poll();
			int r = rect.r;
			int c = rect.c;
			int cnt = rect.cnt;
			if (r == fr && c == fc) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<1 || nr>N || nc<1 || nc>M) continue;
				if (visited[nr][nc]) continue;
				
				if (checkWall(nr, nc)) continue;
				
				visited[nr][nc] = true;
				q.offer(new Rect(nr, nc, cnt+1));
			}
		}
		
		return -1;
	}
	
	private static boolean checkWall(int r, int c) {
		boolean flag = false;
		for (int i = r; i < r+H; i++) {
			for (int j = c; j < c+W; j++) {
				if (i<1 || i>N || j<1 || j>M || board[i][j]==1) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
