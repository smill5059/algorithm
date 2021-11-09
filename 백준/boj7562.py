from collections import deque
import sys
read = sys.stdin.readline

dr = [-1, -2, -2, -1, 1, 2, 2, 1]
dc = [2, 1, -1, -2, -2, -1, 1, 2]


def bfs(start_r, start_c):
    q = deque()
    q.append(start_r)
    q.append(start_c)
    board[start_r][start_c] = 1
    while q:
        r = q.popleft()
        c = q.popleft()
        for i in range(8):
            nr = r + dr[i]
            nc = c + dc[i]
            if nr<0 or nr>=I or nc<0 or nc>=I: continue
            if board[nr][nc] > 0: continue
            q.append(nr)
            q.append(nc)
            board[nr][nc] = board[r][c] + 1
            if nr == dest_r and nc == dest_c: return



T = int(read())
for _ in range(T):
    I = int(read())
    start_r, start_c = map(int, read().split())
    dest_r, dest_c = map(int, read().split())
    board = [[0] * I for _ in range(I)]
    bfs(start_r, start_c)
    print(board[dest_r][dest_c]-1)