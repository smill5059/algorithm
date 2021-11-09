import re

str = input()
ptn = re.compile("(100+1+|01)+")
print("SUBMARINE" if ptn.fullmatch(str) else "NOISE")