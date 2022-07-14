from sys import stdin

def readint():
    return int(stdin.readline())

def readarray():
    return list(map(int, stdin.readline().split()))

def main():
    [n, k] = readarray()

    c = 0
    for _ in range(n):
        d = readint()
        if d % k == 0:
            c += 1
    print(c)



if __name__ == "__main__":
    main()



