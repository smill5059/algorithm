package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2514_문자열찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		int len = input.length();
		int kCnt = 0, iCnt = 0;
		for (int i = 0; i < len-2; i++) {
			if (input.charAt(i)=='K' && input.charAt(i+1)=='O' && input.charAt(i+2)=='I') {
				kCnt++;
				i++;
			} else if (input.charAt(i)=='I' && input.charAt(i+1)=='O' && input.charAt(i+2)=='I') {
				iCnt++;
				i++;
			}
		}
		
		System.out.println(kCnt);
		System.out.println(iCnt);
	}
}
