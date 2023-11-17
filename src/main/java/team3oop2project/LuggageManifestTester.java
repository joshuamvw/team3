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
    public void test02CheckforslipsExistence(){
        Assume.assumeTrue(classExists);

        try {
            // Specify the parameter types in the Class array
            Class<?> classs = LLuggageManifest.class;

            // Get the method by name and parameter types
            Field fieldToFind = classs.getDeclaredField("slips");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPrivate(modifiers)){

                 if(fieldToFind.getType().equals(LLuggageSlip.class)){
                    writer.append("private slips found: Score: +1\n");
                    score = score + 1;}
                 else{
                     writer.append("slips was not of type LLuggageSlip: Score: +0\n");
                 }
            }
            else{
                writer.append("slips was not private: Score: +0\n");
            }
        
        } catch (NoSuchFieldException e) {
            writer.append("slips was not found: Score: +0\n");
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }


}
