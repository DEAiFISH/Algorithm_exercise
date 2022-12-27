/**
 * 四周深度搜索
 */
public class 单词查询 {
    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        System.out.println(dfs.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "DE"));
    }

}

class Dfs {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '.';

        boolean flag = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1);

        if (flag) {
            return true;
        }

        board[i][j] = word.charAt(index);
        return false;
    }
}
