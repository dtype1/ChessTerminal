package pieces;

import board.Board;
import chess.ChessCoordinate;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type king. This class extends the "ChessPiece" class because all checkers have the same attributes.
 */
public class King extends ChessPiece {
    public King(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.KING_CHAR, Constants.KING, 75, "\u265a");
    }
}
