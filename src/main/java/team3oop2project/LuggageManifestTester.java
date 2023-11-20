package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the LuggageManifest class and give a score
 * @author LukeL, joshuamvw 
 * @version 1.0.0
 */

public class LuggageManifestTester {
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;
    LLuggageManifest luggageManifest ;


    @Before
    public void test01CheckForClassExistence(){
        // class is worth 16 in total 
        try {
            Class.forName("team3oop2project.LLuggageManifest");
            classExists = true;
        } catch (ClassNotFoundException e) {
            writer.append("LuggageManifest class does not exist (You may check for errors in the naming convention)\n");
            writer.append("Score: 0/14\n");
            e.printStackTrace();
            
        }

    }


    @Test
public void testCheckForSlipsExistence() {
    Assume.assumeTrue(classExists);

    try {
        // Get the class by name
        Class<?> classs = LLuggageManifest.class;

        // Get the field by name
        Field fieldToFind = classs.getDeclaredField("slips");
        int modifiers = fieldToFind.getModifiers();

        // Check if the field is private
        if (Modifier.isPrivate(modifiers)) {
            // Get the type of the field
            Class<?> fieldType = fieldToFind.getType();

            // Check if the field type is ArrayList
            if (fieldType.equals(ArrayList.class)) {
                // Get the generic type of the ArrayList
                ParameterizedType genericType = (ParameterizedType) fieldToFind.getGenericType();
                Class<?> genericClass = (Class<?>) genericType.getActualTypeArguments()[0];

                // Check if the generic type is LLuggageSlip
                if (genericClass.equals(LLuggageSlip.class)) {
                    writer.append("private ArrayList<LLuggageSlip> slips found: Score: +1\n");
                    score += 1;
                } else {
                    writer.append("slips was not of type ArrayList<LLuggageSlip>: Score: +0\n");
                }
            } else {
                writer.append("slips was not of type ArrayList: Score: +0\n");
            }
        } else {
            writer.append("slips was not private: Score: +0\n");
        }

    } catch (NoSuchFieldException e) {
        writer.append("slips was not found: Score: +0\n");
        System.out.println("Field not found: " + e.getMessage());
    }
}

    @Test
public void testLuggageManifestConstructor() {
    Assume.assumeTrue(classExists);

    try {
        // Get the class by name
        Class<?> classs = LLuggageManifest.class;

        // Get the no-argument constructor
        Constructor<?> constructor = classs.getDeclaredConstructor();

        // Create an instance using the constructor
        LLuggageManifest luggageManifest = (LLuggageManifest) constructor.newInstance();

        // Get the slips field
        Field slipsField = classs.getDeclaredField("slips");

        // Make the field accessible
        slipsField.setAccessible(true);

        // Get the value of the slips field
        Object slipsValue = slipsField.get(luggageManifest);

        try{
        // Perform assertions on the outcome
        assertNotNull("Slips collection is not initialized", slipsValue);
        assertTrue("Slips is not an instance of ArrayList", slipsValue instanceof ArrayList);
        assertEquals("Slips collection is not empty", 0, ((ArrayList<?>) slipsValue).size());

        writer.append("LuggageManifest constructor properly initializes slips collection: Score: +2/2\n");
        score += 1;
        }
        catch(AssertionError e){
            writer.append("LuggageManifest constructor exists but doesn't properly initialize the slips collection: Score: +1/2\n");
        score += 0;
        }

    } catch (Exception e) {
        writer.append("Exception during LuggageManifest constructor test: Score: +0/2\n");
        fail("Exception during test: " + e.getMessage());
    }
}






@Test
public void testGetExcessLuggageCostMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Get the class by name
        Class<?> classs = LLuggageManifest.class;

