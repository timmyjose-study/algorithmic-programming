def main():
    n = int(input())
    ns = list(map(int, input().split()))

    e = 0
    o = 0
    for i in range(n):
        if ns[i] % 2 == 0:
            e += 1
        else:
            o += 1

    if e > o:
        for i in range(n):
            if ns[i] % 2 == 1:
                print(i + 1)
                return
    else:
        for i in range(n):
            if ns[i] % 2 == 0:
                print(i + 1)
                return


if __name__ == "__main__":
    main()

