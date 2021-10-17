package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 비밀번호 저장
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		// 비밀번호 검색
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(map.get(in.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}
