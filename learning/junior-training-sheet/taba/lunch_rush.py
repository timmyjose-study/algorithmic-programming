def main():
    [n, k] = list(map(int, input().split()))
    [f, t] = list(map(int, input().split()))

    j = (f - (t - k)) if t > k else f

    for _ in range(n - 1):
        [f, t] = list(map(int, input().split()))
        j = max(j, (f - (t - k)) if t > k else f)

    print(j)


if __name__ == "__main__":
    main()