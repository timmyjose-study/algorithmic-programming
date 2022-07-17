from functools import reduce


def main():
    _ = int(input())
    cs = list(map(int, input().split()))
    s = reduce(lambda x, y: x + y, cs)

    w = 0
    for c in cs:
        if (s - c) % 2 == 0:
            w += 1

    print(w)


if __name__ == "__main__":
    main()