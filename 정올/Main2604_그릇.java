package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2604_±×¸© {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		int len = input.length();
		char cur = input.charAt(0);
		int h = 10;
		for (int i = 1; i < len; i++) {
			if (cur == input.charAt(i)) h += 5;
			else {
				h += 10;
				cur = input.charAt(i);
			}
		}
		
		System.out.println(h);
	}
}
