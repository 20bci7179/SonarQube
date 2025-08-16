package org.sample.mavenSample;

// Import the TestCase class from the JUnit 3 framework
import junit.framework.TestCase;

/**
 * Unit test for the App class using JUnit 3.8.1.
 * Test classes must extend junit.framework.TestCase.
 * Test methods must start with 'test'.
 */
public class AppTest extends TestCase {

    // Instance of the App class to be tested
    private App app;

    /**
     * Constructor for AppTest.
     * Required by JUnit 3 to name the test case.
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * This method is called before each test method execution in JUnit 3.
     * Used for setting up the test environment.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp(); // Call the superclass setUp method
        app = new App(); // Initialize the App object
    }

    /**
     * This method is called after each test method execution in JUnit 3.
     * Used for tearing down (cleaning up) the test environment.
     */
    @Override
    protected void tearDown() throws Exception {
        app = null; // Release the App object
        super.tearDown(); // Call the superclass tearDown method
    }

    /**
     * Test case for the 'addition' method.
     * Method name must start with 'test'.
     */
    public void testAddition() {
        // Assert that 2 + 10 equals 12
        assertEquals("Addition of 2 and 10 should be 12", 12, app.addition(2, 10));

        // Test with negative numbers
        assertEquals("Addition of -5 and -3 should be -8", -8, app.addition(-5, -3));

        // Test with positive and negative numbers
        assertEquals("Addition of 7 and -4 should be 3", 3, app.addition(7, -4));
    }

    /**
     * Test case for the 'division' method.
     * REMINDER: The App.division method performs INTEGER division (e.g., 7 / 3 = 2).
     * Method name must start with 'test'.
     */
    public void testDivision() {
        // Assert that 7 / 3 results in 2.0f (due to integer division and float conversion)
        // For float comparisons in JUnit 3, you also need a delta (tolerance)
        assertEquals("Division of 7 by 3 should be 2.0 (integer division)", 2.0f, app.division(7, 3), 0.0001f);

        // Test perfect division
        assertEquals("Division of 10 by 2 should be 5.0", 5.0f, app.division(10, 2), 0.0001f);

        // Test negative numbers division (integer division rules apply)
        assertEquals("Division of -10 by 3 should be -3.0", -3.0f, app.division(-10, 3), 0.0001f);
    }

    // Note: JUnit 3 does not have a simple @Test(expected=...) annotation.
    // To test for exceptions, you would typically use a try-catch block and then fail the test
    // if the expected exception is NOT caught, or pass it if it is.
    // However, since the original 'division' method might not explicitly throw ArithmeticException
    // for integer division by zero until the value is actually used in some contexts,
    // and given the "simple" request, I'm omitting a complex exception test for now.
    // If division by zero is a critical test, you would explicitly throw an exception in your App.division method.
}
