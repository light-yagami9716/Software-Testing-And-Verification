/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BusBooking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookingTest {

    private Booking booking;

    @BeforeAll
    public void setupDatabaseConnection() {
        booking = new Booking();
        assertNotNull(booking, "Booking object should be initialized");
        booking.Connect(); // Ensure the connection is made
        assertNotNull(booking.con, "Database connection should be established");
        System.out.println("Before all tests");
    }

    @AfterAll
    public void cleanup() {
        booking = null;
        assertNull(booking, "Booking object should be null after cleanup");
        System.out.println("After all tests");
    }

    @BeforeEach
    public void setup() {
        booking = new Booking();
        booking.Connect();
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        booking = null;
        System.out.println("After each test");
    }

    @Test
    public void testConnect_shouldEstablishConnection() {
        assertDoesNotThrow(() -> booking.Connect(), "Connection should be established without exceptions");
        assertNotNull(booking.con, "Database connection should not be null");
    }



    @Test
    public void testCancel_shouldHideWindow() {
        booking.setVisible(true);
        assertTrue(booking.isVisible(), "Window should be visible before cancel");

        assertDoesNotThrow(() -> booking.jButton3ActionPerformed(null), "Cancel action should not throw exceptions");
        assertFalse(booking.isVisible(), "Window should be hidden after cancel");
    }

}

