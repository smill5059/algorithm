package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2491_���� {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		int len = 1;
		
		/* �����ϴ� ������ üũ */
		for (int i = 0; i < N-1; i++) {
			if (arr[i] <= arr[i+1]) len++;
			else len = 1;
			max = Math.max(max, len);
		}
		
		/* �����ϴ� ������ üũ */
		len = 1;
		for (int i = 0; i < N-1; i++) {
			if (arr[i] >= arr[i+1]) len++;
			else len = 1;
			max = Math.max(max, len);
		}
		
		System.out.println(max);
	}
}
