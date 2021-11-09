import sys
read = sys.stdin.readline

N = int(read())
zero = 0
one = 0
plus = []
minus = []
for _ in range(N):
    num = int(read())
    if num == 0:
        zero += 1
    elif num == 1:
        one += 1
    elif num > 0:
        plus.append(num)
    elif num < 0:
        minus.append(num)

plus.sort(reverse=True)
minus.sort()

result = 0
for i in range(0, len(plus)-1, 2):
    result += (plus[i]*plus[i+1])
if len(plus)%2 == 1:
    result += plus[len(plus)-1]

for _ in range(one):
    result += 1

for i in range(0, len(minus)-1, 2):
    result += (minus[i]*minus[i+1])
if len(minus)%2 == 1 and zero == 0:
    result += minus[len(minus)-1]

print(result)