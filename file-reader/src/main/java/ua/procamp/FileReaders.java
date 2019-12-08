package ua.procamp;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {
  private   FileReaders() {}

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {

        File file = null;
        try {
            URI path = Objects.requireNonNull(FileReaders.class
                .getClassLoader().getResource(fileName)).toURI();
            file = new File(path.getPath());

        } catch ( URISyntaxException e) {
           Logger.getAnonymousLogger().log(Level.ALL, "URISyntaxException", e);

        }


     return    FileHelper.fileReader(file);


    }

}

