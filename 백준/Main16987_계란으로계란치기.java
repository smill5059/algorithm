package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987_계란으로계란치기 {
	private static int N, eggs[][], max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		eggs = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
	
		max = 0;
		hit(0, 0);
		
		System.out.println(max);
	}
	
	/* (지금 손에 들고 있는 계란을 제외하고) */
	/* 깨지지 않은 계란이 있으면 true, 없으면 false를 반환  */
	private static boolean check(int e) {
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (i == e) continue;
			
			if (eggs[i][0] > 0) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	private static void hit(int cur, int cnt) {
		if (cur == N || !check(cur)) {
			max = Math.max(max, cnt);
			return;
		}
		
		if (eggs[cur][0] <= 0) {
			hit(cur+1, cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i == cur) continue;
			if (eggs[i][0] <= 0) continue;
			
			eggs[i][0] -= eggs[cur][1];
			eggs[cur][0] -= eggs[i][1];
			int tmp = 0;
			if (eggs[i][0] <= 0) tmp++;
			if (eggs[cur][0] <= 0) tmp++;
			
			hit(cur+1, cnt+tmp);
			
			eggs[i][0] += eggs[cur][1];
			eggs[cur][0] += eggs[i][1];
		}
	}
}
