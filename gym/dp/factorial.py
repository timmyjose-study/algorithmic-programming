MOD = 1000000007

def main():
    tt = int(input())

    dp = [0 for _ in range(1000000)]
    dp[0] = 1
    dp[1] = 1

    for i in range(2, 1000000):
        dp[i] = ((i % MOD) * (dp[i - 1] % MOD)) % MOD

    for _ in range(tt):
        n = int(input())
        if n == 0 or n == 1:
            print(1)
        else:
            print(dp[n])

if __name__ == "__main__":
    main()
