def dp_coin_change(money, coins):
    dp = [0 for _ in range(money+ 1)]

    dp[0] = 0
    for i in range(1, money + 1):
        dp[i] = i + 1
        for coin in coins:
            if coin <= i:
                dp[i] = min(dp[i], dp[i - coin] + 1)
    return dp[money]

def main():
    money = int(input())
    coins = list(map(int, input().split()))

    feasible = False
    for coin in coins:
        if money % coin == 0:
            feasible = True
            break

    if not feasible:
        print("Not possible")
    else:
        print(f"money = {money}, minimum number of coins = {dp_coin_change(money, coins)}")

if __name__ == "__main__":
    main()