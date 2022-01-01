package utils;

/**
 * This class is used to hold all error messages throughout the game.
 */
@SuppressWarnings("all")
public class Constants {

    // Error's or info's message
    public static final String INVALID_DIMENSION = "La dimensione deve essere maggiore di 1 e minore di 8";
    public static final String BOARD_INDEX_OUT_OF_BOUND = "La coordinate devono essere comprese tra 1 e 8";
    public static final String PIECE_ALREADY_EXIST = "In una cella può essere posizionata una sola pedina!";
    public static final String INCORRECT_PIECE_COORDINATE = "Cordinata fuori dalla scacchiera!";
    public static final String PIECE_NOT_FOUND = "Tipo di pedina non trovato";
    public static final String JSON_ERROR = "File JSON non strutturato correttamente.";
    public static final String FILE_NOT_FOUND = "File non trovato!";
    public static final String PARSE_ERROR = "Parsing del file non riuscito!";
    public static final String GENERIC_ERROR = "È accaduto un errore imprevisto (eccezione non gestita)! Riprovare!";
    public static final String IO_EXCEPTION = "Oops, è occorso un errore di IO! Riprovare!";
    public static final String WRITE_FILE_CORRECT = "Il file è stato scritto con successo";
    public static final String WRONG_JSON_STRUCTURE = "Formattazione del file errata. Seguire il file di esempio.";
    public static final String ALTERNATIVE_FILE_WRITE = "Data l'esistenza di un file con lo stesso nome fornito per la scrittura, questa parita sarà scritta nel file '";

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
    public static final String COMMENT_NODE = "__comment__";

    // Configuration
    public static final String GENERIC_DIRECTORY = "c:\\";
    public static final String GENERIC_FILE_READ = "readChess.json";
    public static final String GENERIC_FILE_WRITE = "writeChess.json";
    public static final String FILE_EXTENSION = ".json";

    public static final long RANDOM_NUMBER = Math.round(Math.random() * (500 - 10 + 1) + 10);

    public static final int NUM_ROWS = 8;
    public static final int NUM_COLUMNS = 8;
}
