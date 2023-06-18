def solution(n, target):
    a = [[] for i in range(9)]
    a[1] = [n]
    if target in a[1]: return 1
    a[2] = [int(str(n) * 2)] + [n + n, n - n, n * n, n // n]
    if target in a[2]: return 2
    for t in range(3,9):
        a[t] = [int(str(n) * t)] + list(set(sum([[eval(str(i) + k + str(j)) for i in a[x] for j in a[t-x] for k in ("+", "-", "*", "//") if not(k == "//" and j == 0)] for x in range(1,t)],[])))
        if target in a[t]:
            break
    else:
        return -1
    return t