package chess;

import board.Board;
import exceptions.GenericException;
import pieces.*;
import storage.FileManager;
import storage.JSONPieces;
import storage.StoragePiece;
import utils.ChessUtils;
import utils.Constants;
import org.json.simple.JSONArray;

import java.util.*;
import java.util.List;

/**
 * This class handles the interactions between the checkers and the player (json file).
 * Initially, this class was primarily designed to handle movement.
 */
@SuppressWarnings("unused")
public class ChessGame {
    private Board board;
    private ChessUtils currentPlayer;
    private final FileManager fileManager;
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
     * This method is used to return the various pawns to the board.
     * A matrix is created and populated with all the checkers and assigned their coordinates.
     * Later, the TerminalManager class, when it prints the checkerboard, will call this method and cycle it to print the content and stylize it.
     * @return a matrix containing the tokens
     */
    public ChessPiece[][] getPieces() throws GenericException {
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
    private void placeNewPiece(char column, int row, ChessPiece piece) throws GenericException {
        this.board.placePiece(piece, new ChessCoordinate(column, row).toBoardCoordinate());
        this.piecesOnChessboard.add(piece);
    }

    /**
     * This method is used to instantiate a token based on the type and color provided.
     * @param type token type based on its identifier
     * @param color token color (yellow/black)
     * @exception GenericException if the supplied token type does not identify any tokens
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
            default                     -> throw new GenericException(Constants.PIECE_NOT_FOUND);
        };
    }

    /**
     * This method is the main method that takes care of starting the process of reading the file. If all the integrity checks of the json file are passed, the coordinates of the checkers are divided by color within the method.
     * @throws GenericException if the json arrays containing the coordinates are null, it is reported that there is no data in the file.
     */
    private void setupPieceOnChessboard() {
        JSONPieces jsonPieces = this.fileManager.loadGame();

        try {
            for(int i = 0; i < jsonPieces.getStoragePiece().length; i++) {
                createSinglePieceByColor(jsonPieces.getStoragePiece()[i].getBlack(), jsonPieces.getStoragePiece()[i].getCommentC(), ChessUtils.BLACK);
                createSinglePieceByColor(jsonPieces.getStoragePiece()[i].getYellow(), jsonPieces.getStoragePiece()[i].getCommentC(), ChessUtils.YELLOW);
            }
        } catch(NullPointerException e) {
            throw new GenericException(Constants.JSON_ERROR);
        }
    }

    /**
     * This method is used to divide the coordinates, so you can generate the corresponding token.
     * @param pieces JSON array containing all the coordinates of a given token according to the color used as a filter.
     * @param pieceName Unique pawn initial used to distinguish pawns from each other. example: rook =/ king
     * @param color indicates the color of the pawn
     * @throws NullPointerException the exception is invoked when null is passed in the json file instead of providing "null". In this case the token would not be placed.
     */
    private void createSinglePieceByColor(JSONArray pieces, char pieceName, ChessUtils color) {
        for(int i = 0; i < pieces.toArray().length; i++) {
            try {
                if(!(pieces.get(i).equals("null"))) {
                    char column = String.valueOf(pieces.get(i)).toLowerCase().charAt(0);
                    int row = Integer.parseInt(String.valueOf(pieces.get(i)).substring(1));

                    this.placeNewPiece(column, row, this.generatePiece(pieceName, color));
                }
            } catch(NullPointerException ignored) {
            }
        }
    }

    /**
     * This method is used when the player wants to write the game. In the case of this checkerboard there is no movement, the data written in the read file is written to the write file.
     * First, the checkers are filtered and the object whose purpose is the single node of the file and also the one that will be in charge of storing them (main node of the file) is instantiated.
     * Second, the child nodes are inserted into the main node and passed to the "fileManager" for further manipulation.
     */
    public void testWritingFile() {
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
        jsonPieces.addStoragePiece(queen);
        jsonPieces.addStoragePiece(king);
        jsonPieces.addStoragePiece(bishop);
        jsonPieces.addStoragePiece(knight);
        jsonPieces.addStoragePiece(rook);
        fileManager.saveGame(jsonPieces);
    }
}
