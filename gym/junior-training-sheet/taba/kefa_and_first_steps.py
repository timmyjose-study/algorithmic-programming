def main():
    n = int(input())
    a = list(map(int, input().split()))

    maxseg = -1
    i = 0
    d = 1
    while i < n:
        if i < n - 1 and a[i+1] < a[i]:
            maxseg = max(maxseg, d)
            d = 1
        elif i == n - 1:
            maxseg = max(maxseg, d)
        else:
            d += 1
        i += 1

    print(maxseg)

if __name__ == "__main__":
    main()

