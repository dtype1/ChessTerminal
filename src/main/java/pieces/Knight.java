package pieces;

import utils.Constants;
import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;

/**
 * <p>This class is responsible for instantiating an object of type knight.</p>
 * <p>This class extends the "ChessPiece" class because all checkers have the same attributes.</p>
 */
public class Knight extends ChessPiece {
    public Knight(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.KNIGHT_CHAR, Constants.KNIGHT);
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return this.getUnicodeManager().getUnicodeIcon("\u265e");
    }
}
