def main():
    n = int(input())

    for _ in range(n):
        [_, before, after] = input().split()
        [b, a] = map(int, [before, after])

        if b >= 2400 and a > b:
            print("YES")
            return
    print("NO")


if __name__ == "__main__":
    main()