package nandm;

import java.util.Scanner;

public class Main15650_N°úM2 {
	private static int N, M, numbers[];
	private static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		sb = new StringBuilder();
		combination(1, 0);
		System.out.print(sb);
		
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
}
