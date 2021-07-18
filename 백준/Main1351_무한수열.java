package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1351_무한수열 {
	private static long P, Q;
	private static HashMap<Long, Long> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		map = new HashMap<>();
		System.out.println(solve(N));
	}
	
	private static long solve(long i) {
		if (i == 0) return 1;
		if (map.containsKey(i)) return map.get(i);
		
		map.put(i, solve(i/P) + solve(i/Q));
		return map.get(i);
	}
}
