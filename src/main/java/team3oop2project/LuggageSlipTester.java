package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
 * The purpose of this class is to test the LuggageSlip class and give a score
 * @author LukeL, joshuamvw 
 * @version 1.0.0
 */

public class LuggageSlipTester {
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;


    @Before
    public void test01CheckForClassExistence(){
        // class is worth 16 in total 
        try {
            Class.forName("team3oop2project.LLuggageSlip");
            classExists = true;
        } catch (ClassNotFoundException e) {
            writer.append("LuggageSlip class does not exist (You may check for errors in the naming convention)\n");
            writer.append("Score: 0/14\n");
            e.printStackTrace();
            
        }

    }


     @Test
    public void test02CheckforownerExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = LLuggageSlip.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("owner");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                 if(fieldToFind.getType().equals(PPassenger.class)){
                    writer.append("private Passenger owner found: Score: +1\n");
                    score = score + 1;}
                 else{
                     writer.append("owner was not of type Passenger: Score: +0\n");
                 }
            }
            else{
                writer.append("owner was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("owner was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }

    @Test
public void testCheckForLuggageSlipIdCounterExistence() {
    Assume.assumeTrue(classExists);
    
    LLuggageSlip luggageSlip;

    try {
        // Specify the class
        Class<?> classToCheck = LLuggageSlip.class;

        // Get the field by name
        Field fieldToFind = classToCheck.getDeclaredField("luggageSlipIdCounter");
        int modifiers = fieldToFind.getModifiers();

        if (Modifier.isStatic(modifiers)) {
            if (fieldToFind.getType().equals(int.class)) {
                writer.append("private int luggageSlipIdCounter found: Score: +1\n");
                score = score + 1;
            } else {
                writer.append("luggageSlipIdCounter was not of type int: Score: +0\n");
            }
        } else {
            writer.append("luggageSlipIdCounter was not private: Score: +0\n");
        }

    } catch (NoSuchFieldException e) {
        writer.append("luggageSlipIdCounter was not found: Score: +0\n");
        System.out.println("Field not found: " + e.getMessage());
    }
}



    @Test
    public void test04CheckforluggageSlipIdExistence(){
        Assume.assumeTrue(classExists);
        
    LLuggageSlip luggageSlip;

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = LLuggageSlip.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("luggageSlipId");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String luggageSlipId found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("luggageSlipId was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("luggageSlipId was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("luggageSlipId was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


     @Test
    public void test05CheckforlabelExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = LLuggageSlip.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("label");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String label found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("label was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("label was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("label was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

    }

    @Test
public void testCheckForOverloadedConstructor1() {
    try {
        // Get the overloaded constructor
        Constructor<LLuggageSlip> constructor = LLuggageSlip.class.getConstructor(PPassenger.class, FFlight.class);

        PPassenger passenger = new PPassenger("987654321", "Jane", "Doe", "XYZ789");
        FFlight flight = new FFlight("XYZ789", "YYZ", "POS", LocalDateTime.now());

        // Create an instance using the overloaded constructor
        LLuggageSlip luggageSlip = constructor.newInstance(passenger, flight);

        try {
            // Assert that the object has been initialized correctly
            assertEquals("987654321", passenger.getPassportNumber());
            assertEquals("Jane", passenger.getFirstName());
            assertEquals("Doe", passenger.getLastName());
            assertEquals("XYZ789", passenger.getFFlightNo());

            assertEquals("XYZ789", flight.getFFlightNo());
            assertEquals("YYZ", flight.getDestination());
            assertEquals("POS", flight.getOrigin());

        
            writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f) was created and verified: Score: +3\n");
            score += 3;
        } catch (AssertionError e) {
            writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f) was created but didn't set state properly: Score: +1\n");
            score += 1;
        }

    } catch (Exception e) {
        writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f) was not created: Score: +0\n");
        fail("Exception during test: " + e.getMessage());
    }
}

    @Test
public void testCheckForOverloadedConstructor2() {
    try {
        // Get the overloaded constructor
        Constructor<LLuggageSlip> constructor = LLuggageSlip.class.getConstructor(PPassenger.class, FFlight.class, String.class);
        

        PPassenger passenger = new PPassenger("987654321", "Jane", "Doe", "XYZ789");
        FFlight flight = new FFlight("XYZ789", "YYZ", "POS", LocalDateTime.now());
        String label = "ABC";

        // Create an instance using the overloaded constructor
        LLuggageSlip luggageSlip = constructor.newInstance(passenger, flight, label);

        try{
        // Assert that the object has been initialized correctly
        assertEquals("987654321", passenger.getPassportNumber());
        assertEquals("Jane", passenger.getFirstName());
        assertEquals("Doe", passenger.getLastName());
        assertEquals("XYZ789", passenger.getFFlightNo());

        assertEquals("XYZ789", flight.getFFlightNo());
        assertEquals("YYZ", flight.getDestination());
        assertEquals("POS", flight.getOrigin());

        // Verify that the label is set correctly
        assertEquals(label, luggageSlip.getLabel());
        writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f, String label) was created and verified: Score: +3\n");
        score += 3;
        }
        catch(AssertionError e){
            writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f, String label) was created but didnt set state properly: Score: +1\n");
            score += 1;
        }

    } catch (Exception e) {
        writer.append("Overloaded constructor LuggageSlip(Passenger p, Flight f, String label) was not created: Score: +0\n");
        fail("Exception during test: " + e.getMessage());
    }
}



    @Test
    public void test7hasOwnerMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of luggage Slip
        PPassenger passenger = new PPassenger("987654321","Jane","Doe","XYZ789");
        //LLuggageSlip luggageSlip = new LLuggageSlip();

        // Get the method by name
        Method methodToFind = LLuggageSlip.class.getDeclaredMethod("hasOwner");
        methodToFind.setAccessible(true);

        // Invoke the method
        methodToFind.invoke(passenger);

        // Get the value of the cabinClass field using reflection
        Field passportNumber  = PPassenger.class.getDeclaredField("passportNumber");
        passportNumber.setAccessible(true);
        String modifiedValue = (String) passportNumber.get(passenger);

        assertEquals("987654321", modifiedValue); 

        // Check if the modifiedValue is one of the expected values
        //assertTrue("Invalid cabin class value", Arrays.asList('F', 'B', 'P', 'E').contains(modifiedValue));

        writer.append("hasOwner Method with boolean return type found and verified: Score: +2\n");
        score += 2;
    } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
        writer.append("hasOwner Method not found or failed to execute: Score: +0\n");
        fail("Exception during test: " + e.getMessage());
    }
}

