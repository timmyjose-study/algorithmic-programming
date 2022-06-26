from functools import reduce

def main():
    n = int(input())
    cs = list(map(int, input().split()))
    s = reduce(lambda x, y: x + y, cs)

    sol = 0
    for i in range(1, 6):
        if ((i + s - 1) % (n + 1)) != 0:
            sol += 1
    print(sol)


if __name__ == "__main__":
    main()

