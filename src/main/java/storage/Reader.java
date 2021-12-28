package storage;

import storage.exception.StorageException;
import storage.pieces.JSONPieces;
import utils.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 *
 */
public class Reader {
    public Reader(){
    }

    /**
     *
     */
    public JSONObject read(String path) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new java.io.FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;

            return (JSONObject) jsonObject.get(Constants.PIECE_NODE);
        } catch(FileNotFoundException e) {
            throw new StorageException(Constants.FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new StorageException(Constants.IO_EXCEPTION);
        } catch (ParseException e) {
            throw new StorageException(Constants.PARSE_ERROR);
        }
    }

    /**
     *
     */
    public void write(String fileName, JSONObject object) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(String.valueOf(object));
            myWriter.close();
        } catch (IOException e) {
            System.out.println(Constants.GENERIC_ERROR);
        }
    }

    /**
     * This method is used to create a new file in case the specified file does not yet exist or is not found.
     * @exception IOException when a problem occurs writing the file
     */
    public void create(String fileName) {
        try {
            File myObj = new File(!Objects.equals(fileName, "") ? fileName : Constants.GENERIC_FILE_WRITE);

            if (!myObj.createNewFile()) {
                System.out.println(Constants.FILE_ALREADY_EXISTS);
            }
        } catch (IOException e) {
            System.out.println(Constants.GENERIC_ERROR);
        }
    }
}
