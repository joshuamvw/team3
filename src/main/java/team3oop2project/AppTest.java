package team3oop2project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
//import P;

import org.junit.Assume;
import org.junit.Before;
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
    private WriteToText writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    private boolean classExists = false;

    // @Before
    // public void test01setUpWriter(){
    //     writer = new WriteToText("./src/main/java/team3oop2project/outputForPDF.txt");
    // }
    
    
    @Before
    public void test02testforClassExistence(){
        // class is worth 3 in total 
        try {
            Class.forName("team3oop2project.poopybuttholes");
            System.out.println("PoopyButtholes class exists.");
            classExists = true;
        } catch (ClassNotFoundException e) {
            System.out.println("PoopyButtholes class does not exist.");
            e.printStackTrace();
            System.out.println("All tests failed");
        }

    }

    @Test
    public void test03testforMethodExistence(){
        Assume.assumeTrue(classExists);

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
    public void test04testforAttributeExistence(){
        Assume.assumeTrue(classExists);

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

