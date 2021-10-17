package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9935_¹®ÀÚ¿­Æø¹ß {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = in.readLine().toCharArray();
		char[] bomb = in.readLine().toCharArray();
		
		int inputLen = input.length;
		int bombLen = bomb.length;
		char[] answer = new char[inputLen];
		int idx = 0;
		for (int i = 0; i < inputLen; i++) {
			answer[idx] = input[i];
			if (checkBomb(answer, bomb, idx)) {
				idx -= bombLen;
			}
			idx++;
		}
		
		String str = String.valueOf(answer, 0, idx);
		System.out.println(str.length()==0?"FRULA":str);
		
	}
	
	private static boolean checkBomb(char[] answer, char[] bomb, int idx) {
		int bombLen = bomb.length;
		
		if (idx < bombLen-1) {
			return false;
		}
		
		int start = idx-bombLen+1;
		for (int i = 0; i < bombLen; i++) {
			if (answer[start+i] != bomb[i]) {
				return false;
			}
		}
		
		return true;
	}
}
