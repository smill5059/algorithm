package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main3699_∫Ø¿Â {	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < TC; tc++) {
			
			HashMap<String, Integer>map = new HashMap<>();
		
			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				String name = st.nextToken();
				String category = st.nextToken();
				
				if (map.containsKey(category)) {
					int cnt = map.get(category);
					map.put(category, cnt+1);
				} else {
					map.put(category, 1);
				}
			}
			
			int result = 1;
			for (String key : map.keySet()) {
				result *= map.get(key)+1;
			}
			
			sb.append(--result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
