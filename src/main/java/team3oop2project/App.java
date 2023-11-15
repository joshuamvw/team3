package team3oop2project;

/**
 * Hello world!
 *
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class App 
{

    public static void main( String[] args )
    {

        Result result = JUnitCore.runClasses(AppTest.class);

        // Check the test result
        if (result.wasSuccessful()) {
            System.out.println("All tests passed successfully.");
        } else {
            System.out.println("Test failures:");

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }



    }
}
