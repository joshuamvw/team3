package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    //Testing poopybutthole class example of how all will be done
    @Test
    public void testforClassExistence(){
        // class is worth 3 in total 
        try {
            Class.forName("team3oop2project.poopybuttholes");
            System.out.println("PoopyButtholes class exists.");
        } catch (ClassNotFoundException e) {
            System.out.println("PoopyButtholes class does not exist.");
            e.printStackTrace();
        }
    }

    @Test
    public void testforMethodExistence(){
        try {
            // Specify the parameter types in the Class array
            Class<?>[] parameterTypes = { int.class, int.class };

            // Get the method by name and parameter types
            Method methodToFind = poopybuttholes.class.getMethod("addUS", parameterTypes);

            // Now you have a reference to the method
            System.out.println("Found method: " + methodToFind);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + e.getMessage());
        }

        
    }

    @Test
    public void testforAttributeExistence(){
        try {
            // Specify the parameter types in the Class array
            Class<?> rizzard = poopybuttholes.class;

            // Get the method by name and parameter types
            Field fieldToFind = rizzard.getDeclaredField("poop");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPublic(modifiers)){
                System.out.println("poop is public");
            }
        
        } catch (NoSuchFieldException e) {
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
}
/*
import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class UnzipAndReadClasses {
    public static void main(String[] args) {
        // Specify the path to the zipped file
        String zipFilePath = "path/to/your/file.zip";

        // Specify the directory where you want to extract the files
        String extractDir = "path/to/extract";

        try {
            // Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(extractDir));

            // Open the zip file
            try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
                // Read each entry in the zip file
                ZipEntry entry;
                while ((entry = zipInputStream.getNextEntry()) != null) {
                    // Construct the output file path
                    String outputPath = Paths.get(extractDir, entry.getName()).toString();

                    // Create directories if it is a directory entry
                    if (entry.isDirectory()) {
                        Files.createDirectories(Paths.get(outputPath));
                    } else {
                        // Write the file content
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath))) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                                bos.write(buffer, 0, bytesRead);
                            }
                        }
                    }

                    // If the entry is a .class file, you can read it or perform other actions
                    if (entry.getName().endsWith(".class")) {
                        readClassFile(outputPath);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readClassFile(String filePath) {
        // Implement your logic to read or process the .class file
        System.out.println("Reading class file: " + filePath);
        // Add your logic here
    }
}
*/
