def main():
    n = int(input())
    ns = list(map(int, input().split()))

    min_pos = -1,
    max_pos = -1
    for idx, e in enumerate(ns):
        if e == 1:
            min_pos = idx
        elif e == n:
            max_pos = idx
    print(max(max(n - 1 - min_pos, min_pos - 0), max(n - 1 - max_pos, max_pos - 0)))


if __name__ == "__main__":
    main()

