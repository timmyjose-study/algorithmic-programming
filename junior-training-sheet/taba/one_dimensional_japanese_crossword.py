def main():
    n = int(input())
    s = input().strip()

    g = 0
    sz = []
    gc = 0
    i = 0
    while i < n:
        if s[i] == 'B':
            g += 1
            while i < n and s[i] == 'B':
                i += 1
                gc += 1
            sz.append(gc)
            gc = 0
        else:
            i += 1

    print(g)
    if len(sz) != 0:
        for d in sz:
            print(d, end=' ')
        print()


if __name__ == "__main__":
    main()