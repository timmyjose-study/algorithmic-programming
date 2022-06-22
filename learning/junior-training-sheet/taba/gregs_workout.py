def main():
    n = int(input().strip())
    es = list(map(int, input().split()))

    biceps = 0
    chest = 0
    back = 0
    for i in range(len(es)):
        if i % 3 == 0:
            chest += es[i]
        elif i % 3 == 1:
            biceps += es[i]
        elif i % 3 == 2:
            back += es[i]

    if biceps >= chest and biceps >= back:
        print("biceps")
    elif chest >= biceps and chest >= back:
        print("chest")
    else:
        print("back")


if __name__ == "__main__":
    main()