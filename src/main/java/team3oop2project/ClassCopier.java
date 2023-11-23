package team3oop2project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * The purpose of this class is to copy the files from the student assignment into the code. 
 * When the assignment files are extracted, because they were not present at run-time, the tests do not work on them.
 * To facilitate the tests, classes were createdand the contents of the student's assignments were  copied into them, e.g student's Flight copied into our FFlight that was present at run-time 
 * @author joshuamvw
 * @version 1.0.0
 */
public class ClassCopier {

/**
 * The purpose of this method is to copy the files from the student assignment into the code and add on the package tag
 * @param sourceFilePath This is the path to the source file you want to copy the contents of
 * @param destinationFilePath This is the path to the destination file you want to copy the contents to
 * @throws IOException This handles the exception that the source file may not be found
 */
    public void addPackageStatement(String sourceFilePath, String destinationFilePath) throws IOException {
        // Specify the package statement
        /**
         * This attribute holds the value of the package statement to be appended
         */
        String packageStatement = "package team3oop2project;\n\n";

        // Read the content of the source file
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            // Write the package statement to the destination file
            writer.write(packageStatement);

            // Copy the content of the source file to the destination file with replacements
            String line;
            while ((line = reader.readLine()) != null) {
                // Replace "Passenger" with "PPassenger"
                line = line.replaceAll("Passenger", "PPassenger");

                // Replace "Flight" with "FFlight"
                line = line.replaceAll("Flight", "FFlight");

                // Replace "LuggageManagementSystem" with "LLuggageManagementSystem"
                line = line.replaceAll("LuggageManagementSystem", "LLuggageManagementSystem");

                // Replace "LuggageManifest" with "LLuggageManifest"
                line = line.replaceAll("LuggageManifest", "LLuggageManifest");

                // Replace "LuggageSlip" with "LLuggageSlip"
                line = line.replaceAll("LuggageSlip", "LLuggageSlip");

                // Write the modified line to the destination file
                writer.write(line);
                writer.newLine(); // Add newline to maintain original formatting
            }
        }
    }
/**
 * The purpose of this class was to wipe the files that stored the code of student's assignment
 * @deprecated We do not need to wipe the files
 * @throws IOException
 */
    public void wipeFiles() throws IOException {
        String[] fileNames = {"FFlight", "PPassenger", "LLuggageManifest", "LLuggageSlip", "LLuggageManagementSystem"};
        String newPackage = "package team3oop2project;";
        String newClassDeclaration = "{}";

        for (String fileName : fileNames) {
            String filePath = "./src/main/java/team3oop2project/" + fileName + ".java";

            // Write the new package and class declarations
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(newPackage);
                writer.newLine(); // Add newline after package statement
                writer.newLine(); // Add newline before class declaration
                writer.write("public class " + fileName);
                writer.write(newClassDeclaration);
                writer.newLine(); // Add newline after class declaration
            }
        }
    }
}
