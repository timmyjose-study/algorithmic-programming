def main():
    [n, k] = list(map(int, input().split()))
    pos = list(map(int, input().split()))

    s = set(pos)
    for i in range(1, n*k + 1):
        s.add(i)

    sol = [[] for _ in range(k)]
    for i in range(k):
        sol[i].append(pos[i])
        s.remove(pos[i])

    for i in range(k):
        for _ in range(n-1):
            sol[i].append(s.pop())

    for row in sol:
        for col in row:
            print(col, end = ' ')
        print()

if __name__ == "__main__":
    main()

