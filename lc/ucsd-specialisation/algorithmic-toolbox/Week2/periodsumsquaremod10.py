def fib(n):
    f = [0 for _ in range(n + 1)]

    f[0] = 0
    f[1] = 1
    for i in range(2, n + 1):
        f[i] = f[i - 1] + f[i - 2]

    return f

def main():
    f = fib(31)

    for i in range(0, len(f)):
        f[i] *= f[i]

    for i in range(1, len(f)):
        f[i] =  (f[i] % 10 + f[i-1] % 10) % 10

    print(f)

if __name__ == "__main__":
    main()
