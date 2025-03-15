/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BusBooking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusBookTest {

    private BusBook busBook;

    @BeforeAll
    public void setUpBeforeClass() {
        // Runs once before all tests, could be used for DB connection setup or any other global setup
        System.out.println("Before all tests");
    }

    @AfterAll
    public void tearDownAfterClass() {
        // Runs once after all tests, cleanup or DB disconnection logic could go here
        System.out.println("After all tests");
    }

    @BeforeEach
    public void setUp() {
        // Runs before each test, creating a fresh instance of the BusBook class before each test
        busBook = new BusBook();
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        // Runs after each test, can be used for cleanup if necessary
        busBook = null;
        System.out.println("After each test");
    }

    @Test
    public void testBusBookNotNull() {
        // Test to ensure that the BusBook object is not null
        assertNotNull(busBook, "BusBook instance should not be null");
    }

    @Test
    public void testComponentsInitialized() {
        // Check if the buttons are initialized properly
        assertNotNull(busBook.jButton1, "Add Seat button should be initialized");
        assertNotNull(busBook.jButton2, "Book Bus button should be initialized");
    }

    @Test
    public void testMainMethod() {
        // Test to see if the main method runs without throwing exceptions
        assertDoesNotThrow(() -> BusBook.main(new String[]{}), "Main method should run without exceptions");
    }

    @Test
    public void testFailExample() {
        // An example to force a failure in the test
        fail("This test is supposed to fail");
    }
    
    @Test
    public void testButton1Text() {
        // Check the text of the first button
        assertEquals("Add Seat", busBook.jButton1.getText(), "Add Seat button text should be 'Add Seat'");
    }

    @Test
    public void testButton2Text() {
        // Check the text of the second button
        assertEquals("Book Bus", busBook.jButton2.getText(), "Book Bus button text should be 'Book Bus'");
    }

    @Test
    public void testDifferentObjects() {
        // Test that two different objects are not the same
        BusBook anotherBusBook = new BusBook();
        assertNotSame(busBook, anotherBusBook, "Each BusBook instance should be different");
    }
}

