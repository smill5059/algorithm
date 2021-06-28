package net.acmicpc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2164_Ä«µå2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dq.offerLast(i);
		}
		while (true) {
			if (dq.size() == 1) break;
			dq.pollFirst();
			dq.offerLast(dq.pollFirst());
		}
		System.out.println(dq.peek());
	}
}
