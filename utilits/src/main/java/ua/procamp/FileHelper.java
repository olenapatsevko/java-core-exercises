package ua.procamp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {

  private FileHelper(){}

  public static String fileReader (File file ){
    StringBuilder s = new StringBuilder();
    try {

      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {

        s.append(scanner.nextLine()+"\n");
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      return "";
    }
    return s.length()>0?s.toString().substring(0,s.toString().length()-1):"";

  }

}
