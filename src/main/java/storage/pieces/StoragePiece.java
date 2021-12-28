package storage.pieces;

import org.json.simple.JSONArray;
import utils.ChessUtils;

import java.util.ArrayList;

/**
 *
 */
public class StoragePiece {
    private final Character __comment__;
    private final ArrayList<String> yellow;
    private final ArrayList<String> black;

    public StoragePiece() {
        this.__comment__ = ' ';
        this.yellow = new ArrayList<>();
        this.black  = new ArrayList<>();
    }

    public StoragePiece(Character __comment__) {
        this.__comment__ = __comment__;
        this.yellow = new ArrayList<>();
        this.black = new ArrayList<>();
    }

    public StoragePiece(Character __comment__, ArrayList<String> yellow, ArrayList<String> black) {
        this.__comment__ = __comment__;
        this.yellow = yellow;
        this.black = black;
    }

    public Character getComment() {
        return this.__comment__;
    }

    public ArrayList<String> getYellow() {
        return yellow;
    }

    public ArrayList<String> getBlack() {
        return black;
    }

    public void addCoordinateElement(ChessUtils color, String value) {
        if (color == ChessUtils.YELLOW) {
            // System.out.println(color + " -->"  + value);
            this.yellow.add(value);
        } else {
            // System.out.println(color + " -->"  + value);
            this.black.add(value);
        }
    }
}
