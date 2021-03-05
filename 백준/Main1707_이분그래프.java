import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Node {
		int v;
		Node next;
	}
	
	static Node[] adjList;
	static boolean[] visited;
	static int[] color;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		for (int test_case = 0; test_case < tc; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			adjList = new Node[V+1];
			visited = new boolean[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				addEdge(a, b);
				addEdge(b, a);
			}
			
			boolean flag = true;
			for (int i = 1; i <= V; i++) {
				if (visited[i] == true) continue;
				color = new int[V+1];
				if (!bfs(i))
					flag = false;
			}
			if (flag)
				sb.append("YES\n");	
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addEdge(int a, int b) {
		Node temp = new Node();
		temp.v = b;
		temp.next = adjList[a];
		adjList[a] = temp;
	}
	
	private static boolean bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(x);
		visited[x] = true;
		color[x] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			Node adjNode = adjList[cur];
			while (adjNode != null) {
				int tempColor = toggle(color[cur]);
				if (visited[adjNode.v] == false) {
					queue.offer(adjNode.v);
					visited[adjNode.v] = true;
					color[adjNode.v] = tempColor;
				} else {
					if (tempColor != color[adjNode.v])
						return false;
				}
				adjNode = adjNode.next;
			}
		}
		
		return true;
	}
	
	private static int toggle(int a) {
		if (a == 1)
			return 2;
		else
			return 1;
	}
}