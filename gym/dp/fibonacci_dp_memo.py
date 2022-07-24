# Top Down
# O(N) time, O(N) space

def fibonacci(n):
    d = dict()
    d[0] = 0
    d[1] = 1

    return fibonacci_helper(n, d)

def fibonacci_helper(n, d):
    assert n >= 0

    if n <= 1:
        return n
    else:
        l, r = -1, -1

        if n - 1 in d:
            l = d[n-1]
        else:
            l = fibonacci_helper(n-1, d)
            d[n-1] = l

        if n - 2 in d:
            r = d[n-2]
        else:
            r = fibonacci_helper(n-2, d)
            d[n-2] = r

        return l + r

def main():
    while True:
        try:
            n = int(input())
            print(f"fibonacci({n}) = {fibonacci(n)}")

        except EOFError:
            break

if __name__ == "__main__":
    main()