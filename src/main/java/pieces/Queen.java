package pieces;

import board.Board;
import chess.ChessCoordinate;
import chess.ChessPiece;
import utils.ChessUtils;
import utils.Constants;

/**
 * This class is responsible for instantiating an object of type queen. This class extends the "ChessPiece" class because all checkers have the same attributes.
 */
public class Queen extends ChessPiece {
    public Queen(Board board, ChessUtils chessUtils) {
        super(board, chessUtils, Constants.QUEEN_CHAR, Constants.QUEEN, 81, "\u265b");
    }
}
