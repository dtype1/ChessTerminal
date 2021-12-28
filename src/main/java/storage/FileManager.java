package storage;

import storage.exception.StorageException;
import storage.pieces.JSONPieces;
import storage.pieces.StoragePiece;
import utils.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

/**
 *
 */
public class FileManager {
    private final Reader reader = new Reader();
    private String directory;
    private String fileReadName;
    private String fileWriteName;

    public FileManager() {
        this.directory = Constants.GENERIC_DIRECTORY;
        this.fileReadName = Constants.GENERIC_FILE_READ;
        this.fileWriteName = Constants.GENERIC_FILE_WRITE;
    }

    public FileManager(String directory, String fileReadName, String fileWriteName) {
        this.directory = directory;
        this.fileReadName = fileReadName;
        this.fileWriteName = fileWriteName;
    }

    /**
     *
     */
    public JSONPieces loadGame() {
        JSONObject chessBoard = this.reader.read(this.directory + this.fileReadName);

        if(chessBoard.keySet().size() != 6) {
            throw new StorageException(Constants.JSON_ERROR);
        } else {
            JSONPieces jsonPieces = new JSONPieces(6);

            for (Object k : chessBoard.keySet()) {
                JSONObject t = (JSONObject) chessBoard.get(k);

                jsonPieces.addStoragePiece(
                        new StoragePiece(
                                String.valueOf(t.get(Constants.COMMENT_NODE)).charAt(0),
                                (ArrayList<String>) t.get(Constants.YELLOW_PIECE),
                                (ArrayList<String>) t.get(Constants.BLACK_PIECE))
                );
            }

            return jsonPieces;
        }
    }

    /**
     *
     */
    public void saveGame(JSONPieces jsonPieces) {
        JSONObject jo = new JSONObject();
        Map<String, Map<String, JSONArray>> pieces = new HashMap<>();
        Map<String, String> singlePieces = new HashMap<>();



        for(int i = 0; i < jsonPieces.getStoragePiece().length; i++) {
            ArrayList<String> test = new ArrayList<>();
            for(int j = 0; j < jsonPieces.getStoragePiece()[i].getYellow().size(); j++) {
                System.out.print(jsonPieces.getStoragePiece()[i].getYellow().get(j));
            }
            System.out.println();
            singlePieces.put(Constants.BLACK_PIECE, test.toString());
        }

        System.out.println(singlePieces.get(Constants.BLACK_PIECE));
        reader.write(this.directory + this.fileWriteName, jo);
    }

    /**
     *
     */
    public boolean existFile() {
        File file = new File(this.directory + this.fileReadName);
        return file.exists();
    }

    public boolean isEmptyFile() {
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(this.directory + this.fileReadName));
            return br.readLine() != null;
        } catch (FileNotFoundException e) {
            throw new StorageException(Constants.FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new StorageException(Constants.GENERIC_ERROR);
        }
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return this.directory;
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

