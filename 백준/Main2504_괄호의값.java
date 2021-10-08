package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504_°ýÈ£ÀÇ°ª {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		Stack<String> s = new Stack<>();
		
		int len = str.length();
		for (int i = 0; i < len; i++) {
			String cur = Character.toString(str.charAt(i));
			if ("(".equals(cur) || "[".equals(cur)) {
				s.push(cur);
			} else if (")".equals(cur)) {
				if (s.isEmpty()) break;
				
				if ("(".equals(s.peek())) {
					s.pop();
					s.push("2");
				} else {
					int temp = 0;
					while (true) {
						if (s.isEmpty()) {
							temp = -1;
							break;
						}
						if ("(".equals(s.peek())) {
							s.pop();
							break;
						}
						try {
							temp += (Integer.parseInt(s.pop()));
						} catch (NumberFormatException e) {
							temp = -1;
							break;
						}
					}
					s.push(Integer.toString(temp*2));
				}
			} else if ("]".equals(cur)) {
				if (s.isEmpty()) break;
				
				if ("[".equals(s.peek())) {
					s.pop();
					s.push("3");
				} else {
					int temp = 0;
					while (true) {
						if (s.isEmpty()) {
							temp = -1;
							break;
						}
						if ("[".equals(s.peek())) {
							s.pop();
							break;
						}
						try {
							temp += (Integer.parseInt(s.pop()));
						} catch (NumberFormatException e) {
							temp = -1;
							break;
						}
					}
					s.push(Integer.toString(temp*3));
				}
			}
		}
		
		int result = 0;
		while (!s.isEmpty()) {
			if ("(".equals(s.peek()) || ")".equals(s.peek()) ||
					"[".equals(s.peek()) || "]".equals(s.peek()) ||
					Integer.parseInt(s.peek()) < 0) {
				result = 0;
				break;
			}
			result += (Integer.parseInt(s.pop()));
		}
		System.out.println(result);
	}
}
