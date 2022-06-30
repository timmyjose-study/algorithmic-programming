def main():
    [f, s, t] = list(map(int, input().strip().split()))

    print(
        min(
            abs(f - s) + abs(f - t),
            min(abs(s - f) + abs(s - t),
                abs(t - f) + abs(t - s))))


if __name__ == "__main__":
    main()