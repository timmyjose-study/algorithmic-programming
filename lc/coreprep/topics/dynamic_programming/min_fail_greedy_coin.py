from collections import deque
import math

def greedy_change(amount, coins):
    cnt = 0

    while amount > 0:
        for c in coins[::-1]:
            if c <= amount:
                cnt += 1
                amount -= c
                break
    return cnt

def recursive_change(amount, coins):
    if amount == 0:
        return 0

    cnt = math.inf
    for coin in coins:
        if coin <= amount:
            cnt = min(cnt, 1 + recursive_change(amount - coin, coins))
    return cnt

def dp_change(amount, coins):
    dp = [math.inf for _ in range(amount + 1)]
    dp[0] = 0

    for i in range(amount + 1):
        for c in coins:
            if c <= i:
                dp[i] = min(dp[i], 1 + dp[i - c])
    return dp[amount]

def main():
    tt = int(input())

    for _ in range(tt):
        n = int(input())
        coins = sorted(list(map(int, input().strip().split())))

    c = 0
    while True:
        greedy = greedy_change(c, coins)
        recursive = recursive_change(c, coins)
        dp = dp_change(c, coins)

        if greedy != recursive and greedy != dp:
            print(f"Greedy failed for amount {c} - greedy was {greedy}, recursive was {recursive}, and dp was {dp}")
            break

        c += 1

if __name__ == "__main__":
    main()