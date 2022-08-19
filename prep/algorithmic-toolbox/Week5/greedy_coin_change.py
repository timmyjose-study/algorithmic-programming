def greedy_coin_change(money, coins):
    num_coins = 0
    while money > 0:
        for coin in coins:
            if coin <= money:
                num_coins += 1
                money -= coin
                break
    return num_coins

def recursive_coin_change(money, coins):
    if money == 0:
        return 0

    num_coins = money + 1
    for coin in coins:
        if money >= coin:
            num_coins = min(num_coins, recursive_coin_change(money - coin, coins) + 1)
    return num_coins

def dp_coin_change(money, coins):
    dp = [0 for _ in range(money + 1)]

    dp[0] = 0
    for i in range(1, money + 1):
        dp[i] = money + 1
        for coin in coins:
            if i >= coin:
                dp[i] = min(dp[i], dp[i-coin] + 1)
    return dp[money]

def main():
    coins = list(map(int, input().split()))
    coins = sorted(coins, reverse=True)

    m = 0
    while True:
        greedy = greedy_coin_change(m, coins)
        rec = recursive_coin_change(m, coins)
        dp = dp_coin_change(m, coins)

        if greedy != rec or greedy != dp or rec != dp:
            print(f"For money {m}: greedy = {greedy}, rec = {rec}, dp = {dp}")
            break
        m += 1

if __name__ == "__main__":
    main()
