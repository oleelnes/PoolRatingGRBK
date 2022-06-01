package biljard.grbk.elnes.rating.handlers;

import java.io.File;
import java.io.IOException;

/**
 * Class that handles file logic.
 *
 */
public class FileHandler {


    public FileHandler(){

    }


    /**
     * Method that returns a file's type/extension. This method was found on the internet,
     * but is altered to better fit this project's purpose, see source below.
     *
     * Source: https://stackoverflow.com/a/25299575
     *
     * @param filePathString  The path to the file as a String.
     * @return                The file extension.
     */
    private String getFileExtension(String filePathString) {
        String fileName = new File(filePathString).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    /**
     * This method checks whether a folder exists or not. If it doesn't exist, it will
     * create that folder.

     * @param folder The folder (File object) that will be created, or which already exists.
     */
    public void createFolder(File folder) {
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    /**
     * Method that checks whether a file exists or not, if it does not, it will create it.
     *
     * @param file            The file to create.
     * @throws IOException    Exception.
     */
    public void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

}
