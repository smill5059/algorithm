from collections import deque
import sys

read = sys.stdin.readline;

N, M, V = map(int, read().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, read().split())
    graph[a][b] = graph[b][a] = 1

dfs_visit_list = [0] * (N + 1)
bfs_visit_list = [0] * (N + 1)


def dfs(v):
    dfs_visit_list[v] = 1;
    print(v, end=" ")
    for i in range(1, N + 1):
        if dfs_visit_list[i] == 0 and graph[v][i] == 1:
            dfs(i)


def bfs(start):
    q = deque()
    q.append(start)
    bfs_visit_list[start] = 1
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, N + 1):
            if bfs_visit_list[i] == 0 and graph[v][i] == 1:
                q.append(i)
                bfs_visit_list[i] = 1


dfs(V)
print()
bfs(V)
