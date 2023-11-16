package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PassengerTester {
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;
    PPassenger passenger ;


    @Before
    public void test01CheckForClassExistence(){
        // class is worth 16 in total 
        try {
            Class.forName("team3oop2project.PPassenger");
            classExists = true;
        } catch (ClassNotFoundException e) {
            writer.write("Passenger class does not exist (You may check for errors in the naming convention)\n");
            writer.append("Score: 0/16\n");
            e.printStackTrace();
            
        }

    }


    @Test
    public void test02CheckforpassportNumberExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("passportNumber");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String passportNumber found: Score: +1/1\n");
                    score = score + 1;
                }
                else{
                    writer.append("passportNumber was not of type String: Score: +0/1\n");
                }
            }
            else{
                writer.append("passportNumber was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("passportNumber was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }

    @Test
    public void test03CheckforflightNoExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

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
    public void test04CheckforfirstNameExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("firstName");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String fisrtName found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("firstName was not of type String: Score: +0/1\n");
                }
            }
            else{
                writer.append("firstName was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("firstName was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
    @Test
    public void test05CheckforlastNameExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("lastName");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String lastName found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("lastName was not of type String: Score: +0/1\n");
                }
            }
            else{
                writer.append("lastName was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("lastName was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
    @Test
    public void test06CheckfornumLuggageExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("numLuggage");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(int.class)){
                    writer.append("private int numLuggage found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("numLuggage was not of type int: Score: +0/1\n");
                }
            }
            else{
                writer.append("numLuggage was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("numLuggage was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
    @Test
    public void test07CheckforcabinClassExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("cabinClass");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(char.class)){
                    writer.append("private char cabinClass found: Score: +1/1\n");
                    score = score + 1;}
                else{
                    writer.append("cabinClass was not of type char: Score: +0/1\n");
                }
            }
            else{
                writer.append("cabinClass was not private: Score: +0/1\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("cabinClass was not found: Score: +0/1\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


    @Test
    public void test08CheckforOverloadedConstructor() {
        try {
            // Get the overloaded constructor
            Constructor<PPassenger> constructor = PPassenger.class.getConstructor(String.class, String.class, String.class, String.class);
            

            try{
                // // Create an instance using the overloaded constructor
                PPassenger passenger = constructor.newInstance("A", "B", "C","D");
                assertEquals("A", passenger.getPassportNumber());
                assertEquals("B", passenger.getFirstName());
                assertEquals("C", passenger.getLastName());
                assertEquals("D", passenger.getFFlightNo());


                try{

                    Method getNumLuggageMethod = PPassenger.class.getDeclaredMethod("getNumLuggage");
                    int numLuggage = (int) getNumLuggageMethod.invoke(passenger);
                    Method getCabinClassMethod = PPassenger.class.getDeclaredMethod("getCabinClass");
                    char cabinClass = (char) getCabinClassMethod.invoke(passenger);
                    assertTrue(String.format("numLuggage should be in the range 0 to 3: %d", numLuggage), numLuggage >= 0 && numLuggage <= 3);
                    assertTrue(String.format("cabinClass should be one of F, B, P, E: %c", cabinClass), "FBPE".indexOf(cabinClass) != -1);
                    writer.append("Overloaded constructor Passenger was created properly: Score: +5/5\n");
                score = score+5;
                }
                catch(AssertionError e){
                    writer.append("Overloaded constructor Passenger was created properly but numLuggage and cabinClass werent set properly: Score: +2/5\n");
                score = score+2;
                }
                

                
            }catch(AssertionError e){
                writer.append("Overloaded constructor Passenger was created but states not set properly: Score: +1/5\n");
                score = score+1;
            }

            
        } catch (Exception e) {
            writer.append("Overloaded constructor Passenger was not created: Score: +0/5\n");
            fail("Exception during test: " + e.getMessage());
        }
    }

    @Test
    public void test9CheckForAssignRandomCabinClassMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of PPassenger
        PPassenger passenger = new PPassenger(null, null, null, null);

        // Get the method by name
        Method methodToFind = PPassenger.class.getDeclaredMethod("assignRandomCabinClass");
        methodToFind.setAccessible(true);

        // Invoke the method
        methodToFind.invoke(passenger);

        // Get the value of the cabinClass field using reflection
        Field cabinClassField = PPassenger.class.getDeclaredField("cabinClass");
        cabinClassField.setAccessible(true);
        char modifiedValue = (char) cabinClassField.get(passenger);

        // Check if the modifiedValue is one of the expected values
        assertTrue("Invalid cabin class value", Arrays.asList('F', 'B', 'P', 'E').contains(modifiedValue));

        writer.append("assignRandomCabinClass Method with void return type found and verified: Score: +2\n");
        score += 2;
    } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
        writer.append("assignRandomCabinClass Method not found or failed to execute: Score: +0\n");
        fail("Exception during test: " + e.getMessage());
    }
}


@Test
public void testToStringMethodFormat() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of PPassenger
        PPassenger passenger = new PPassenger("TA890789", "Joe", "Bean", "3");

        // Get the toString() method by name
        Method toStringMethod = PPassenger.class.getDeclaredMethod("toString");

        // Check if the return type is String
        Class<?> returnType = toStringMethod.getReturnType();
        if (!returnType.equals(String.class)) {
            System.out.println("toString Method found, but it does not have a String return type.");
            // Stop the test if the return type is not as expected
        } else {
            // Invoke the method and get the result
            String toStringResult = (String) toStringMethod.invoke(passenger);
            System.out.println(toStringResult);

            // Check if the result contains the expected format
            //assertEquals("PP NO. TA890789 NAME: Joe.Bean NUMLUGGAGE: \\d+ CLASS: E", toStringResult);
            try{
                assertTrue(toStringResult.matches("PP NO\\. TA890789 NAME: J\\.Bean NUMLUGGAGE: [0-3] CLASS: [A-Z]"));
                writer.append("toString Method with String return type found and verified: Score: +3\n");
                score += 3;
            }catch(AssertionError e){
                writer.append("toString Method with String return type found but format doesnt match: Score: +2\n");
                score += 2;
            }
            
            

            System.out.println("toString Method format is correct.");
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        System.out.println("toString Method not found or failed to execute: " + e.getMessage());
        fail("Exception during test: " + e.getMessage());
    }
}
    

}
