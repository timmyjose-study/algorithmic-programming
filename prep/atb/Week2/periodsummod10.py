def fib(n):
    f = [0 for _ in range(n + 1)]
    f[0] = 0
    f[1] = 1

    for i in range(2, n + 1):
        f[i] = (f[i-1] % 10 + f[i-2] % 10) % 10
    return f

def main():
    n = 70
    f = fib(n)

    for i in range(1, n + 1):
        f[i] = (f[i] % 10 + f[i-1] % 10) % 10
    print(f"len = {len(f)}, f = {f}")

if __name__ == "__main__":
    main()