def binary_search_iter(a, low, high, e):
    while low <= high:
        mid = (low + high) // 2

        if a[mid] == e:
            return mid
        elif a[mid] < e:
            low = mid + 1
        else:
            high = mid - 1
    return -1

def binary_search(a, low, high, e):
    if low > high:
        return -1

    mid = (low + high) // 2

    if a[mid] == e:
        return mid
    elif a[mid] < e:
        return binary_search(a, mid + 1, high, e)
    else:
        return binary_search(a, low, mid - 1, e)

def main():
    while True:
        try:
            (n, e) = map(int, input().split())
            a = list(map(int, input().split()))
            a.sort()
            print(f"sorted a = {a}, e = {e}")
            print(f"{binary_search(a, 0, n - 1, e)}, {binary_search_iter(a, 0, n - 1, e)}")
        except EOFError:
            break

if __name__ == "__main__":
    main()