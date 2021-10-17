package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main15989_123¥ı«œ±‚4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			
			int n = sc.nextInt();
			int[] dp = new int[n+1];
			dp[0] = 1;
			for (int i = 1; i <= 3; i++) {
				for (int j = i; j <= n; j++) {
					dp[j] += dp[j-i];
				}
			}
			sb.append(dp[n]).append("\n");
			
		}
		
		System.out.print(sb);
	}
}
