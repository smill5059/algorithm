package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2293_µ¿Àü1_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1];
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int[] dp = new int[k+1];
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i]) dp[j] += dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
