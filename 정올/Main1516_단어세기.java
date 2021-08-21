package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1516_단어세기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String input = in.readLine();
			if ("END".equals(input)) break;
			
			HashMap<String, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(input, " ");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (map.containsKey(word)) {
					int cnt = map.get(word);
					map.put(word, cnt+1);
				} else {
					map.put(word, 1);
				}
			}
			
			Object[] key = map.keySet().toArray();
			Arrays.sort(key);
			for (Object s : key) {
				sb.append(s).append(" : ").append(map.get(s)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
