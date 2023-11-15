package team3oop2project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFiles {

    // private String nameOfZip;

    // public UnzipFiles(String nameOfZip){
    //     this.nameOfZip = nameOfZip;
    // }
    
    //List fileList;
    private String INPUT_ZIP_FILE;
    private String OUTPUT_FOLDER;


    // public static void main( String[] args )
    // {
    // 	UnzipFiles unZip = new UnzipFiles();
    // 	unZip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);
    // }
    public UnzipFiles(String zipFilePath){
        INPUT_ZIP_FILE = zipFilePath; //"./src/main/java/team3oop2project/" 
        OUTPUT_FOLDER = "./src/main/java/team3oop2project";
    }

    /**
     * Unzip it
     * @param zipFile input zip file
     * @param output zip file output folder
     */
//     public String[] unZipIt(){

//         String zipFile = INPUT_ZIP_FILE;
//         String outputFolder = OUTPUT_FOLDER;
//         String[] filesUnzipped = new String[100];
//         int x=0;

//      byte[] buffer = new byte[1024];
//      try{
//     	//create output directory is not exists
//     	File folder = new File(OUTPUT_FOLDER);
//     	if(!folder.exists()){
//     		folder.mkdir();
//     	}
//     	//get the zip file content
//     	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
//     	//get the zipped file list entry
//     	ZipEntry ze = zis.getNextEntry();
//     	while(ze!=null){
//     	   String fileName = ze.getName();
//            filesUnzipped[x] = fileName;
//            x = x +1;
//            File newFile = new File(outputFolder + File.separator + fileName);
//            System.out.println("file unzip : "+ newFile.getAbsoluteFile());
//             //create all non exists folders
//             //else you will hit FileNotFoundException for compressed folder
//             new File(newFile.getParent()).mkdirs();    
//             FileOutputStream fos = new FileOutputStream(newFile);
//             int len;
//             while ((len = zis.read(buffer)) > 0) {
//        		fos.write(buffer, 0, len);
//             }
//             fos.close();
//             ze = zis.getNextEntry();
//     	}
//         zis.closeEntry();
//     	zis.close();
//     	System.out.println("Done");
//     }catch(IOException ex){
//        ex.printStackTrace();
//     }

//     return filesUnzipped;
//    }

public String[] unZipIt() {
    String zipFile = INPUT_ZIP_FILE;
    String outputFolder = OUTPUT_FOLDER;
    List<String> filesUnzippedList = new ArrayList<>();

    byte[] buffer = new byte[1024];
    try {
        // create output directory if not exists
        File folder = new File(OUTPUT_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }

        // get the zip file content
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));

        // get the zipped file list entry
        ZipEntry ze = zis.getNextEntry();
        while (ze != null) {
            String fileName = ze.getName();
            filesUnzippedList.add(fileName);

            File newFile = new File(outputFolder + File.separator + fileName);
            System.out.println("file unzip: " + newFile.getAbsoluteFile());

            // create all non-exists folders, else, you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();

            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            ze = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
        System.out.println("Done");
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    // Convert the list to an array
    return filesUnzippedList.toArray(new String[0]);
}

   public void deleteUnzippedFiles(String[] filesUnzipped) {
    String outputFolder = OUTPUT_FOLDER;

    File folder = new File(outputFolder);
    File[] listOfFiles = folder.listFiles();

    if (listOfFiles != null) {
        for (File file : listOfFiles) {
            if (file.isFile()) {
                // Check if the file name matches any of the unzipped files
                for (String unzippedFile : filesUnzipped) {
                    if (file.getName().equals(unzippedFile)) {
                        if (file.delete()) {
                            System.out.println("Deleted: " + file.getAbsolutePath());
                        } else {
                            System.out.println("Failed to delete: " + file.getAbsolutePath());
                        }
                        break; // No need to check further
                    }
                }
            }
        }
    }
}


    
}