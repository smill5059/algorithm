package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697_¼û¹Ù²ÀÁú {
	private static int N, K, isVisited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		isVisited = new int[100001];
		bfs(N);
		System.out.println(isVisited[K]);
	}
	
	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		
		while (!q.isEmpty()) {
			int subin = q.poll();
			
			if (subin == K) {
				return;
			}
			
			if (check(subin-1)) {
				q.offer(subin-1);
				isVisited[subin-1] = isVisited[subin]+1;
			}
			if (check(subin+1)) {
				q.offer(subin+1);
				isVisited[subin+1] = isVisited[subin]+1;
			}
			if (check(subin*2)) {
				q.offer(subin*2);
				isVisited[subin*2] = isVisited[subin]+1;
			}
		}
	}
	
	private static boolean check(int n) {
		if (n<0 || n>100000 || isVisited[n]>0) {
			return false;
		}
		return true;
	}
}
