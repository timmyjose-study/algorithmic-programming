def main():
    n = int(input())
    for _ in range(n):
        s = input().strip()
        if len(s) > 10:
            w = s[0] + str(len(s) - 2) + s[len(s) - 1]
            print(w)
        else:
            print(s)


if __name__ == "__main__":
    main()