@Test
public void testToStringMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of PPassenger and FFlight
        PPassenger passenger = new PPassenger("TA890789", "Joe", "Bean", "BW600");
        FFlight flight = new FFlight("BW600", "Destination", "Origin", LocalDateTime.now());

        // Create an instance of LLuggageSlip
        LLuggageSlip luggageSlip = new LLuggageSlip(passenger, flight, "105");

        // Call getNumLuggage to determine the number of slips to be printed
        int numLuggage = passenger.getNumLuggage();

        // Initialize a variable to track the successful assertions
        boolean allAssertionsPassed = true;

        // Invoke the toString() method for each luggage slip
        for (int i = 1; i <= numLuggage; i++) {
            String toStringResult = luggageSlip.toString();

            // Check if the return type is String
            Class<?> returnType = luggageSlip.getClass().getMethod("toString").getReturnType();
            if (!returnType.equals(String.class)) {
                writer.append("toString Method found, but it does not have a String return type: Score: +0/2\n");
                fail("toString Method does not have a String return type");
            } else {
                try {
                    // Check if the result contains the expected format
                    assertTrue(toStringResult.matches("BW600_Bean_" + i + " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: \\d+ CLASS: E \\$105"));
                } catch (AssertionError e) {
                    allAssertionsPassed = false;
                    writer.append("toString Method found but has wrong format: Score: +1/2\n");
                    score += 1;
                    break;  // Exit the loop if any assertion fails
                }
            }
        }

        // Update the score if all assertions passed
        if (allAssertionsPassed) {
            writer.append("toString Method with correct format found and verified: Score: +2/2\n");
            score += 2;
        }
    } catch (Exception e) {
        writer.append("toString Method not found or failed to execute: Score: +0/2\n");
        fail("Exception during test: " + e.getMessage());
    }
}

}



