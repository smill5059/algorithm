package net.acmicpc;

import java.util.Scanner;

public class Main16953_A»≠ªÏ«•B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int result = solve(A, B);
		System.out.println(result);
		
		sc.close();
	}
	
	private static int solve(int A, int B) {
		int result = -1;
		
		int b = B;
		int cnt = 1;
		while (true) {
			if (b == A) {
				result = cnt;
				break;
			}
			if (b < A) {
				break;
			}
			
			if (b%2 == 0) {
				b /= 2;
			} else if (b%10 == 1) {
				b /= 10;
			} else {
				break;
			}
			
			cnt++;
		}
		
		return result;
	}
}
