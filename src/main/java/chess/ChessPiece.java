package chess;

import board.Board;
import board.BoardPiece;
import utils.ChessUtils;
import utils.UnicodeManager;

/**
 *This class is used to refer to the checkerboard and the coordinate to which it was referenced. This class is abstract because the reference to the coordinate cannot be instantiated only, it is extended to the class "ChessPiece" (also abstract) to contain the reference of a piece on the chessboard.
 */
public abstract class ChessPiece extends BoardPiece {
    private char pieceChar;
    private ChessUtils color;
    private String pieceName;
    private final UnicodeManager unicodeManager;

    public ChessPiece(Board board, ChessUtils color, char pieceChar, String pieceName) {
        super(board);
        this.color = color;
        this.pieceChar = pieceChar;
        this.pieceName = pieceName;
        this.unicodeManager = new UnicodeManager();
    }

    public UnicodeManager getUnicodeManager() {
        return this.unicodeManager;
    }

    public ChessCoordinate getChessCoordinate() {
        return ChessCoordinate.fromBoardCoordinate(boardCoordinate);
    }

    public ChessUtils getColor() {
        return color;
    }

    public void setColor(ChessUtils color) {
        this.color = color;
    }

    public char getPieceChar() {
        return pieceChar;
    }

    public void setPieceChar(char pieceChar) {
        this.pieceChar = pieceChar;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }
}
