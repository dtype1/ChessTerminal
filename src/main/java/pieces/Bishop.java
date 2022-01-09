package pieces;

import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type bishop. This class extends the "ChessPiece" class because all checkers have the same attributes.
 */
public class Bishop extends ChessPiece {
    public Bishop(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.BISHOP_CHAR, Constants.BISHOP, 66);
    }


}
