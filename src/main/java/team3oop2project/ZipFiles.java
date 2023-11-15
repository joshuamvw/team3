package team3oop2project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {

    private String[] filesToZip;

    public ZipFiles(String[] filesToZip){
        this.filesToZip = filesToZip;
    }
    

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

