package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2293_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		/* 초기화 */
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i]) dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
