package storage;

import org.json.simple.JSONArray;
import exceptions.GenericException;
import utils.ChessUtils;
import utils.Constants;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

/**
 * This class takes care of creating an object of type "FileManager" which will manage the actions between the chessboard and the files.
 */
@SuppressWarnings("all")
public class FileManager {
    private String directory;
    private String fileReadName;
    private String fileWriteName;
    private final Reader reader = new Reader();

    /**
     * This constructor is used when the object is instantiated without passing any parameters. Then the attributes are set to the default values (when the user does not want to customize the sources).
     */
    public FileManager() {
        this.directory = Constants.GENERIC_DIRECTORY;
        this.fileReadName = Constants.GENERIC_FILE_READ;
        this.fileWriteName = Constants.GENERIC_FILE_WRITE;
    }

    /**
     * This constructor is used when the object is instantiated by customizing the sources. Then the attributes are set to the values provided (when the user customizes the sources).
     * @param directory folder where the files will be read and stored
     * @param fileReadName name of the file to be opened for reading
     * @param fileWriteName name of the file to be created when writing the match
     */
    public FileManager(String directory, String fileReadName, String fileWriteName) {
        this.directory = directory;
        this.fileReadName = fileReadName;
        this.fileWriteName = fileWriteName;
    }

    /**
     *
     * @return
     */
    public JSONPieces loadGame() {
        try {
            ArrayList<JSONObject> chessBoard = (ArrayList<JSONObject>) this.reader.read(this.directory + this.fileReadName);
            JSONPieces jsonPieces = new JSONPieces(6);

            for (JSONObject tmp : chessBoard) {
                jsonPieces.addStoragePiece(new StoragePiece(String.valueOf(tmp.get(Constants.COMMENT_NODE)), (JSONArray) tmp.get(Constants.YELLOW_PIECE), (JSONArray) tmp.get(Constants.BLACK_PIECE)));
            }

            return jsonPieces;
        } catch(ClassCastException e) {
            throw new GenericException(Constants.WRONG_JSON_STRUCTURE);
        }
    }

    /**
     * This method is used to create the structure and populate it with the provided data. It is then passed to the writer to write it to the file.
     * @param jsonPieces container object containing an array with the nodes of the json file
     */
    public void saveGame(JSONPieces jsonPieces) {
        JSONObject singlePiecesArrJ = new JSONObject();
        ArrayList<String> json = new ArrayList<>();

        Map<String, JSONArray> singlePiecesArr = new HashMap<>();
        Map<JSONArray, JSONArray> yellowPieceList = new HashMap<>();
        Map<JSONArray, JSONArray> blackPieceList = new HashMap<>();

        for(int i = 0; i < jsonPieces.getStoragePiece().length; i++) {
            yellowPieceList.put(jsonPieces.getStoragePiece()[i].getComment(), jsonPieces.getStoragePiece()[i].getYellow());
            blackPieceList.put(jsonPieces.getStoragePiece()[i].getComment(), jsonPieces.getStoragePiece()[i].getBlack());
            singlePiecesArr.put(Constants.COMMENT_NODE, jsonPieces.getStoragePiece()[i].getComment());
            singlePiecesArr.put(Constants.YELLOW_PIECE, jsonPieces.getStoragePiece()[i].getYellow());
            singlePiecesArr.put(Constants.BLACK_PIECE, jsonPieces.getStoragePiece()[i].getBlack());
            singlePiecesArrJ.put(Constants.COMMENT_NODE, singlePiecesArr.get(Constants.COMMENT_NODE).get(0).toString());
            singlePiecesArrJ.put(Constants.YELLOW_PIECE, singlePiecesArr.get(Constants.YELLOW_PIECE));
            singlePiecesArrJ.put(Constants.BLACK_PIECE, singlePiecesArr.get(Constants.BLACK_PIECE));
            json.add(String.valueOf(singlePiecesArrJ));
        }

        // It checks if a file with the same name as the write file already exists and is not empty in the directory initially provided.
        // If another file is found, an ID number is added before the file extension.
        if(this.existFile(this.getWriteSource()) && !this.isEmptyFile(this.getWriteSource())) {
            System.out.print(ChessUtils.ANSI_RED);
            this.setFileWriteName(this.getFileWriteName().replace(Constants.FILE_EXTENSION, String.format("(%o)%s", Constants.RANDOM_NUMBER, Constants.FILE_EXTENSION)));
            System.out.println(Constants.ALTERNATIVE_FILE_WRITE + this.fileWriteName + "'");
        }

        // Pass the created structure to the method that will take care of writing it to the file.
        reader.write(this.directory + this.fileWriteName, String.valueOf(json));
    }

    /**
     * This method takes care of checking that the file exists in the directory.
     * @param fileName name of the file to be searched in the folder set at the beginning.
     * @return "true" if it exists, and "false" if the file does not exists.
     */
    public boolean existFile(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    /**
     * This method deals with verifying that a file has content in it.
     * @exception FileNotFoundException this exception is invoked when the specified file does not exist in the folder.
     * @exception IOException this exception is invoked when there are problems reading the file, so the result will be imperfect.
     * @return "true" if the file is not empty and "false" if it is empty.
     */
    public boolean isEmptyFile(String fileName) {
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(fileName));
            return br.readLine() == null;
        } catch (FileNotFoundException e) {
            throw new GenericException(Constants.FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new GenericException(Constants.GENERIC_ERROR);
        }
    }

    public String getReadSource() {
        return this.directory + this.fileReadName;
    }

    public String getWriteSource() {
        return this.directory + this.fileWriteName;
    }

    public String getDirectory() {
        return this.directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFileReadName() {
        return fileReadName;
    }

    public void setFileReadName(String fileReadName) {
        this.fileReadName = fileReadName;
    }

    public String getFileWriteName() {
        return fileWriteName;
    }

    public void setFileWriteName(String fileWriteName) {
        this.fileWriteName = fileWriteName;
    }
}