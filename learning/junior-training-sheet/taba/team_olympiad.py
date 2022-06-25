def main():
    n = int(input())
    ms = list(map(int, input().split()))

    xs = []
    ys = []
    zs = []
    for idx, m in enumerate(ms):
        if m == 1:
            xs.append(idx + 1)
        elif m == 2:
            ys.append(idx + 1)
        else:
            zs.append(idx + 1)

    t = min(min(len(xs), len(ys)), len(zs))
    print(t)

    if t != 0:
        for i in range(t):
            print(xs[i], ys[i], zs[i])


if __name__ == "__main__":
    main()