package team3oop2project;

import java.io.IOException;

/**
 * Hello world!
 *
 */
import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

public class MarkAssignment 
{

    public static void main( String[] args )
    {
        // Enter the name of the assignment that you placed in main to be marked, with the .zip
        String zipFileName = "816012345_A1.zip";
        String zipFilePath = "./src/main/java/team3oop2project/" + zipFileName;
        UnzipFiles unzip = new UnzipFiles(zipFilePath);
        String[] filesUnzipped = unzip.unZipIt();

        // set up writer to catch if their class doesnt exist
        WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
        //Copy these files so that they can run in the package
    
        //Copy Passenger
        ClassCopier copycat = new ClassCopier();

        try {
            copycat.addPackageStatement("./src/main/java/team3oop2project/Passenger.java", "./src/main/java/team3oop2project/PPassenger.java");
            writer.write("Tests for Passenger Class:\n");
        } catch (IOException e) {
            writer.write("Passenger class does not exist (You may check for errors in the naming convention)\n");
            writer.append("Score: 0/16\n");
            System.err.println("Error: " + e.getMessage());
        }

        //Copy Flight
        try {
        copycat.addPackageStatement("./src/main/java/team3oop2project/Flight.java", "./src/main/java/team3oop2project/FFlight.java");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Copy LuggageSlip
        try {
        copycat.addPackageStatement("./src/main/java/team3oop2project/LuggageSlip.java", "./src/main/java/team3oop2project/LLuggageSlip.java");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Copy LuggageManifest
        try {
        copycat.addPackageStatement("./src/main/java/team3oop2project/LuggageManifest.java", "./src/main/java/team3oop2project/LLuggageManifest.java");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Copy LuggageManagementSystem
        try {
        copycat.addPackageStatement("./src/main/java/team3oop2project/LuggageManagementSystem.java", "./src/main/java/team3oop2project/LLuggageManagementSystem.java");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        JUnitCore.runClasses(PassengerTester.class,LuggageSlipTester.class, FlightTester.class);
        //Result result = JUnitCore.runClasses(AppTest.class, PassengerTester.class);
        ZipFiles zip = new ZipFiles(filesUnzipped);
        zip.zipFiles(zipFilePath);
        unzip.deleteUnzippedFiles(filesUnzipped);


        // Wipe the files after
        // try{
        //     copycat.wipeFiles();
        // } catch (IOException e) {
        //     System.err.println("Error: " + e.getMessage());
        // }


    }
}
