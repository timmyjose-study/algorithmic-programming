def main():
    s = list(map(int, input().strip().split("+")))
    s.sort()
    print("+".join(list(map(str, s))))


if __name__ == "__main__":
    main()