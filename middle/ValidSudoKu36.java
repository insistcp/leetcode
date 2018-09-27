package leetcodeAgain.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cp
 * data  2018/9/22.
 * description
 * title: 36.Valid Sudoku 有效的数独
 * 数独有效的前提是：每一行每一列都不能重复，并且九宫格中的每一个数字都处于0-9之间
 * 每一个3*3的孩子宫格不能有重复的元素
 */
public class ValidSudoKu36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < row; i++) {
            for (int j = 0;j<col;j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j]>'9' || board[i][j]<'0') {
                    return false;
                }
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        set.clear();
        for (int i = 0;i < col; i++) {
            for (int j = 0;j<row;j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }
        set.clear();
        for (int i = 0;i+3<=row; i+=3) {
            for (int j = 0;j+3<=col;j+=3) {
                int ib = i+3;
                int jb = j+3;
                for (int m = i;m<ib;m++) {
                    for (int n =j;n<jb;n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        if (set.contains(board[m][n])) {
                            return false;
                        } else {
                            set.add(board[m][n]);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }

    /**
     * {{'5','3','.','.','7','.','.','.','.'},
     * {'6','.','.','1','9','5','.','.','.'},
     * {'.','9','8','.','.','.','.','6','.'},
     * {'8','.','.','.','6','.','.','.','3'},
     * {'4','.','.','8','.','3','.','.','1'},
     * {'7','.','.','.','2','.','.','.','6'},
     * {'.','6','.','.','.','.','2','8','.'},
     * {'.','.','.','4','1','9','.','.','5'},
     * {'.','.','.','.','8','.','.','7','9'}}
     *
     *
     * [[".",".",".",".",".",".","5",".","."],
     * [".",".",".",".",".",".",".",".","."],
     * [".",".",".",".",".",".",".",".","."],
     * ["9","3",".",".","2",".","4",".","."],
     * [".",".","7",".",".",".","3",".","."],
     * [".",".",".",".",".",".",".",".","."],
     * [".",".",".","3","4",".",".",".","."],
     * [".",".",".",".",".","3",".",".","."],
     * [".",".",".",".",".","5","2",".","."]]
     * @param args
     */
    public static void main(String[] args) {
        char[][] arr = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','.','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','3','4','.','2','8','.'},
                {'.','.','.','.','.','3','.','.','5'},
                {'.','.','.','.','.','.','.','7','9'}};
        ValidSudoKu36 sodo = new ValidSudoKu36();
        boolean flag = sodo.isValidSudoku(arr);
        System.out.println(flag);
    }
}
