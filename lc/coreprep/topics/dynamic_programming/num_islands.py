def dfs(a, i, j, n, m, visited):
    if visited[i][j]:
        return

    visited[i][j] = True

    if a[i][j] == 0:
        return

    if i > 0 and a[i- 1][j] == 1:
        dfs(a, i - 1, j, n, m, visited)

    if j > 0 and a[i][j - 1] == 1:
        dfs(a, i, j - 1, n, m, visited)

    if i < n - 1 and a[i + 1][j] == 1:
        dfs(a, i + 1, j, n, m, visited)

    if j < m - 1 and a[i][j + 1] == 1:
        dfs(a, i, j + 1, n, m, visited)


def num_islands(a, n, m):
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    cnt = 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and a[i][j] == 1:
                dfs(a, i, j, n, m, visited)
                cnt += 1
    return cnt

def main():
    tt = int(input())

    for _ in range(tt):
        [n, m] = list(map(int, input().strip().split()))
        a = []
        for _ in range(n):
            a.append(list(map(int, input().strip().split())))
        
        print(num_islands(a, n, m))

if __name__ == "__main__":
    main()

