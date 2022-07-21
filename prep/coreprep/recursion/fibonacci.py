def fibonacci(n):
    assert n >= 0

    if n < 2:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

def fibonacci_iter(n):
    if n <= 2:
        return n
    else:
        low, high = 0, 1
        for _ in range(2, n + 1):
            oldlow = low
            low = high
            high += oldlow
        return high

def main():
    while True:
        try:
            n = int(input())
            print(f"fibonacci(n) = {fibonacci(n)}, {fibonacci_iter(n)}")
        except AssertionError:
            print("invalid input")
        except EOFError:
            break

if __name__ == "__main__":
    main()


