def main():
    n = int(input())
    a = list(map(int, input().split()))

    mindiff = 999999
    for i in range(1, n-1):
        maxdiff = -999999
        for j in range(n-1):
            if j == i - 1:
                maxdiff = max(maxdiff, abs(a[j+2] - a[j]))
            elif j == i:
                continue
            else:
                maxdiff = max(maxdiff, abs(a[j] - a[j+1]))
        mindiff = min(mindiff, maxdiff)
    print(mindiff)

if __name__ == "__main__":
    main()

