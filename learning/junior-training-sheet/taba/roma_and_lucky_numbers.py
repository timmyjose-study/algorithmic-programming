def main():
    [_, k] = list(map(int, input().split()))
    ns = input().split()

    t = 0
    for n in ns:
        q = 0
        for c in str(n):
            if c == '4' or c == '7':
                q += 1

        if q <= k:
            t += 1
    print(t)


if __name__ == "__main__":
    main()