package pieces;

import utils.Constants;
import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;

/**
 * <p>This class is responsible for instantiating an object of type rook.</p>
 * <p>This class extends the "ChessPiece" class because all checkers have the same attributes.</p>
 */
public class Rook extends ChessPiece {
    public Rook(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.ROOK_CHAR, Constants.ROOK);
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return getUnicodeManager().getUnicodeIcon("\u265c");
    }
}
