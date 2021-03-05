import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;	
	static int min = Integer.MAX_VALUE;
	
	private static class Location{
		int r;
		int c;
		Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static List<Location> chickenList = new ArrayList<Location>();
	static List<Location> houseList = new ArrayList<Location>();
	
	static Location[] remain;
	static Queue<Location[]> queue = new LinkedList<Location[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int kind = Integer.parseInt(st.nextToken());
				if (kind == 2) chickenList.add(new Location(i, j));
				else if (kind == 1) houseList.add(new Location(i, j));
			}
		}
		
		remain = new Location[M];
		combination(0, 0);
		findMin();
		System.out.println(min);
	}
	
	private static void combination(int start, int cnt) {
		
		if (cnt == M) {
			queue.offer(Arrays.copyOf(remain, remain.length));
			return;
		}
		
		int temp = chickenList.size();
		for (int i = start; i < temp; i++) {
			remain[cnt] = chickenList.get(i);
			combination(i+1, cnt+1);
		}
	}
	
	private static void findMin() {
		
		while (!queue.isEmpty()) {
			Location[] temp = queue.poll();
			
			int houseCnt = houseList.size();
			int chickenCnt = temp.length;
			int sum = 0;
			for (int i = 0; i < houseCnt; i++) {
				int houseR = houseList.get(i).r;
				int houseC = houseList.get(i).c;
				int chickenDist = 2*N;
				for (int j = 0; j < chickenCnt; j++) {
					int chickenR = temp[j].r;
					int chickenC = temp[j].c;
					int dist = Math.abs(houseR-chickenR) + Math.abs(houseC-chickenC);
					if (dist < chickenDist) chickenDist = dist;
				}
				sum += chickenDist;
			}
			if (sum < min) min = sum;
		}
	}
}