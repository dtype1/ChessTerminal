package presentation;

import chess.ChessGame;
import chess.ChessPiece;
import storage.FileManager;
import utils.ChessUtils;
import utils.Constants;
import utils.UnicodeManager;

import java.util.*;

/**
 *
 */
public class TerminalManager {
    private static FileManager fileManager = new FileManager();
    private static final Scanner scn = new Scanner(System.in);
    private static final UnicodeManager unicodeManager = new UnicodeManager();

    /**
     *
     */
    public static void init() {
        System.out.print(ChessUtils.ANSI_BLUE);
        System.out.println("""
                SCAHHIERA
                Informazioni generali:
                """);

        System.out.print(ChessUtils.ANSI_RED);
        System.out.print("\nVuoi iniziare? (si/no)? ");
        String choose = scn.nextLine();

        if(choose.equals("si") || choose.equals("s") || choose.equals("yes") || choose.equals("y")) {
            System.out.print(ChessUtils.ANSI_YELLOW);

            System.out.print("Vuoi dover impostare manualmente il gioco? ");
            choose = scn.nextLine();

            if(choose.equals("si") || choose.equals("s") || choose.equals("yes") || choose.equals("y")) {
                System.out.println("In caso un paramtero si voglia lasciare a default utilizzare il carattere '-'");
                String directory = validateInput("Directory: ", Constants.GENERIC_DIRECTORY);
                String read = validateInput("Nome file di lettura: ", Constants.GENERIC_FILE_READ);
                String write = validateInput("Nome file di scrittura: ", Constants.GENERIC_FILE_WRITE);

                fileManager = new FileManager(directory, read, write);
            }

            do {
                System.out.printf("Hai inserito il file '%s' nel percorso '%s' ? ", fileManager.getFileReadName(), fileManager.getDirectory());
                choose = scn.next();
            } while(!(checkChoose(choose) && fileManager.existFile() && fileManager.isEmptyFile()));

            ChessGame chessGame = new ChessGame(fileManager);

            System.out.print(ChessUtils.ANSI_CYAN);
            /*System.out.print("Vuoi rappresentare la scacchiera in formato ASCII/Unicode/Tabella (1/2/3): ");
            int chooseInt = scn.nextInt();

            System.out.print(ChessUtils.ANSI_RESET);
            clearTerminal();

            if(chooseInt == 1) {
                printAscii(chessGame.getPieces());
            } else if(chooseInt == 2) {
                printBoardUnicode(chessGame.getPieces());

                System.out.print("\n\nScrittura del file (s/n): ");
                if(checkChoose(scn.nextLine())) {
                    chessGame.capturePrintState();
                }
            } else {
                printTable(chessGame.getPieces());
            }*/
        } else {
            System.out.close();
            clearTerminal();
        }
    }

    /**
     *
     */
    private static void printTable(ChessPiece[][] pieces) {
        for (ChessPiece[] piece : pieces) {
            for (int k = 0; k < pieces.length; k++) {
                if (piece[k] != null) {
                    System.out.printf("%s - %s ==> %s%s %n", piece[k], piece[k].getPieceName(), piece[k].getChessCoordinate().getColumn(), piece[k].getChessCoordinate().getRow());
                }
            }
        }
    }

    /**
     *
     */
    private static void printBoardUnicode(ChessPiece[][] pieces) {
        for(int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + "\s");

            for(int k = 0; k < pieces.length; k++) {
                printPiece(pieces[i][k]);
            }

            System.out.println();
        }

        System.out.println("  A  B  C  D  E  F  G  H");
    }

    private static void printAscii(ChessPiece[][] pieces) {

    }

    /**
     *
     */
    private static void printPiece(ChessPiece piece) {
        if(piece != null) {
            if(piece.getColor() == ChessUtils.YELLOW) {
                System.out.print(ChessUtils.ANSI_WHITE + piece + ChessUtils.ANSI_RESET);
            } else {
                System.out.print(ChessUtils.ANSI_YELLOW + piece + ChessUtils.ANSI_RESET );
            }
        }

        System.out.print(" ");
    }

    /**
     *
     * @param message
     * @param defaultValue
     * @return
     */
    private static String validateInput(String message, String defaultValue) {
        String variable = "";

        do {
            System.out.print(message);
            variable = scn.nextLine();
        } while(variable.equals(""));

        return (variable.equals("-") ? defaultValue : variable);
    }

    /**
     *
     */
    private static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     *
     * @param choose
     * @return
     */
    private static boolean checkChoose(String choose) {
        return choose.equals("si") || choose.equals("s") || choose.equals("yes") || choose.equals("y");
    }
}
