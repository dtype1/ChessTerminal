package pieces;

import utils.Constants;
import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;

/**
 * <p>This class is responsible for instantiating an object of type king.</p>
 * <p>This class extends the "ChessPiece" class because all checkers have the same attributes.</p>
 */
public class King extends ChessPiece {
    public King(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.KING_CHAR, Constants.KING);
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return this.getUnicodeManager().getUnicodeIcon("\u265a");
    }
}
