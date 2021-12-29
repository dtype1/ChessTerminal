package chess;

import board.Board;
import board.BoardPiece;
import utils.ChessUtils;

/**
 *This class is used to refer to the checkerboard and the coordinate to which it was referenced. This class is abstract because the reference to the coordinate cannot be instantiated only, it is extended to the class "ChessPiece" (also abstract) to contain the reference of a piece on the chessboard.
 */
public abstract class ChessPiece extends BoardPiece {
    /**
     * The attributes of this class are immutable since once the checkers are instanced they cannot change their characteristics as they are immutable and not required by the rules of the game itself.
     */
    private final char pieceChar;
    private final ChessUtils color;
    private final String pieceName;
    private final char pieceAscii;

    public ChessPiece(Board board, ChessUtils color, char pieceChar, String pieceName, char pieceAscii) {
        super(board);
        this.color = color;
        this.pieceChar = pieceChar;
        this.pieceName = pieceName;
        this.pieceAscii = pieceAscii;
    }

    public ChessCoordinate getChessCoordinate() {
        return ChessCoordinate.fromBoardCoordinate(boardCoordinate);
    }

    public ChessUtils getColor() {
        return color;
    }

    public char getPieceChar() {
        return pieceChar;
    }

    public String getPieceName() {
        return pieceName;
    }

    public char getPieceAscii() {
        return pieceAscii;
    }
}
