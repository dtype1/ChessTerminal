package pieces;

import board.Board;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type "Rook". This class extends the "ChessPiece" class because all checkers have the same attributes and getter are implemented here because every token has different attribute value.
 */
public class Rook extends ChessPiece {
    public Rook(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.ROOK_CHAR, Constants.ROOK, ChessUtils.convertToAscii(82));
    }
}
