package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1062_°¡¸£Ä§ {
	private static int N, K, max;
	private static String words[];
	private static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = in.readLine();
		}
		
		isSelected = new boolean[26];
		String str = "antic";
		for (int i = 0; i < 5; i++) {
			isSelected[str.charAt(i)-'a'] = true;
		}
		
		K -= 5;
		if (K < 0) {
			System.out.println(0);
		} else {
			max = 0;
			combination(0, 0);
			System.out.println(max);
		}
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == K) {
			max = Math.max(max, solve());
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			combination(i+1, cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static int solve() {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			int len = words[i].length();
			for (int j = 4; j < len-4; j++) {
				if (!isSelected[words[i].charAt(j)-'a']) {
					flag = false;
					break;
				}
			}
			if (flag) result++;
		}
		
		return result;
	}
}
