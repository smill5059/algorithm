package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2294_����2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1]; //0���� n����
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int[] dp = new int[k+1]; //0���� k����
		Arrays.fill(dp, 10001); //�ִ����� �ʱ�ȭ
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
			}
		}
		
		System.out.println(dp[k]==10001?-1:dp[k]);
		
	}
}
