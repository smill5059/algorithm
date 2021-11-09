from collections import deque
import sys
read = sys.stdin.readline

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

def makeRect(x1, y1, x2, y2):
    for i in range(y2, y1):
        for j in range(x1, x2):
            board[i][j] = -1

def bfs(i, j, cnt):
    q = deque()
    q.append([i, j])
    board[i][j] = cnt
    size = 1
    while q:
        r, c = q.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if nr<0 or nr>=M or nc<0 or nc>=N: continue
            if board[nr][nc] == 0:
                q.append([nr, nc])
                board[nr][nc] = cnt
                size += 1
    return size


M, N, K = map(int, read().split())
board = [[0]*N for _ in range(M)]
for _ in range(K):
    x1, y1, x2, y2 = map(int, read().split())
    makeRect(x1, M-y1, x2, M-y2)

cnt = 0
answer = []
for i in range(M):
    for j in range(N):
        if board[i][j] == 0:
            cnt += 1
            answer.append(bfs(i, j, cnt))
answer.sort()

print(cnt)
for i in range(cnt):
    print(answer[i], end=" ")