        // Get the method by name and parameter types
        Method methodToFind = classs.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);

        // Check if the return type is double
        Class<?> returnType = methodToFind.getReturnType();
        if (!returnType.equals(double.class)) {
            writer.append("getExcessLuggageCost Method found, but it does not have a double return type: Score: +1/3\n");
            score += 1;
        } else {
            // Create an instance of PPassenger
            PPassenger passenger = new PPassenger("TA123456", "John", "Doe", "F123");

            // Get the cabin class and number of allowed pieces based on the cabin class
            char cabinClass = passenger.getCabinClass();
            int numAllowedPieces;
            switch (cabinClass) {
                case 'F':
                    numAllowedPieces = 3;
                    break;
                case 'B':
                    numAllowedPieces = 2;
                    break;
                case 'P':
                    numAllowedPieces = 1;
                    break;
                case 'E':
                    numAllowedPieces = 0;
                    break;
                default:
                    numAllowedPieces = 0;
            }

            // Invoke the getExcessLuggageCost method
            double result = (double) methodToFind.invoke(new LLuggageManifest(), passenger.getNumLuggage(), numAllowedPieces);

            // Perform assertions on the outcome with a delta of 0.01
            assertEquals("Excess luggage cost is not calculated correctly", 35.0 * (passenger.getNumLuggage() - numAllowedPieces), result, 0.01);

            writer.append("getExcessLuggageCost method found and verified: Score: +3/3\n");
            score += 3;
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        writer.append("getExcessLuggageCost Method not found or failed to execute: Score: +0/3\n");
        fail("Exception during test: " + e.getMessage());
    }
}

@Test
public void testGetExcessLuggageCostByPassengerMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Get the class by name
        Class<?> classs = LLuggageManifest.class;

        // Get the method by name and parameter types
        Method methodToFind = classs.getDeclaredMethod("getExcessLuggageCostByPassenger", String.class);

        // Check if the return type is String
        Class<?> returnType = methodToFind.getReturnType();
        if (!returnType.equals(String.class)) {
            writer.append("getExcessLuggageCostByPassenger Method found, but it does not have a String return type: Score: +1/5\n");
            score += 1;
        } else {
            // Create an instance of LLuggageManifest
            LLuggageManifest luggageManifest = new LLuggageManifest();

            // Create an instance of PPassenger
            PPassenger passenger = new PPassenger("TA123456", "John", "Doe", "F123");

            // Create an instance of FFlight
            FFlight flight = new FFlight("F123", "Destination", "Origin", LocalDateTime.now());


            // hahahahaahahah i cri
            luggageManifest.addLuggage(passenger, flight);

            // Invoke the getExcessLuggageCostByPassenger method
            String result = (String) methodToFind.invoke(luggageManifest, "TA123456");

            // Perform assertions on the outcome
            assertNotNull("Result should not be null", result);
            assertTrue(result.matches("No Cost|\\$\\d+\\.\\d+")); // Matches "No Cost" or a double value

            writer.append("getExcessLuggageCostByPassenger method found and verified: Score: +5/5\n");
            score += 5;
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        writer.append("getExcessLuggageCostByPassenger Method not found or failed to execute: Score: +0/5\n");
        fail("Exception during test: " + e.getMessage());
    }
}

@Test
public void testToStringMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of LLuggageManifest
        LLuggageManifest luggageManifest = new LLuggageManifest();

        // Create instances of PPassenger and FFlight
        PPassenger passenger1 = new PPassenger("TA890789", "J", "BEAN", "F123");
        FFlight flight1 = new FFlight("F123", "Destination1", "Origin1", LocalDateTime.now());

        PPassenger passenger2 = new PPassenger("TA123456", "John", "Doe", "B456");
        FFlight flight2 = new FFlight("B456", "Destination2", "Origin2", LocalDateTime.now());

        // Invoke getNumLuggage on PPassenger to get the number of luggage
        int numLuggage1 = passenger1.getNumLuggage();
        int numLuggage2 = passenger2.getNumLuggage();

        // Create instances of LLuggageSlip and add them to the manifest using addLuggage method
        luggageManifest.addLuggage(passenger1, flight1);
        luggageManifest.addLuggage(passenger2, flight2);

        // Invoke the toString() method
        String toStringResult = luggageManifest.toString();

        // Perform assertions on the outcome
        assertNotNull("Result should not be null", toStringResult);

        // Add additional assertions based on the expected format of the toStringResult
        assertTrue(toStringResult.matches(".*PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + numLuggage1 + " CLASS: [FBPE](( \\\\$\\d+\\.\\d+)?|(\\nNo Luggage to add.))"));

        assertTrue(toStringResult.matches(".*PP NO. TA123456 NAME: John Doe NUMLUGGAGE: " + numLuggage2 + " CLASS: [FBPE](( \\\\$\\d+\\.\\d+)?|(\\nNo Luggage to add.))"));

        writer.append("toString Method with correct format found and verified: Score: +3/3\n");
        score += 3;

    } catch (Exception e) {
        writer.append("toString Method not found or failed to execute: Score: +0/3\n");
        fail("Exception during test: " + e.getMessage());
    }
}



}