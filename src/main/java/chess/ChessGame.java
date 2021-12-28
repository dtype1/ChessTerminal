package chess;

import board.Board;
import chess.exceptions.ChessException;
import pieces.*;
import storage.FileManager;
import storage.pieces.JSONPieces;
import storage.pieces.StoragePiece;
import utils.ChessUtils;
import utils.Constants;
import org.json.simple.JSONArray;

import java.util.*;
import java.util.List;

/**
 * This class handles the interactions between the checkers and the player (json file)
 */
public class ChessGame {
    private Board board;
    private final FileManager fileManager;
    private ChessUtils currentPlayer;
    private List<ChessPiece> piecesOnChessboard = new ArrayList<>();

    public ChessGame(FileManager fileManager) {
        this.board = new Board(8, 8);
        this.currentPlayer = ChessUtils.YELLOW;
        this.fileManager = fileManager;
        this.setupPieceOnChessboard();
    }

    public Board getBoard() {
        return this.board;
    }

    public ChessUtils getCurrentPlayer() {
        return this.currentPlayer;
    }

    public List<ChessPiece> getPiecesOnChessBoard() {
        return this.piecesOnChessboard;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * <p>This method is used to return the various pawns to the board.</p>
     * <p>A matrix is created and populated with all the checkers and assigned their coordinates.</p>
     * <p>Later, the TerminalManager class, when it prints the checkerboard, will call this method and cycle it to print the content and stylize it.</p>
     * @return a matrix containing the tokens
     */
    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[this.board.getRows()][this.board.getColumns()];

        for(int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix.length; k++) {
                matrix[i][k] = (ChessPiece) this.board.getPiece(i, k);
            }
        }

        return matrix;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setCurrentPlayer(ChessUtils currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPiecesOnChessboard(List<ChessPiece> piecesOnChessboard) {
        this.piecesOnChessboard = piecesOnChessboard;
    }

    /**
     * This method is used to place a new object (ChessPiece) which is a token type. Finally, the new piece is added to the pieces on the chessboard
     */
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, new ChessCoordinate(column, row).toBoardCoordinate());
        this.piecesOnChessboard.add(piece);
    }

    /**
     * This method is used to instantiate a token based on the type and color provided.
     * @param type token type based on its identifier
     * @param color token color (yellow/black)
     * @exception ChessException if the supplied token type does not identify any tokens
     * @return an object of type representing one of the pawns on the chessboard
     */
    private ChessPiece generatePiece(Character type, ChessUtils color) {
        return switch(type) {
            case Constants.ROOK_CHAR    -> new Rook(this.board, color);
            case Constants.KNIGHT_CHAR  -> new Knight(this.board, color);
            case Constants.BISHOP_CHAR  -> new Bishop(this.board, color);
            case Constants.KING_CHAR    -> new King(this.board, color);
            case Constants.QUEEN_CHAR   -> new Queen(this.board, color);
            case Constants.PAWN_CHAR    -> new Pawn(this.board, color);
            default                     -> throw new ChessException(Constants.PIECE_NOT_FOUND);
        };
    }

    /**
     *
     */
    private void setupPieceOnChessboard() {
        JSONPieces jsonPieces = this.fileManager.loadGame();

        for(int i = 0; i < jsonPieces.getStoragePiece().length; i++) {
            createSinglePiece((JSONArray) jsonPieces.getStoragePiece()[i].getBlack(), jsonPieces.getStoragePiece()[i].getComment(), ChessUtils.BLACK);
            createSinglePiece((JSONArray) jsonPieces.getStoragePiece()[i].getYellow(), jsonPieces.getStoragePiece()[i].getComment(), ChessUtils.YELLOW);
        }
    }

    /**
     *
     */
    private void createSinglePiece(JSONArray pieces, char type, ChessUtils color) {
        for(int i = 0; i < pieces.toArray().length; i++) {
            try {
                if(!(pieces.get(i).equals("null"))) {
                    char column = String.valueOf(pieces.get(i)).toLowerCase().charAt(0);
                    int row = Integer.parseInt(String.valueOf(pieces.get(i)).substring(1));

                    this.placeNewPiece(column, row, this.generatePiece(type, color));
                }
            } catch(NullPointerException ignored) {
            }
        }
    }

    public void capturePrintState() {
        JSONPieces jsonPieces = new JSONPieces(6);
        StoragePiece pawn = new StoragePiece(Constants.PAWN_CHAR), bishop = new StoragePiece(Constants.BISHOP_CHAR), knight = new StoragePiece(Constants.KNIGHT_CHAR), king = new StoragePiece(Constants.KING_CHAR), rook = new StoragePiece(Constants.ROOK_CHAR), queen = new StoragePiece(Constants.QUEEN_CHAR);

        for (ChessPiece chessPiece : this.piecesOnChessboard) {
            switch (chessPiece.getPieceChar()) {
                case Constants.PAWN_CHAR -> pawn.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
                case Constants.BISHOP_CHAR -> bishop.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
                case Constants.KING_CHAR -> king.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
                case Constants.QUEEN_CHAR -> queen.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
                case Constants.KNIGHT_CHAR -> knight.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
                case Constants.ROOK_CHAR -> rook.addCoordinateElement(chessPiece.getColor(), chessPiece.getChessCoordinate().getColumn() + "" + chessPiece.getChessCoordinate().getRow());
            }
        }

        jsonPieces.addStoragePiece(pawn);
        jsonPieces.addStoragePiece(rook);
        jsonPieces.addStoragePiece(bishop);
        jsonPieces.addStoragePiece(king);
        jsonPieces.addStoragePiece(knight);
        jsonPieces.addStoragePiece(queen);

        fileManager.saveGame(jsonPieces);
    }
}
