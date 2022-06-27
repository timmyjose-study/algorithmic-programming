def main():
    s = list(input())

    sol = 0
    i = 0
    while True:
        j = i + 1
        while (j < len(s) and j < i + 5) and (s[i] == s[j]):
            j += 1
        sol += 1
        i = j

        if i == len(s):
            break

    print(sol)



if __name__ == "__main__":
    main()



