package ua.procamp;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {

        StringBuilder s = new StringBuilder();

        try {
            URI path = Objects.requireNonNull(FileReaders.class
                    .getClassLoader().getResource(fileName)).toURI();
            File file = new File(path.getPath());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                s.append(scanner.nextLine()+"\n");
            }
            scanner.close();
        } catch (FileNotFoundException | URISyntaxException e) {
                return "";
        }
        return s.length()>0?s.toString().substring(0,s.toString().length()-1):"";

    }

}

