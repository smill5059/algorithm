N = int(input())
for i in range(1, N+1):
    arr = list(map(int, str(i)))
    result = i + sum(arr)
    if result == N:
        print(i)
        break;
    if i == N:
        print(0)