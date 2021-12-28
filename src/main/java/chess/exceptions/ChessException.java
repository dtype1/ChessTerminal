package chess.exceptions;

import board.exceptions.BoardException;

/**
 *
 */
public class ChessException extends BoardException {
    public ChessException(String msg) {
        super(msg);
    }
}
