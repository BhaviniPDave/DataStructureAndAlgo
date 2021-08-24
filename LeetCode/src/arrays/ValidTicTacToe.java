package arrays;

public class ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        int cntx = 0, cnto = 0;
        for (String row: board) {
            for (char cell: row.toCharArray()) {
                if (cell == 'X') {
                    cntx++;
                } else if (cell == 'O') {
                    cnto++;
                }
            }
        }
        if (cntx < cnto || cntx - cnto > 1) return false;
        int xwon = cntWon(board, 'X');
        int owon = cntWon(board, 'O');
        if (xwon > 1 || owon > 1) return false;

        if (xwon == 1) return owon == 0 && cntx > cnto;
        if (owon == 1) return xwon == 0 && cntx == cnto;

        return true;
    }

    int cntWon(String[] board, char p) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) {
                cnt++;
            }
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) {
                cnt++;
            }
        }
        if (board[1].charAt(1) == p) {
            if (board[0].charAt(0) == p && board[2].charAt(2) == p) cnt++;
            if (board[0].charAt(2) == p && board[2].charAt(0) == p) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ValidTicTacToe obj = new ValidTicTacToe();
        String[] board =  {"XXX","   ","OOO"};
        String[] board2 =  {"XOX","O O","XOX"};
        System.out.println(obj.validTicTacToe(board2));

    }
}
