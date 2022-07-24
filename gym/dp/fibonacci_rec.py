# O(2^N) time, O(N) space
def fibonacci(n):
    assert n >= 0

    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

def main():
    while True:
        try:
            n = int(input())
            print(f"fibonacci({n}) = {fibonacci(n)}")
        except EOFError:
            break

if __name__ == "__main__":
    main()