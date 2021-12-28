package storage.exception;

import chess.exceptions.ChessException;

public class StorageException extends ChessException {
    public StorageException(String msg) {
        super(msg);
    }
}
