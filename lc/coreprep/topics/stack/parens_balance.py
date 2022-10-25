def main():
    tt = int(input())
    for _ in range(tt):
        s = input().strip()

        st = []
        valid = True
        for c in s:
            if c in ['(', '[', '{']:
                st.append(c)
            elif c in [')', ']', '}']:
                if len(st) == 0:
                    valid = False
                    break
                t = st.pop()
                if (c == ')' and t != '(') or (c == ']' and t != '[') or (c == '}' and t != '{'):
                    valid = False
                    break

        if not valid or len(st) != 0:
            print("Invalid string")
        else:
            print("Valid string")


if __name__ == "__main__":
    main()