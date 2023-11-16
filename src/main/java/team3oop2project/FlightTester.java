package team3oop2project;

import static org.junit.Assert.assertEquals;
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


public class FlightTester{
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;
    PPassenger passenger ;


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
    public void test04CheckfordestinationExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("destination");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(String.class)){
                    writer.append("private String destination found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("destination was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("destination was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("destination was not found: Score: +0\n");
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
                    writer.append("private String origin found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("origin was not of type String: Score: +0\n");
                }
            }
            else{
                writer.append("origin was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("origin was not found: Score: +0\n");
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
                    writer.append("private LocalDateTime flightDate found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("flightDate was not of type LocalDateTime: Score: +0\n");
                }
            }
            else{
                writer.append("flightDate was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("flightDate was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

    }


    @Test
    public void test04CheckformanifestExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = FFlight.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("manifest");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(LLuggageManifest.class)){
                    writer.append("private LuggageManifest manifest found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("manifest was not of type LuggageManifest: Score: +0\n");
                }
            }
            else{
                writer.append("manifest was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("manifest was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }





}