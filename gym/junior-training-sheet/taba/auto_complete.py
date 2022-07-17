import functools

def sorter(x, y):
    xlen = len(x)
    ylen = len(y)

    for i in range(min(xlen, ylen)):
        if x[i] < y[i]:
            return -1
        elif x[i] > y[i]:
            return 1

    if xlen < ylen:
        return -1
    elif xlen > ylen:
        return 1
    return 0

def main():
    s = input().strip()
    ss = []
    n = int(input())
    for _ in range(n):
        ss.append(input().strip())

    fs = []
    for e in ss:
        if e.startswith(s):
            fs.append(e)

    if len(fs) == 0:
        print(s)
    else:
        fs = sorted(fs, key = functools.cmp_to_key(sorter))
        print(fs[0])


if __name__ == "__main__":
    main()



