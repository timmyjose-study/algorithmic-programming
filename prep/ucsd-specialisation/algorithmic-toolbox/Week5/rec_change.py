def rec_coin_change(money, coins):
    if money == 0:
        return 0

    num_coins = money + 1
    for coin in coins:
        if money >= coin:
            num_coins = min(num_coins, rec_coin_change(money - coin, coins) + 1)
    return num_coins

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
        print(f"money = {money}, minimum number of coins = {rec_coin_change(money, coins)}")

if __name__ == "__main__":
    main()