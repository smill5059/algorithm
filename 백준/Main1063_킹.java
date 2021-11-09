package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1063_ŷ {
	private static class Loc {
		int r;
		int c;
		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static int dr[] = {0, 0, 1, -1, -1, -1, 1, 1};
	private static int dc[] = {1, -1, 0, 0, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		String temp = st.nextToken();
		Loc king = new Loc(8-(temp.charAt(1)-'0'), temp.charAt(0)-'A');
		temp = st.nextToken();
		Loc stone = new Loc(8-(temp.charAt(1)-'0'), temp.charAt(0)-'A');
		
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String order = in.readLine();
			int d = -1;
			if ("R".equals(order)) d = 0;
			else if ("L".equals(order)) d = 1;
			else if ("B".equals(order)) d = 2;
			else if ("T".equals(order)) d = 3;
			else if ("RT".equals(order)) d = 4;
			else if ("LT".equals(order)) d = 5;
			else if ("RB".equals(order)) d = 6;
			else if ("LB".equals(order)) d = 7;
			
			int kr = king.r;
			int kc = king.c;
			int newkr = kr + dr[d];
			int newkc = kc + dc[d];
			if (newkr<0 || newkr>=8 || newkc<0 || newkc>=8) continue;
			if (newkr == stone.r && newkc == stone.c) {
				int sr = stone.r;
				int sc = stone.c;
				int newsr = sr + dr[d];
				int newsc = sc + dc[d];
				if (newsr<0 || newsr>=8 || newsc<0 || newsc>=8) continue;
				stone.r = newsr;
				stone.c = newsc;
			}
			king.r = newkr;
			king.c = newkc;
		}
		
		System.out.println(changeIntToCode(king));
		System.out.println(changeIntToCode(stone));
	}
	
	private static String changeIntToCode(Loc l) {
		StringBuilder sb = new StringBuilder();
		sb.append((char)(l.c+'A'));
		sb.append(8-l.r);
		return sb.toString();
	}
}
