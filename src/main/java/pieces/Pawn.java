package pieces;

import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * <p>This class is responsible for instantiating an object of type pawn.</p>
 * <p>This class extends the "ChessPiece" class because all checkers have the same attributes.</p>
 */
public class Pawn extends ChessPiece {
    public Pawn(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.PAWN_CHAR, Constants.PAWN);
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return this.getUnicodeManager().getUnicodeIcon("\u265f");
    }
}
