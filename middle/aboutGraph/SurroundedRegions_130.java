package middle.aboutGraph;
/**
* @Description: 给定一个棋盘，这个棋盘上面只有X和O现在让你将所有被X围起来的O全部变成X；
 * 解决办法：从棋盘的四条边出发将边能够搜索到位置（O）变为其他的元素，后边在遍历一遍棋盘将O变成X，将其他元素变成O，
* @Author: chenpeng
* @Date: 14:48 2018/10/16
* @param:
* @return:
*/
public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if (board == null || board.length < 2) {
            return;
        }
        int wlen = board.length;
        int nlen = board[0].length;
        for (int i = 0;i<wlen;i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i,0);
            }
            if (board[i][nlen-1] == 'O') {
                boundaryDFS(board,i,nlen-1);
            }
        }
        for (int i = 0;i<nlen;i++) {
            if (board[0][i] == 'O') {
                boundaryDFS(board,0,i);
            }
            if (board[wlen-1][i] == 'O') {
                boundaryDFS(board,wlen-1,i);
            }
        }
        for (int i=0;i<wlen;i++) {
             for (int j = 0;j<nlen;j++) {
                 if (board[i][j] == 'O') {
                     board[i][j] = 'X';
                 } else if (board[i][j] == '*') {
                     board[i][j] = 'O';
                 }
             }
        }
    }

    public void boundaryDFS(char[][] board,int i,int j) {
        if(i< 0|| i>board.length-1 || j<0 || j>board[0].length-1) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        //up
        if (i>1 && board[i-1][j] == 'O') {
            boundaryDFS(board,i-1,j);
        }
        //down
        if (i<board.length-2 && board[i+1][j] == 'O') {
            boundaryDFS(board,i+1,j);
        }
        //left
        if (j>1 && board[i][j-1] == 'O') {
            boundaryDFS(board,i,j-1);
        }
        //right
        if (j<board[i].length-2 && board[i][j+1] == 'O') {
            boundaryDFS(board,i,j+1);
        }

    }


//X X X X
//X O O X
//X X O X
//X O X X
//[[],
// ['X','O','O','X','O'],
// ['X','O','X','O','X'],
// ['O','X','O','O','O'],
// ['X','X','O','X','O']]
    public static void main(String[] args) {
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'X','O','O','O','O','O'},
                {'X','X','X','X','O','O'},
                {'O','X','O','O','X','O'},
                {'X','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        SurroundedRegions_130 regions_130 = new SurroundedRegions_130();
        regions_130.solve(board);
        for (char[] tmp:board) {
            System.out.println(tmp);
        }
    }
}
