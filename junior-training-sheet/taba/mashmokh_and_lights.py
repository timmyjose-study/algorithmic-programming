def main():
    [n, m] = list(map(int, input().split()))
    bs = list(map(int, input().split()))
    ls = [None for _ in range(n)]

    for b in bs:
        for j in range(b - 1, n):
            if ls[j] == None:
                ls[j] = b
            else:
                break

    for l in ls:
        print(l, end=' ')
    print()


if __name__ == "__main__":
    main()