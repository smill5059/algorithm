package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16948_데스나이트 {
	private static int N, destR, destC, min;
	private static boolean[][] isVisited;
	
	private static int[] dr = {-2, -2, 0, 0, 2, 2};
	private static int[] dc = {-1, 1, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		destR = Integer.parseInt(st.nextToken());
		destC = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N][N];
		min = 40000;
		bfs(startR, startC);
		System.out.println(min==40000?-1:min);
	}
	
	private static void bfs(int startR, int startC) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(startR);
		q.offer(startC);
		q.offer(0);
		isVisited[startR][startC] = true;
		
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			int cnt = q.poll();
			
			if (r==destR && c==destC) {
				min = Math.min(min, cnt);
			}
			
			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if (isVisited[nr][nc]) continue;
				
				q.offer(nr);
				q.offer(nc);
				q.offer(cnt+1);
				isVisited[nr][nc] = true;
			}
		}
	}
}
