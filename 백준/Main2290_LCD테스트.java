package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2290_LCDÅ×½ºÆ® {
	private static StringBuilder sb;
	private static int s, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		
		sb = new StringBuilder();
		int len = n.length();
		end = 2*s+3-1;
		for (int i = 0; i <= end; i++) {
			for (int j = 0; j < len; j++) {
				switch (n.charAt(j)-'0') {
				case 0:
					zero(i);
					break;
				case 1:
					one(i);
					break;
				case 2:
					two(i);
					break;
				case 3:
					three(i);
					break;
				case 4:
					four(i);
					break;
				case 5:
					five(i);
					break;
				case 6:
					six(i);
					break;
				case 7:
					seven(i);
					break;
				case 8:
					eight(i);
					break;
				case 9:
					nine(i);
					break;
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void zero(int r) {
		if (r==0 || r==end) {
			yesGaro();
		} else if (r==end/2) {
			noGaro();
		} else {
			allSero();
		}
	}
	
	private static void one(int r) {
		if (r==0 || r==end/2 || r==end) {
			noGaro();
		} else {
			rightSero();
		}
	}
	
	private static void two(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else if (0<r && r<end/2) {
			rightSero();
		} else {
			leftSero();
		}
	}
	
	private static void three(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else {
			rightSero();
		}
	}
	
	private static void four(int r) {
		if (r==0 || r==end) {
			noGaro();
		} else if (r==end/2) {
			yesGaro();
		} else if (0<r && r<end/2) {
			allSero();
		} else {
			rightSero();
		}
	}
	
	private static void five(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else if (0<r && r<end/2) {
			leftSero();
		} else {
			rightSero();
		}
	}
	
	private static void six(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else if (0<r && r<end/2) {
			leftSero();
		} else {
			allSero();
		}
	}
	
	private static void seven(int r) {
		if (r==0) {
			yesGaro();
		} else if (r==end/2 || r==end) {
			noGaro();
		} else {
			rightSero();
		}
	}
	
	private static void eight(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else {
			allSero();
		}
	}
	
	private static void nine(int r) {
		if (r==0 || r==end/2 || r==end) {
			yesGaro();
		} else if (0<r && r<end/2) {
			allSero();
		} else {
			rightSero();
		}
	}
	
	private static void yesGaro() {
		sb.append(" ");
		for (int i = 0; i < s; i++) {
			sb.append("-");
		}
		sb.append(" ");
	}
	
	private static void noGaro() {
		for (int i = 0; i < s+2; i++) {
			sb.append(" ");
		}
	}
	
	private static void leftSero() {
		sb.append("|");
		for (int i = 0; i < s+1; i++) {
			sb.append(" ");
		}
	}
	
	private static void rightSero() {
		for (int i = 0; i < s+1; i++) {
			sb.append(" ");
		}
		sb.append("|");
	}
	
	private static void allSero() {
		sb.append("|");
		for (int i = 0; i < s; i++) {
			sb.append(" ");
		}
		sb.append("|");
	}
}
