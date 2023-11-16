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


public class LuggageSlipTester {
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;
    private int score = 0;
    PPassenger passenger ;


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
    public void test04CheckforluggageSlipIDCounterExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = LLuggageSlip.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("luggageSlipIdCounter");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                if(fieldToFind.getType().equals(int.class)){
                    writer.append("private int luggageSlipIdCounter found: Score: +1\n");
                    score = score + 1;}
                else{
                    writer.append("luggageSlipIdCounter was not of type int: Score: +0\n");
                }
            }
            else{
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





}