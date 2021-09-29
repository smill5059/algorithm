package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806_ºÎºÐÇÕ {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int front = 0;
		int rear = 0;
		int sum = 0;
		int min = 100001;
		while (true) {
			if (sum >= S) {
				min = Math.min(min, rear-front);
				sum -= arr[front++];
			} else if (rear == N) {
				break;
			} else {
				sum += arr[rear++];
			}
		}
		
		System.out.println(min==100001?0:min);
	}
}
