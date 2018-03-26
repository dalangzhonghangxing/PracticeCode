package key_package;

public class K79WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag;
        for (int x = 0; x < board.length; x++)
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    flag = new boolean[board.length][board[0].length];
                    flag[x][y] = true;
                    if (exist(board, word, flag, x, y, 1)) return true;
                }
            }
        return false;
    }

    public boolean exist(char[][] board, String word, boolean[][] flag, int x,
            int y, int index) {
        if (index == word.length()) return true;
        boolean res = false;
        if (x > 0 && !flag[x - 1][y] && board[x - 1][y] == word.charAt(index)) {
            flag[x - 1][y] = true;
            res = exist(board, word, flag, x - 1, y, index + 1);
            flag[x - 1][y] = false;
            if (res == true) return true;
        }

        if (x < board.length - 1 && !flag[x + 1][y]
                && board[x + 1][y] == word.charAt(index)) {
            flag[x + 1][y] = true;
            res = exist(board, word, flag, x + 1, y, index + 1);
            flag[x + 1][y] = false;
            if (res == true) return true;
        }

        if (y > 0 && !flag[x][y - 1] && board[x][y - 1] == word.charAt(index)) {
            flag[x][y - 1] = true;
            res = exist(board, word, flag, x, y - 1, index + 1);
            flag[x][y - 1] = false;
            if (res == true) return true;
        }

        if (y < board[0].length - 1 && !flag[x][y + 1]
                && board[x][y + 1] == word.charAt(index)) {
            flag[x][y + 1] = true;
            res = exist(board, word, flag, x, y + 1, index + 1);
            flag[x][y + 1] = false;
            if (res == true) return true;
        }

        return false;
    }
}
