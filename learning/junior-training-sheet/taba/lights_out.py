def main():
    inp = []
    out = [[1 for _ in range(3)] for _ in range(3)]

    for _ in range(3):
        inp.append(list(map(lambda d: d % 2, map(int, input().split()))))

    for i in range(3):
        for j in range(3):
            if inp[i][j] == 1:
                out[i][j] ^= 1

                if j > 0:
                    out[i][j - 1] ^= 1

                if j < 2:
                    out[i][j + 1] ^= 1

                if i > 0:
                    out[i - 1][j] ^= 1

                if i < 2:
                    out[i + 1][j] ^= 1

    for row in out:
        for elem in row:
            print(elem, end='')
        print()


if __name__ == "__main__":
    main()