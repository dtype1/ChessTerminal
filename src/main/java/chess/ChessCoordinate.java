package chess;

import utils.exceptions.GenericException;
import utils.Constants;
import board.BoardCoordinate;

/**
 * This is a "container" class used to contain the coordinates referred to the classic reading (letter + number)
 */
@SuppressWarnings("unused")
public class ChessCoordinate {
    private char column;
    private int row;

    public ChessCoordinate(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new GenericException(Constants.INCORRECT_PIECE_COORDINATE);
        }

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /**
     * This method deals with converting the checkerboard coordinates (a1, h5) to cell coordinates ((1, 1), (8, 5)).
     * This method is available only of child class.
     * @return cell coordinates object
     */
    protected BoardCoordinate toBoardCoordinate() {
        return new BoardCoordinate(8 - this.row, this.column - 'a');
    }

    /**
     * This method deals with converting cell coordinates ((1, 1)) to coordinates of the checkerboard (a1).
     * @param boardCoordinate cell coordinates
     * @return chessboard coordinates
     */
    public static ChessCoordinate fromBoardCoordinate(BoardCoordinate boardCoordinate) throws GenericException {
        return new ChessCoordinate((char)('a' + boardCoordinate.getY()),8 - boardCoordinate.getX());
    }

    @Override
    public String toString() {
        return String.valueOf(this.column + this.row);
    }
}