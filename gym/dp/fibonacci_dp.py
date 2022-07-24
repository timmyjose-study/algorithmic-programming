# Bottom Up
# O(N) time, O(N) space
def fibonacci(n):
    assert n >= 0

    if n <= 1:
        return n

    dp = [0 for _ in range(n+1)]
    dp[0] = 0
    dp[1] = 1
    for i in range(2, n + 1):
        dp[i] = dp[i-1] + dp[i-2]

    return dp[n]

def main():
    while True:
        try:
            n = int(input())
            print(f"fibonacci({n}) = {fibonacci(n)}")
        except EOFError:
            break


if __name__ == "__main__":
    main()
