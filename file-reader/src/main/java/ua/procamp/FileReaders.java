package ua.procamp;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


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
      //  FileInputStream fstream = null;
        File file = null;
        try {
            URI path = Objects.requireNonNull(FileReaders.class
                .getClassLoader().getResource(fileName)).toURI();
            file = new File(path.getPath());
   //         fstream = new FileInputStream(file);
        } catch ( URISyntaxException e) {
            e.printStackTrace();
        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//
//        String strLine = null;
//        StringBuilder s = new StringBuilder();
     return    FileHelper.fileReader(file);

//Read File Line By Line
//        while (true)   {
//            try {
//                if (!((strLine = br.readLine()) != null))
//                    break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            // Print the content on the console
//            s.append(strLine+"\n");
//        }

//        try {
//            URI path = Objects.requireNonNull(FileReaders.class
//                    .getClassLoader().getResource(fileName)).toURI();
//            File file = new File(path.getPath());
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//
//                s.append(scanner.nextLine()+"\n");
//            }
//            scanner.close();
//        } catch (FileNotFoundException | URISyntaxException e) {
//                return "";
//        }
        //return s.length()>0?s.toString().substring(0,s.toString().length()-1):"";

    }

}

