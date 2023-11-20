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
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the Flight class and give a score
 * @author joshuamvw, LukeL
 * @version 1.0.0
 */
public class FlightTester{
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;
    FFlight flight ;

/**
 * The purpose of 
 */
    @Before
    public void test01CheckForClassExistence(){
        // class is worth 16 in total 
        try {
            Class.forName("team3oop2project.FFlight");
            classExists = true;
        } catch (ClassNotFoundException e) {
            writer.append("Flight class does not exist (You may check for errors in the naming convention)\n");
            writer.append("Score: 0/14\n");
            e.printStackTrace();
            
        }

    }


     @Test
    public void test02CheckforflightNoExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("flightNo");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                 if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String flightNo found: Score: +1/1\n");
                    score = score + 1;}
                 else{
                     writer.append("flightNo was not of type String: Score: +0/1\n");
                 }
            }
            else{
                writer.append("flightNo was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("flightNo was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


    @Test
    public void test03CheckfordestinationExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("destination");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String destination found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("destination was not of type String: Score: +0/1\n");
                }
            }
            else{
                writer.append("destination was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("destination was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


     @Test
    public void test04CheckfororiginExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("origin");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String origin found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("origin was not of type String: Score: +0/1\n");
                }
            }
            else{
                writer.append("origin was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("origin was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


     @Test
    public void test05CheckforflightDateExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("flightDate");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(LocalDateTime.class)){
                    writer.append("private LocalDateTime flightDate found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("flightDate was not of type LocalDateTime: Score: +0/1\n");
                }
            }
            else{
                writer.append("flightDate was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("flightDate was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

    }


    @Test
    public void test06CheckformanifestExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("manifest");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(LLuggageManifest.class)){
                    writer.append("private LuggageManifest manifest found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("manifest was not of type LuggageManifest: Score: +0/1\n");
                }
            }
            else{
                writer.append("manifest was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("manifest was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }

    @Test
    public void test07CheckForOverloadedConstructorFFlight() {
        try {
            // Get the overloaded constructor for FFlight
            Constructor<FFlight> constructor = FFlight.class.getConstructor(String.class, String.class, String.class, LocalDateTime.class);

            try {
                // Create an instance using the overloaded constructor
                LocalDateTime flightDate = LocalDateTime.now(); // Replace with an appropriate LocalDateTime
                FFlight flight = constructor.newInstance("A", "B", "C", flightDate);

                // Perform assertions on the created instance
                assertEquals("A", flight.getFFlightNo());
                assertEquals("B", flight.getDestination());
                assertEquals("C", flight.getOrigin());
                assertEquals(flightDate, flight.getFFlightDate());

                // Assert that a LuggageManifest was created
                assertNotNull(flight.getManifest());
                
                // Add additional assertions if needed for the LuggageManifest or other properties

                writer.append("Overloaded constructor FFlight was created properly: Score: +2/2\n");
                score += 5;
            } catch (AssertionError e) {
                writer.append("Overloaded constructor FFlight was created but states not set properly: Score: +1/2\n");
                score += 1;
            }
        } catch (Exception e) {
            writer.append("Overloaded constructor FFlight was not created: Score: +0/2\n");
            fail("Exception during test: " + e.getMessage());
        }
    }

    @Test
    public void testCheckInLuggageMethod() {
        Assume.assumeTrue(classExists);
    
        try {
            // Get the checkInLuggage method by name and parameter type
            Method checkInLuggageMethod = FFlight.class.getDeclaredMethod("checkInLuggage", PPassenger.class);
    
            // Check if the return type is String
            Class<?> returnType = checkInLuggageMethod.getReturnType();
            if (!returnType.equals(String.class)) {
                writer.append("checkInLuggage Method found, but it does not have a String return type: Score: +1/5\n");
                // Stop the test if the return type is not as expected
            } else {
                // Create an instance of FFlight
                LocalDateTime flightDate = LocalDateTime.now(); // Replace with an appropriate LocalDateTime
                FFlight flight = new FFlight("F123", "Destination", "Origin", flightDate);
    
                // Create a Passenger with the same flight number as the FFlight
                PPassenger passenger = new PPassenger("TA123456", "John", "Doe", "F123");
    
                // Invoke the checkInLuggage method
                Object result = checkInLuggageMethod.invoke(flight, passenger);
    
                // Perform assertions on the outcome
                if (result instanceof String) {
                    String outcome = (String) result;
    
                    if (outcome.equals("Invalid flight")) {
                        writer.append("CheckInLuggage method of String return type found, but does not correctly test if the Passenger's flight number matches the Flight: Score: +2/5\n");
                        score += 0;
                    } else {
                        writer.append("CheckInLuggage method of String return type found and verified: Score: +5/5\n");
                        score += 5;
                        // You can add more assertions based on the expected behavior of checkInLuggage
                    }
                } else {
                    writer.append("checkInLuggage did not return a String: Score: +1/5\n");
                    score += 1;
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            writer.append("checkInLuggage Method not found or failed to execute: Score: +0/5\n");
            fail("Exception during test: " + e.getMessage());
        }
    }
//IDK HOW TO FIX THIS ONE.....
    @Test
    public void testPrintLuggageManifestMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Get the printLuggageManifest method by name
        Method printLuggageManifestMethod = FFlight.class.getDeclaredMethod("printLLuggageManifest");

        // Check if the return type is String
        Class<?> returnType = printLuggageManifestMethod.getReturnType();
        if (!returnType.equals(String.class)) {
            writer.append("printLuggageManifest Method found, but it does not have a String return type: Score: +0/1\n");
            // Stop the test if the return type is not as expected
        } else {
            // Create an instance of FFlight
            LocalDateTime flightDate = LocalDateTime.now(); // Replace with an appropriate LocalDateTime
            FFlight flight = new FFlight("BW600", "Destination", "Origin", flightDate);

            // Add some passengers to the flight
            PPassenger bean1 = new PPassenger("TA890789", "John", "BEAN", "BW600");
            PPassenger bean2 = new PPassenger("TA890789", "Jane", "BEAN", "BW600");
            PPassenger deer3 = new PPassenger("BA321963", "Lain", "DEER", "BW600");
            PPassenger deer4 = new PPassenger("BA321963", "Liam", "DEER", "BW600");

            // Check in luggage for passengers
            flight.checkInLuggage(bean1);
            flight.checkInLuggage(bean2);
            flight.checkInLuggage(deer3);
            flight.checkInLuggage(deer4);

            // Invoke the printLuggageManifest method
            Object result = printLuggageManifestMethod.invoke(flight);

            // Perform assertions on the outcome
            if (result instanceof String) {
                String manifestOutput = (String) result;

                // Add additional assertions based on the expected format of the manifestOutput
                assertTrue(manifestOutput.contains("LUGGAGE MANIFEST:"));
                assertTrue(manifestOutput.matches(".*BW600_BEAN_1 PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: [0-3] CLASS: [FBPE]( \\$\\d+)?"));
                assertTrue(manifestOutput.matches(".*BW600_BEAN_2 PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: [0-3] CLASS: [FBPE]( \\$\\d+)?"));
                assertTrue(manifestOutput.matches(".*BW600_DEER_3 PP NO. BA321963 NAME: L.DEER NUMLUGGAGE: [0-3] CLASS: [FBPE]( \\$\\d+)?"));

                // Assert that the money part is optional
                assertTrue(manifestOutput.matches(".*BW600_DEER_4 PP NO. BA321963 NAME: L.DEER NUMLUGGAGE: [0-3] CLASS: [FBPE]( \\$\\d+)?"));

                writer.append("printLuggageManifest method of String return type found and verified: Score: +1/1\n");
                score += 1;
            } else {
                writer.append("printLuggageManifest did not return a String: Score: +0/1\n");
                score += 0;
            }
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        writer.append("printLuggageManifest Method not found or failed to execute: Score: +0/1\n");
        fail("Exception during test: " + e.getMessage());
    }
}



@Test
public void testGetAllowedLuggageMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Get the getAllowedLuggage method by name and parameter type
        Method getAllowedLuggageMethod = FFlight.class.getDeclaredMethod("getAllowedLuggage", char.class);

        // Check if the return type is int
        Class<?> returnType = getAllowedLuggageMethod.getReturnType();
        if (!returnType.equals(int.class)) {
            writer.append("getAllowedLuggage Method found, but it does not have an int return type: Score: +0/2\n");
            // Stop the test if the return type is not as expected
        } else {
            // Create an instance of FFlight
            LocalDateTime flightDate = LocalDateTime.now(); // Replace with an appropriate LocalDateTime
            FFlight flight = new FFlight("BW600", "Destination", "Origin", flightDate);

            // Invoke the getAllowedLuggage method for each cabin class
            int allowedLuggageF = (int) getAllowedLuggageMethod.invoke(flight, 'F');
            int allowedLuggageB = (int) getAllowedLuggageMethod.invoke(flight, 'B');
            int allowedLuggageP = (int) getAllowedLuggageMethod.invoke(flight, 'P');
            int allowedLuggageE = (int) getAllowedLuggageMethod.invoke(flight, 'E');

            try{// Perform assertions on the outcomes
            assertEquals(3, allowedLuggageF);
            assertEquals(2, allowedLuggageB);
            assertEquals(1, allowedLuggageP);
            assertEquals(0, allowedLuggageE);

            writer.append("getAllowedLuggage method of int return type found and verified: Score: +2/2\n");
            score += 2;
            }catch(AssertionError e){
                writer.append("getAllowedLuggage method of int return type found but doesnt return correct values: Score: +1/2\n");
            score += 2;
            }
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        writer.append("getAllowedLuggage Method not found or failed to execute: Score: +0/2\n");
        fail("Exception during test: " + e.getMessage());
    }
}

//Doestn work
@Test
public void testToStringMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of FFlight
        LocalDateTime flightDate = LocalDateTime.now(); // Replace with an appropriate LocalDateTime
        FFlight flight = new FFlight("BW600", "Destination", "Origin", flightDate);

        // Get the toString() method by name
        Method toStringMethod = FFlight.class.getDeclaredMethod("toString");

        // Check if the return type is String
        Class<?> returnType = toStringMethod.getReturnType();
        if (!returnType.equals(String.class)) {
            fail("toString Method found, but it does not have a String return type.");
            // Stop the test if the return type is not as expected
        } else {
            // Invoke the method and get the result
            String toStringResult = (String) toStringMethod.invoke(flight);

            // Check if the result contains the expected flight number, origin, and destination
            assertTrue(toStringResult.contains("FLIGHT: BW600"));
            assertTrue(toStringResult.contains("DESTINATION: Destination"));
            assertTrue(toStringResult.contains("ORIGIN: Origin"));

            // You can add more specific checks as needed

            writer.append("toString Method with correct format found and verified: Score: +1\n");
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        fail("toString Method not found or failed to execute: " + e.getMessage());
    }
}

}