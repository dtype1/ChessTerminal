package pieces;

import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type pawn. This class extends the "ChessPiece" class because all checkers have the same attributes.
 */
public class Pawn extends ChessPiece {
    public Pawn(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.PAWN_CHAR, Constants.PAWN, ChessUtils.convertToAscii(80));
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return ChessUtils.generateUnicode("\u265f");
    }
}
