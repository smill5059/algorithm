package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2252_줄세우기 {
	private static List<List<Integer>> edge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edge = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			edge.add(new ArrayList<>());
		}
		
		/* step1. 진입차수 테이블 생성 및 진입차수 계산 */
		int[] degree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			makeEdge(from, to);
			degree[to]++;
		}
		
		/* step2. 진입차수가 0인 노드 큐에 넣기 */
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.offer(i);
				isVisited[i] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			/* step3. 큐에서 노드를 하나 꺼낸 후 그와 연결된 노드들의 진입차수 감소 */
			int v = q.poll();
			sb.append(v).append(" ");
			for (int w : edge.get(v)) {
				degree[w]--;
			}
			
			/* step2. */
			for (int i = 1; i <= N; i++) {
				if (!isVisited[i] && degree[i] == 0) {
					q.offer(i);
					isVisited[i] = true;
				}
			}
		}
		
		System.out.println(sb);
	}
	
	private static void makeEdge(int from, int to) {
		edge.get(from).add(to);
	}
}
