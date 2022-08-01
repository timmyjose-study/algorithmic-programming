def greedy_change(amount, coins):
    c = 0
    while amount != 0:
        for coin in coins:
            if amount >= coin:
                c += 1
                amount -= coin
                break
    return c

def rec_change(amount, coins):
    if amount == 0:
        return 0

    c = 2 << 32
    for coin in coins:
        if amount >= coin:
            c = min(c, 1 + rec_change(amount - coin, coins))
    return c

def dp_change(amount, coins):
    dp = [0 for _ in range(amount + 1)]

    dp[0] = 0
    for i in range(1, amount + 1):
        dp[i] = 2 << 32

        for coin in coins:
            if i >= coin:
                dp[i] = min(dp[i], 1 + dp[i - coin])
    return dp[amount]


def main():
    n = int(input())
    coins = list(map(int, input().split()))
    coins = sorted(coins, reverse = True)

    amount = 1
    while True:
        g = greedy_change(amount, coins)
        r = rec_change(amount, coins)
        d = dp_change(amount, coins)

        print(f"Greedy change for {amount} = {g}")
        print(f"Recursive change for {amount} = {r}")
        print(f"DP change for {amount} = {d}")
        print()

        if g != r and g != d:
            print(f"First failure of greedy approach for {amount}")
            break

        amount += 1

if __name__ == "__main__":
    main()