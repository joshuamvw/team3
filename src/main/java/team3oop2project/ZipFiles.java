package team3oop2project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * The purpose of this class is to handle the zipping of the student's assignment files after marking
 * @author joshuamvw
 * @version 1.0.0
 */
public class ZipFiles {

    private String[] filesToZip;

    /**
     * This is the constructor which allows you to specify the files you want to zip
     * @param filesToZip this is an array of the paths to the files you want to zip, the students submission files are put in here to be zipped back up
     */
    public ZipFiles(String[] filesToZip){
        this.filesToZip = filesToZip;
    }
    

    /**
     * This is the method which zips the files to the path
     * @param zipFilePath this is the path to the new zip file
     */
    public void zipFiles(String zipFilePath) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (String fileTZ : filesToZip) {
                String filePath = "./src/main/java/team3oop2project/" + fileTZ;
                File file = new File(filePath);
                if (file.exists() && file.isFile()) {
                    addToZip(file, file.getName(), zipOutputStream);
                } else {
                    System.out.println("File not found: " + filePath);
                }
            }
            System.out.println("Files successfully zipped to: " + zipFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is the method adds a file to zip, for the zip files method
     * @param file This is the file that you would like to add to the zip
     * @param fileName This is the name of the file that you would like to add to the zip
     * @param zipOutputStream This is the stream to output to the zip file that you are creating
     * @throws IOException
     */
    private void addToZip(File file, String fileName, ZipOutputStream zipOutputStream) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }

            zipOutputStream.closeEntry();
        }
    }
}

