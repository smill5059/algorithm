from collections import deque
import sys
read = sys.stdin.readline

N = int(read())
M = int(read())
graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, read().split())
    graph[a][b] = graph[b][a] = 1

visit_list = [0]*(N+1)

# def bfs(start):
#     global cnt
#     cnt = 0
#     q = deque()
#     q.append(start)
#     visit_list[start] = 1
#     while q:
#         v = q.popleft()
#         cnt += 1
#         for i in range(1, N+1):
#             if (visit_list[i] == 0 and graph[v][i] == 1):
#                 q.append(i)
#                 visit_list[i] = 1
#
# bfs(1)
# print(cnt-1)

cnt = 0
def dfs(v):
    global cnt
    cnt += 1
    visit_list[v] = 1
    for i in range(1, N+1):
        if visit_list[i] == 0 and graph[v][i] == 1:
            dfs(i)

dfs(1)
print(cnt-1)