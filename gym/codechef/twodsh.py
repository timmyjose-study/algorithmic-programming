def main():
  tt = int(input())
  for _ in range(tt):
    [n, a, b, c] = list(map(int, input().split()))
    d1 = (2 * min(a, b)) / 2
    b -= a
    if b <= 0:
      print("NO")
      continue
    
    d2 = (2 * min(c, b)) / 2
    if d1 + d2 >= n:
      print("YES")
    else:
      print("NO")
    

if __name__ == "__main__":
    main()