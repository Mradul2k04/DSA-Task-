class Solution {
    private int ans = Integer.MAX_VALUE;
    private HashMap<String, Integer> memo = new HashMap<>();

    private boolean isValid(int[][] board) {
        return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
               board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 0;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private void solve(int[][] board, int move, int indx, int indy) {
        if (isValid(board)) {
            ans = Math.min(ans, move);
            return;
        }

        String converted = boardToString(board);
        if (memo.containsKey(converted) && memo.get(converted) <= move) {
            return;
        }
        memo.put(converted, move);

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        for (int[] dir : directions) {
            int nx = indx + dir[0];
            int ny = indy + dir[1];
            if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                swap(board, indx, indy, nx, ny);
                solve(board, move + 1, nx, ny);
                swap(board, indx, indy, nx, ny);
            }
        }
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public int slidingPuzzle(int[][] board) {
        int indx = 0, indy = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    indx = i;
                    indy = j;
                    break;
                }
            }
        }

        solve(board, 0, indx, indy);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}