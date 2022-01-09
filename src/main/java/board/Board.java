package board;

import utils.exceptions.GenericException;
import utils.Constants;

/**
 * This class is used to instantiate a checkerboard object.
 */
public class Board {
    private final int rows;
    private final int columns;
    private final BoardPiece[][] boardPieces;

    public Board(final int rows, final int columns) {
        if (rows < 1 || columns < 1 || rows > 8 || columns > 8) {
            throw new GenericException(Constants.INVALID_DIMENSION);
        }

        this.rows = rows;
        this.columns = columns;
        this.boardPieces = new BoardPiece[this.rows][this.columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    /**
     * This method is used to get the Piece object contained in the cell at x and y coordinates.
     * @param boardCoordinate coordinate object
     * @return Piece object at x and y coordinate
     * @exception  GenericException if coordinate are out of chess bound
     */
    public BoardPiece getPiece(BoardCoordinate boardCoordinate) {
        if (coordinateExists(boardCoordinate)) {
            throw new GenericException(Constants.BOARD_INDEX_OUT_OF_BOUND);
        }

        return this.boardPieces[boardCoordinate.getX()][boardCoordinate.getY()];
    }

    /**
     * This method is used to get the Piece object contained in the cell at x and y coordinates.
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     * @return Piece object at x and y coordinate
     * @exception GenericException if coordinate are out of chess bound
     */
    public BoardPiece getPiece(int x, int y) {
        if (coordinateExists(x, y)) {
            throw new GenericException(Constants.BOARD_INDEX_OUT_OF_BOUND);
        }

        return this.boardPieces[x][y];
    }

    /**
     * This method deals with placing a token in an x and y cell.
     * @param boardPiece piece object that represents the piece you want to position
     * @param boardCoordinate object coordinate which refers to the position on the chessboard
     * @exception GenericException if in that x y cell is already present a pawn
     */
    public void placePiece(BoardPiece boardPiece, BoardCoordinate boardCoordinate) {
        if (isThereAPiece(boardCoordinate)) {
            throw new GenericException(Constants.PIECE_ALREADY_EXIST);
        }

        this.boardPieces[boardCoordinate.getX()][boardCoordinate.getY()] = boardPiece;
        boardPiece.boardCoordinate = boardCoordinate;
    }

    /**
     * Check if position exists into board.
     * To be valid, the row and column numbers must be within the area of the checkerboard.
     * @param coordinates: object coordinate which refers to the position on the chessboard
     * @return true or false if coordinates are in board
     */
    public boolean coordinateExists(BoardCoordinate coordinates) {
        return coordinateExists(coordinates.getX(), coordinates.getY());
    }

    /**
     * Check if position exists into board.
     * To be valid, the row and column numbers must be within the area of the checkerboard.
     * @param row number of selected row
     * @param column number of selected column
     * @return true or false if row and column are in board
     */
    public boolean coordinateExists(int row, int column) {
        return row < 0 || row >= this.rows || column < 0 || column >= this.columns;
    }

    /**
     * This method deals with checking the presence of tokens in the location at x and y coordinates.
     * @param boardCoordinate object coordinate which refers to the position on the chessboard
     * @exception GenericException if the specified coordinate is outside the indexes of the chessboard
     * @return if a pawn is present in that cell
     */
    public boolean isThereAPiece(BoardCoordinate boardCoordinate) {
        if (coordinateExists(boardCoordinate)) {
            throw new GenericException(Constants.BOARD_INDEX_OUT_OF_BOUND);
        }

        return getPiece(boardCoordinate) != null;
    }
}