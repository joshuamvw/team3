package team3oop2project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The purpose of this class is to write to a text file in different ways. The reason this was created, is becuase of the way JUnit test files must be run. Writing directly to pdf would reset the pdf each time.
 * This class allows you to choose two methods, writing or appending. The text file can then be converted to PDF
 * @author joshuamvw
 * @version 1.0.0
 */
public class WriteToText {

    private String filePath;

    /**
     * This is the constructor allowing you to set the file path to write to
     * @param filePath the file path is the path to the text file, to which you want to write to
     */
    public WriteToText(String filePath){
        this.filePath = filePath;
    }

    /**
     * The write method resets the text document so this can be used when a new submission is marked
     * @param content this is the text the enter into the file
     */
    public void write(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The append method does not reset the text document, but instead appends to it, so this can be after to write scores and feedback within the marking of a submission
     * @param content this is the text the enter into the file
     */
    public void append(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
