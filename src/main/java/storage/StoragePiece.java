package storage;

import org.json.simple.JSONArray;
import utils.ChessUtils;

/**
 * This class is used to create the object containing the content derived from the json file or for the json file
 */
@SuppressWarnings("all")
public class StoragePiece {
    private final Character __comment__;
    private final JSONArray yellow;
    private final JSONArray black;

    /**
     * This constructor is used when instantiating the object by indicating only its token type
     * @param __comment__ initial of the token name
     */
    public StoragePiece(Character __comment__) {
        this.__comment__ = __comment__;
        this.yellow = new JSONArray();
        this.black = new JSONArray();
    }

    /**
     * This constructor is used when all attributes of the object are passed in.
     * @param __comment__ initial of the token name
     * @param yellow json array containing the coordinates of the yellow token
     * @param black json array containing the coordinates of the black token
     */
    public StoragePiece(String __comment__, JSONArray yellow, JSONArray black) {
        this.__comment__ = __comment__.charAt(0);
        this.yellow = yellow;
        this.black = black;
    }

    /**
     * This method is used when you need the token name contained in a json array
     * @return json array containing the token name.
     */
    public JSONArray getComment() {
        JSONArray tmp = new JSONArray();
        tmp.add(this.__comment__);
        return tmp;
    }

    public Character getCommentC() {
        return this.__comment__;
    }

    public JSONArray getYellow() {
        return yellow;
    }

    public JSONArray getBlack() {
        return black;
    }

    /**
     * This method is used to add color coordinates to one of the two arrays containing token coordinates.
     * @param color token color(yellow/black)
     * @param value coordinate to add
     */
    public void addCoordinateElement(ChessUtils color, String value) {
        if (color == ChessUtils.YELLOW) {
            this.yellow.add(value);
        } else {
            this.black.add(value);
        }
    }
}
