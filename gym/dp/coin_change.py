# O(amount ^ |coins|)
def rec_min_coins(amount, coins):
    if amount == 0:
        return 0

    res = 2 << 32
    for coin in coins:
        if amount >= coin:
            res = min(res, rec_min_coins(amount - coin, coins) + 1)
    return res

# O(N^2)
def min_coins(amount, coins):
    dp = [0 for _ in range(amount + 1)]
    
    dp[0] = 0
    for i in range(1, amount + 1):
        dp[i] = 2 << 32
        for coin in coins:
            if i >= coin:
                dp[i] = min(dp[i], 1 + dp[i - coin])
    return dp[amount]

def main():
    [amount, ncoins] = list(map(int, input().split()))
    coins = list(map(int, input().split()))

    valid = 0
    for coin in coins:
        if amount % coin == 0:
            valid += 1

    if valid == 0:
        print("No solution")
    else:
        print(f"{rec_min_coins(amount, coins)} {min_coins(amount, coins)}")

if __name__ == "__main__":
    main()

