def main():
    k = int(input())
    p = []
    for _ in range(4):
        p.append(list(input()))

    d = dict([(i, 0) for i in range(10)])
    for i in range(4):
        for j in range(4):
            if p[i][j] == '.':
                continue

            d[ord(p[i][j])- ord('0')] += 1
            if d[ord(p[i][j])- ord('0')] > 2 * k:
                print("NO")
                return

    print("YES")

if __name__ == "__main__":
    main()

