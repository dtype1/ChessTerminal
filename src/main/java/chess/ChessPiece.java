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
    private final ChessUtils color;
    private final String pieceName;
    private final String unicode;
    private final Character pieceChar;
    private final Integer pieceAscii;

    public ChessPiece(Board board, ChessUtils color, char pieceChar, String pieceName, int pieceAscii, String unicode) {
        super(board);

        this.color = color;
        this.pieceName = pieceName;
        this.unicode = unicode;
        this.pieceChar = pieceChar;
        this.pieceAscii = pieceAscii;
    }

    /**
     * Use this method if you want to get object containing chessCoordinate
     * @return object ChessCoordinate
     */
    public ChessCoordinate getChessCoordinate() {
        return ChessCoordinate.fromBoardCoordinate(boardCoordinate);
    }

    /**
     * Use this method if you want to get colour of the token
     * @return yellow/black depending on the color of the token
     */
    public ChessUtils getColor() {
        return this.color;
    }

    /**
     * Use this method if you want to get first character of piece name
     * @return character
     */
    public char getPieceChar() {
        return this.pieceChar;
    }

    /**
     * Use this method if you want to get the full name of the token
     * @return string of piece name
     */
    public String getPieceName() {
        return pieceName;
    }

    /**
     * Use this method if you want to get the ascii character of the token
     * @return ascii character
     */
    public Character getAscii() {
        return ChessUtils.convertToAscii(this.pieceAscii);
    }

    /**
     * This method is a method that is called automatically when the object is called because it is the "toString" method.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return ChessUtils.generateUnicode(this.unicode);
    }
}
