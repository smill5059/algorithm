package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		
		int len = input.length();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i <= len-1; i++) {
			for (int j = i+1; j <= len; j++) {
				String temp = input.substring(i, j);
				set.add(temp);
			}
		}
		
		System.out.println(set.size());
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String input = in.readLine();
//		
//		int len = input.length();
//		HashMap<String, Integer> map = new HashMap<>();
//		for (int i = 0; i <= len-1; i++) {
//			for (int j = i+1; j <= len; j++) {
//				String temp = input.substring(i, j);
//				int cnt = map.getOrDefault(temp, 0);
//				map.put(temp, cnt+1);
//			}
//		}
//		
//		System.out.println(map.size());
//	}
}
