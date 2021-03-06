package leetcode.primary.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 */
public class ValidSudoku {


    public static void main(String[] args) {
        char[][] params =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        System.out.println(new ValidSudoku().isValidSudoku(params));
    }


    public boolean isValidSudoku(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> cellSet = new HashSet<>();
            Set<Character> containerSet = new HashSet<>();
            if (i % 3 == 0) {
                x = i;
                y = 0;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (j != 0 && j % 3 == 0) {
                    x++;
                    y -= 3;
                }
                if (rowSet.contains(board[i][j]) || cellSet.contains(board[j][i]) || containerSet.contains(board[x][y])) {
                    return false;
                }
                if ('.' != board[i][j]) {
                    rowSet.add(board[i][j]);
                }
                if ('.' != board[j][i]) {
                    cellSet.add(board[j][i]);
                }
                if ('.' != board[x][y]) {
                    containerSet.add(board[x][y]);
                }
                y++;
            }
            x -= 2;
        }
        return true;
    }


}
