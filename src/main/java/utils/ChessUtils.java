package utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * This "enum" class is used to contain the color type of the checkers, the colors used in the terminal, some useful methods for conversions.
 */
@SuppressWarnings("all")
public enum ChessUtils {
    // Piece color's state
    BLACK,
    YELLOW;

    // Ansi escape colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * This method is used to convert unicode strings to graphic unicode characters
     * @param code character unicode
     * @return string containing the character
     */
    public static String generateUnicode(String code) {
        Charset defaultCharset = Charset.defaultCharset();
        byte[] sourceBytes = code.getBytes(StandardCharsets.UTF_8);

        try {
            return new String(sourceBytes, defaultCharset.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * This method deals with converting an integer number into an ASCII character
     * @param number character number
     * @return converted character
     */
    public static Character convertToAscii(int number) {
        return (char) number;
    }
}
