def is_safe(board, row, col):
  n = len(board)

  for c in range(n):
    if board[row][c] == 1:
      return False

  r, c = row, col
  while r >= 0 and c >= 0:
    if board[r][c] == 1:
      return False
    r -= 1
    c -= 1
  
  r, c = row, col
  while r < n and c >= 0:
    if board[r][c] == 1:
      return False
    r += 1
    c -= 1
    
  return True

def nqueens(board, col):
  if col == len(board):
    return True

  for i in range(len(board)):
    if is_safe(board, i, col):
      board[i][col] = 1

      if nqueens(board, col + 1):
        return True
      board[i][col] = 0
  return False

# For the retarded judging system
def tranpose(m, nrow, ncol):
  t = [[0 for _ in range(nrow)] for _ in range(ncol)]

  for i in range(nrow):
    for j in range(ncol):
      t[j][i] = m[i][j]
  return t

def print_board(board, nrow, ncol):
  b = tranpose(board, nrow, ncol)
  for row in b:
    for col in row:
      print(col, end = " ")
    print()

def main():
  n = int(input())

  board = [[0 for _ in range(n)] for _ in range(n)]
  if not nqueens(board, 0):
    print("Not possible")
  else:
    print_board(board, n, n)

if __name__ == "__main__" :
  main()
