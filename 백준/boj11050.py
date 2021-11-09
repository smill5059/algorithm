N, K = map(int, input().split())

# total = 0
# def combination(start, cnt):
#     if cnt == K:
#         global total
#         total += 1
#         return
#     for i in range(start, N):
#         combination(i+1, cnt+1)
#
# combination(0, 0)
# print(total)

import itertools
result = list(itertools.combinations([0]*N, K))
print(len(result))