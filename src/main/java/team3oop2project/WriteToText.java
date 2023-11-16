package team3oop2project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToText {

    private String filePath;

    public WriteToText(String filePath){
        this.filePath = filePath;
    }

    public void write(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
