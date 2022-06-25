def main():
    [n, k] = list(map(int, input().split()))

    s = ""
    c = 0
    for i in range(n):
        s += chr(ord('a') + (i + c) % k)
    print(s)


if __name__ == "__main__":
    main()