package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2857_세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] input = new char[5][];
		for (int i = 0; i < 5; i++) {
			input[i] = in.readLine().toCharArray();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (input[i].length <= j) continue;
				sb.append(input[i][j]);
			}
		}
		
		System.out.println(sb);
	}
}
