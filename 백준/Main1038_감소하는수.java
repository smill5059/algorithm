package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1038_감소하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N < 10) {
			System.out.println(N);
		} else if (N > 1022) {
			System.out.println(-1);
		} else {
			Queue<Long> q = new LinkedList<>();
			for (long i = 1; i < 10; i++) {
				q.offer(i);
			}
			int cnt = 9;
a:			while (true) {
				long x = q.poll();
				long temp = x % 10;
				for (int i = 0; i < temp; i++) {
					cnt++;
					long result = x*10 + i;
					if (cnt == N) {
						System.out.println(result);
						break a;
					}
					q.offer(result);
				}
			}
		}
		
		sc.close();
	}
}
