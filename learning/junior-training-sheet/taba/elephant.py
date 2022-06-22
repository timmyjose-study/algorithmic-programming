def main():
    c = 0
    n = int(input().strip())

    for d in range(5, 0, -1):
        if n == 0:
            break
        c += n // d
        n %= d

    print(c)


if __name__ == "__main__":
    main()