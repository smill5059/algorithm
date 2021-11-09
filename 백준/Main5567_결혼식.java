package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5567_°áÈ¥½Ä {
	private static int N;
	private static List[] edge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		edge = new List[N+1];
		int m = Integer.parseInt(in.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			makeEdge(a, b);
			makeEdge(b, a);
		}
		
		int answer = bfs(1);
		System.out.println(answer);
	}
	
	private static void makeEdge(int from, int to) {
		if (edge[from] == null) {
			edge[from] = new ArrayList<>();
		}
		edge[from].add(to);
	}
	
	private static int bfs(int start) {
		if (edge[start] == null) {
			return 0;
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N+1];
		isVisited[start] = true;
		int cnt = 0;
		for (Object v : edge[start]) {
			q.offer((int)v);
			isVisited[(int)v] = true;
			cnt++;
		}
		
		int s = q.size();
		for (int i = 0; i < s; i++) {
			int friend = q.poll();
			if (edge[friend] == null) continue;
			for (Object v : edge[friend]) {
				if (isVisited[(int)v]) continue;
				isVisited[(int)v] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
	
}
