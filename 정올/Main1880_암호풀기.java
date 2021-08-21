package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1880_암호풀기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] decrypt = in.readLine().toCharArray();
		
		char[] input = in.readLine().toCharArray();
		int len = input.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char cur = input[i];
			if (Character.isUpperCase(cur)) {
				sb.append(Character.toUpperCase(decrypt[cur-'A']));
			} else if (Character.isLowerCase(cur)) {
				sb.append(decrypt[cur-'a']);
			} else {
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
