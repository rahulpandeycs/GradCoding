package src;

//O(1) solution
public class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        int valueToAdd = player == 1 ? 1 : -1;

        if(row < rows.length) rows[row] += valueToAdd;
        if(col < cols.length) cols[col] += valueToAdd;

        if(row == col) diagonal += valueToAdd;
        if(row + col == rows.length) antiDiagonal += valueToAdd;


        if( Math.abs(rows[row]) == rows.length ||
            Math.abs(cols[col]) == cols.length ||
            Math.abs(diagonal) == rows.length ||
            Math.abs(antiDiagonal) == rows.length){

            return player;
        }
        return 0;
    }

    public static void main(String[] args){
        //Working code
    }
}
