# TLE
def main():
    tt = int(input())

    while tt > 0:
        n = int(input())
        a = [i for i in range(1, n + 1)]

        for i in range(1, n):
            a[i] += a[i-1]

        mx = 0
        for i in range(n):
            m = 0
            for j in range(n-1, -1, -1):
                s = 0
                if i == 0:
                    s = a[j]
                else:
                    s = a[j] - a[i-1]
                
                if s % 2 == 0:
                    m = j - i + 1
                    break
            mx = max(mx, m)
        print(mx)
        tt -= 1

if __name__ == "__main__":
    main()
