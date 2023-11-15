package team3oop2project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClassCopier {


    public void addPackageStatement(String sourceFilePath, String destinationFilePath) throws IOException {
        // Specify the package statement
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
