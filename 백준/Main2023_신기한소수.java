package net.acmicpc;

import java.util.Scanner;

public class Main2023_신기한소수 {
	private static StringBuilder sb;
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sb = new StringBuilder();
		solve(2, 1);
		solve(3, 1);
		solve(5, 1);
		solve(7, 1);
		System.out.print(sb);
		
		sc.close();
	}
	
	private static void solve(int n, int cnt) {
		if (cnt == N) {
			sb.append(n).append("\n");
			return;
		}
		
		for (int i = 1; i <= 9; i += 2) {
			if (checkPrime(n*10+i)) {
				solve(n*10+i, cnt+1);
			}
		}
	}
	
	private static boolean checkPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
