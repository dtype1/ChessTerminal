package pieces;

import utils.Constants;
import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;

/**
 * <p>This class is responsible for instantiating an object of type queen.</p>
 * <p>This class extends the "ChessPiece" class because all checkers have the same attributes.</p>
 */
public class Queen extends ChessPiece {
    public Queen(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.QUEEN_CHAR, Constants.QUEEN);
    }

    /**
     * This method is used to return the unicode icon of the token.
     * @return unicode character string
     */
    @Override
    public String toString() {
        return this.getUnicodeManager().getUnicodeIcon("\u265b");
    }
}
