package pieces;

import board.Board;
import chess.ChessCoordinate;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type "Knight". This class extends the "ChessPiece" class because all checkers have the same attributes and getter are implemented here because every token has different attribute value.
 */
public class Knight extends ChessPiece {
    public Knight(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.KNIGHT_CHAR, Constants.KNIGHT, 75, "\u265e");
    }
}
