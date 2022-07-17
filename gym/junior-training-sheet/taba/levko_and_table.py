def main():
    [n, k] = list(map(int, input().split()))

    for i in range(n):
        for j in range(n):
            if i == j:
                print(k, end=' ')
            else:
                print(0, end=' ')
        print()


if __name__ == "__main__":
    main()
