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

import org.junit.Assume;
import org.junit.Before;
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
                    writer.append("private String passportNumber found: Score: +1\n");
                    score = score + 1;
                }
                else{
                    writer.append("passportNumber was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("passportNumber was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("passportNumber was not found: Score: +0\n");
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
                    writer.append("private String flightNo found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("flightNo was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("flightNo was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("flightNo was not found: Score: +0\n");
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
                    writer.append("private String fisrtName found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("firstName was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("firstName was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("firstName was not found: Score: +0\n");
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
                    writer.append("private String lastName found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("lastName was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("lastName was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("lastName was not found: Score: +0\n");
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
                    writer.append("private int numLuggage found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("numLuggage was not of type int: Score: +0\n");
                }
            }
            else{
                writer.append("numLuggage was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("numLuggage was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
    @Test
    public void test07CheckforflightNoExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = PPassenger.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("cabinClass");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(char.class)){
                    writer.append("private char cabinClass found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("cabinClass was not of type char: Score: +0\n");
                }
            }
            else{
                writer.append("cabinClass was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("cabinClass was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


    @Test
    public void test08CheckforOverloadedConstructor() {
        try {
            // Get the overloaded constructor
            Constructor<PPassenger> constructor = PPassenger.class.getConstructor(String.class, String.class, String.class, String.class);
            writer.append("Overloaded constructor was created: Score: +2\n");
            score = score+2;

            // // Create an instance using the overloaded constructor
            // PPassenger passenger = constructor.newInstance("John", 25);

            // // Assert that the object has been initialized correctly
            // assertEquals("John", passenger.getPassportNumber());
            // assertEquals(25, passenger.getFirstName());
            // assertEquals("John", passenger.getLastName());
            // assertEquals(25, passenger.getFFlightNo());

        } catch (Exception e) {
            writer.append("Overloaded constructor was not created: Score: +0\n");
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
public void test10checkForToStringMethod() {
    Assume.assumeTrue(classExists);

    try {
        // Create an instance of PPassenger
        PPassenger passenger = new PPassenger("TA890789", "Joe", "Bean", "3");

        // Get the toString() method by name
        Method toStringMethod = PPassenger.class.getDeclaredMethod("toString");

        // Check if the return type is String
        Class<?> returnType = toStringMethod.getReturnType();
        if (!returnType.equals(String.class)) {
            writer.append("toString Method found, but it does not have a String return type: Score: +0\n");
          // Stop the test if the return type is not as expected
        }
        else{

        // Invoke the method and get the result
        String toStringResult = (String) toStringMethod.invoke(passenger);

        // Check if the result contains the expected format
        assertTrue(toStringResult.matches("PP NO. TA890789 NAME: Joe.Bean NUMLUGGAGE: 3 CLASS: E"));

        writer.append("toString Method with correct format found and verified: Score: +3\n");
        score += 3;
        System.out.println("123");
        }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        writer.append("toString Method not found or failed to execute: Score: +0\n");
        fail("Exception during test: " + e.getMessage());
    }
}
    

}
