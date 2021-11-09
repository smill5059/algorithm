package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main2529_∫ŒµÓ»£ {
	private static int K;
	private static String sign;
	private static boolean isSelected[];
	private static Deque<String> deq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(in.readLine());
		sign = in.readLine();
		
		deq = new ArrayDeque<>();
		isSelected = new boolean[10];
		for (int i = 0; i < 10; i++) {
			isSelected[i] = true;
			dfs(i, 0, Integer.toString(i));
			isSelected[i] = false;
		}
		
		System.out.println(deq.getLast());
		System.out.println(deq.getFirst());
	}
	
	private static void dfs(int cur, int cnt, String result) {
		if (cnt == K) {
			deq.add(result);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (isSelected[i]) continue;
			
			if (sign.charAt(cnt*2) == '>') {
				if (cur > i) {
					isSelected[i] = true;
					dfs(i, cnt+1, result+i);
					isSelected[i] = false;
				}
			} else if (sign.charAt(cnt*2) == '<') {
				if (cur < i) {
					isSelected[i] = true;
					dfs(i, cnt+1, result+i);
					isSelected[i] = false;
				}
			}
		}
	}
}
