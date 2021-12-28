package utils;


public class Constants {

    // Error's or info's message
    public static final String INVALID_DIMENSION = "La dimensione deve essere maggiore di 1";
    public static final String BOARD_INDEX_OUT_OF_BOUND = "La coordinate devono essere comprese tra 1 e 8";
    public static final String PIECE_ALREADY_EXIST = "Errore: in una cella può essere posizionata una sola pedina!";
    public static final String INCORRECT_PIECE_COORDINATE = "Errore: cordinata fuori dalla scacchiera!";
    public static final String PIECE_NOT_FOUND = "Tipo di pedina non trovato";
    public static final String JSON_ERROR = "File JSON incompleto!";
    public static final String FILE_NOT_FOUND = "File non trovato!";
    public static final String IO_EXCEPTION = "Oops, c'è stato un'errore improvviso.";
    public static final String PARSE_ERROR = "Errore: parsing del file non riuscito!";
    public static final String GENERIC_ERROR = "Errore: è accaduto un errore imprevisto! Riprovare!";
    public static final String FILE_ALREADY_EXISTS = "Info: il file indicato esiste già!";

    // Piece's character id
    public static final char BISHOP_CHAR = 'B';
    public static final char KNIGHT_CHAR = 'K';
    public static final char QUEEN_CHAR = 'Q';
    public static final char ROOK_CHAR = 'R';
    public static final char KING_CHAR = 'M';
    public static final char PAWN_CHAR = 'P';

    // Piece's name
    public static final String BISHOP = "Alfiere";
    public static final String KNIGHT = "Cavallo";
    public static final String QUEEN = "Regina";
    public static final String ROOK = "Torre";
    public static final String KING = "Re";
    public static final String PAWN = "Pedine";

    // JSON File node name
    public static final String BLACK_PIECE = String.valueOf(ChessUtils.BLACK);
    public static final String YELLOW_PIECE = String.valueOf(ChessUtils.YELLOW);
    public static final String PIECE_NODE = "pieces";
    public static final String COMMENT_NODE = "__comment__";

    // Configuration
    public static final String GENERIC_DIRECTORY = "d:\\";
    public static final String GENERIC_FILE_READ = "readChess.json";
    public static final String GENERIC_FILE_WRITE = "writeChess.json";
}
