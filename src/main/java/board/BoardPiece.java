package board;

/**
 * This class is used to refer to the checkerboard and the coordinate to which it was referenced. This class is abstract because the reference to the coordinate cannot be instantiated only, it is extended to the class "ChessPiece" (also abstract) to contain the reference of a piece on the chessboard.
 */
@SuppressWarnings("unused")
public abstract class BoardPiece {
    protected BoardCoordinate boardCoordinate;
    private Board board;

    public BoardPiece(Board board) {
        this.board = board;
        this.boardCoordinate = null;
    }

    protected Board getBoard() {
        return this.board;
    }

    protected void setBoard(Board board) {
        this.board = board;
    }
}
