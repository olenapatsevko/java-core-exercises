package ua.procamp;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {
    static final int ASCII_SIZE = 256;
   private  File file ;
   FileStats (String filename)  {

       URI path = null;
       try {
           path = Objects.requireNonNull(FileStats.class
                   .getClassLoader().getResource(filename)).toURI();
           this.file = new File(path.getPath());
       } catch (URISyntaxException | NullPointerException  e) {
           throw  new FileStatsException("");
       }


   }
    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {StringBuilder s = new StringBuilder();
          return new FileStats(fileName);
    }

    /**
     * Returns a number of occurrences of the particular character.
     *
     * @param character a specific character
     * @return a number that shows how many times this character appeared in a text file
     */
    public int getCharCount(char character) {

        return charCount(readWholeFile(),character); //throw new UnsupportedOperationException("It's your job to make it work!"); //todo
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {

            char result = ' ';
            int maxCount = 0;
            String string = readWholeFile();
            for (char i = 0 ;i<256;i++){
                if (maxCount<charCount(string, i)){
                    maxCount = charCount(string,i);
                    result = i;
                }
            }

            return result;
        }


    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return charCount(readWholeFile(),character)!=0;
    }

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *

     * @return string that holds whole file content
     */
    public String readWholeFile() {

        StringBuilder s = new StringBuilder();
        try {

            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {

                s.append(scanner.nextLine()+"\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return "";
        }
        return s.length()>0?s.toString().substring(0,s.toString().length()-1):"";

    }
    /**
     * Counts number of @param ch (char) in @param String file
     * @param file String
     * @param ch char
     * @return the quantity of chars in that String
     */

    private static int charCount(String file , char ch){

        int count =0;
        char [] c =file.toCharArray();
        for (char temp: c) {
            if (temp==ch&& ch != ' '){
                count++;
            }
        }
        return count;
    }
}
