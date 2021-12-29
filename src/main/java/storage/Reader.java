package storage;

import exceptions.GenericException;
import utils.ChessUtils;
import utils.Constants;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

/**
 * This class handles the read/write aspects of the file.
 */
@SuppressWarnings("all")
public class Reader {
    public Reader(){

    }

    /**
     * This method deals with reading files and returning its contents.
     * @param file path including the name of the file to be read
     * @exception FileNotFoundException this exception is thrown when the given file does not exist in the folder
     * @exception IOException this exception is invoked when an unexpected error occurs during reading or writing
     * @exception ParseException this exception is thrown when an error occurs while parsing the file content from text to object
     * @return an "Object" containing the whole read file is returned.
     */
    public Object read(String file) {
        JSONParser parser = new JSONParser();

        try {
            return parser.parse(new FileReader(file));
        } catch(FileNotFoundException e) {
            throw new GenericException(Constants.FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new GenericException(Constants.IO_EXCEPTION);
        } catch (ParseException e) {
            throw new GenericException(Constants.PARSE_ERROR);
        }
    }

    /**
     * Questo metodo si occupa di scrivere i contenuto passato come parametro nel file indicato.
     * @param file path including the name of the file to be write
     * @param obj string which will be written in the indicated file
     * @exception FileNotFoundException this exception is thrown when the given file does not exist in the folder
     * @exception IOException this exception is invoked when an unexpected error occurs during reading or writing
     */
    public void write(String file, String obj) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(obj);
            fileWriter.close();

            System.out.print(ChessUtils.ANSI_GREEN);
            System.out.println(Constants.WRITE_FILE_CORRECT);
        } catch(FileNotFoundException e) {
            throw new GenericException(Constants.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Constants.GENERIC_ERROR);
        }
    }
}
