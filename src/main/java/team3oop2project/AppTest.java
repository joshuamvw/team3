package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
//import P;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    //Testing poopybutthole class example of how all will be done

    
    
    @Test
    public void testforClassExistence(){
        // class is worth 3 in total 
        try {
            Class.forName("team3oop2project.poopybuttholes");
            System.out.println("PoopyButtholes class exists.");
        } catch (ClassNotFoundException e) {
            System.out.println("PoopyButtholes class does not exist.");
            e.printStackTrace();
        }
    }

    @Test
    public void testforMethodExistence(){
        try {
            // Specify the parameter types in the Class array
            Class<?>[] parameterTypes = { int.class, int.class };

            // Get the method by name and parameter types
            Method methodToFind = poopybuttholes.class.getMethod("addUS", parameterTypes);

            // Now you have a reference to the method
            System.out.println("Found method: " + methodToFind);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + e.getMessage());
        }

        
    }


    @Test
    public void testforAttributeExistence(){
        try {
            // Specify the parameter types in the Class array
            Class<?> rizzard = poopybuttholes.class;

            // Get the method by name and parameter types
            Field fieldToFind = rizzard.getDeclaredField("poop");
            int modifiers = fieldToFind.getModifiers();

            if(Modifier.isPublic(modifiers)){
                System.out.println("poop is public");
            }
        
        } catch (NoSuchFieldException e) {
            System.out.println("Field not found: " + e.getMessage());
        }

        
    }
}

