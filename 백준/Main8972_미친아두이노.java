package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main8972_미친아두이노 {
	private static class Loc {
		int r;
		int c;
		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static int R, C;
	private static char[][] board;
	private static int[][] boardCrazy;
	private static Loc jonsu;
	private static List<Loc> crazy;
	
	private static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	private static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		boardCrazy = new int[R][C]; //미친 아두이노 위치만 기록
		jonsu = null;
		crazy = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'I') { //종수 위치 기억
					jonsu = new Loc(i, j);
				} else if (board[i][j] == 'R') { //미친 아두이노 위치 기억
					crazy.add(new Loc(i, j));
					boardCrazy[i][j] = 1;
				}
			}
		}
		
		String input = in.readLine();
		int len = input.length();
		int X = 0;
		boolean flag = true;
		for (int i = 0; i < len; i++) {
			X++;
			flag = moveI(input.charAt(i) - '0');
			if (!flag) break;
			flag = moveR();
			if (!flag) break;
		}
		if (!flag) System.out.println("kraj " + X);
		else {
			for (int i = 0; i < R; i++) {
				System.out.print(new String(board[i]));
				System.out.println();
			}
		}
	}
	
	//step1
	private static boolean moveI(int d) {
		int r = jonsu.r;
		int c = jonsu.c;
		
		int nr = r + dr[d];
		int nc = c + dc[d];
		if (board[nr][nc] == 'R') return false; //step2
		board[r][c] = '.';
		board[nr][nc] = 'I';
		jonsu.r = nr;
		jonsu.c = nc;
		return true;
	}
	
	//step3
	private static boolean moveR() {
		int len = crazy.size();
		for (int i = 0; i < len; i++) {
			int r = crazy.get(i).r;
			int c = crazy.get(i).c;
			
			//종수의 아두이노와 가장 가까워지는 방향 구하기
			int d = 0;
			int min = 200;
			int nr, nc;
			for (int j = 1; j <= 9; j++) {
				if (j == 5) continue;
				nr = r + dr[j];
				nc = c + dc[j];
				int temp = Math.abs(nr-jonsu.r) + Math.abs(nc-jonsu.c);
				if (temp < min) {
					min = temp;
					d = j;
				}
			}
			
			//이동
			nr = r + dr[d];
			nc = c + dc[d];
			if (board[nr][nc] == 'I') return false; //step4
			board[r][c] = '.';
			boardCrazy[r][c]--;
//			board[nr][nc] = 'R';
			boardCrazy[nr][nc]++;
		}
		
		//step5
		crazy = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (boardCrazy[i][j] > 1) {
					board[i][j] = '.';
					boardCrazy[i][j] = 0;
				} else if (boardCrazy[i][j] == 1) {
					board[i][j] = 'R';
					crazy.add(new Loc(i, j));
				}
			}
		}
		
		return true;
	}
}
