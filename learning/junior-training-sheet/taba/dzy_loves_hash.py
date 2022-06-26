def main():
    [p, n] = list(map(int, input().split()))
    
    s = set()
    for i in range(n):
        m = int(input())
        h = m % p

        if h in s:
            print(i + 1)
            return
        else:
            s.add(h)
    print(-1)



if __name__ == "__main__":
    main()

