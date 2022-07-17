def sigma(n):
    return n * (n + 1) // 2


def main():
    n = int(input())

    i = 0
    s = 0
    while True:
        s += sigma(i)
        j = sigma(i + 1)
        if s + j > n:
            break
        i += 1
    print(i)


if __name__ == "__main__":
    main()