def is_consonant(c):
    if c in ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y']:
        return False
    return True


def main():
    s = input().strip()
    t = ""

    for c in s:
        if is_consonant(c):
            t += "."
            if c.isupper():
                t += c.lower()
            else:
                t += c
    print(t)


if __name__ == "__main__":
    main()