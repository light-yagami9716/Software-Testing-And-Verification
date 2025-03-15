/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BusBooking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class SeatTest {

    private Seat seat;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        seat = new Seat();
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        seat.setVisible(false);
        seat = null;
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("After all tests");
    }

    @Test
    public void testConnectNotNull() {
        assertNotNull(seat.con, "Database connection should be established.");
    }

    @Test
    public void testButtonAddAction() {
        seat.txtdate.setDate(new java.util.Date());
        assertDoesNotThrow(() -> {
            seat.jButton1ActionPerformed(null);
        }, "Adding seat should not throw an exception.");
    }


    @Test
    public void testButtonCancelAction() {
        seat.jButton2ActionPerformed(null);
        assertFalse(seat.isVisible(), "Seat frame should be closed after cancel.");
    }

    @Test
    public void testBusComboBox() {
        assertNotNull(seat.txtbus.getSelectedItem(), "Bus number should be selected.");
        assertTrue(seat.txtbus.getItemCount() > 0, "ComboBox should contain bus numbers.");
    }

    @Test
    public void testDateChooser() {
        seat.txtdate.setDate(new java.util.Date());

        assertNotNull(seat.txtdate.getDate(), "Date should be selected.");
    }


    @Test
    public void testInvalidDate() {
        seat.txtdate.setDate(null);
        assertThrows(NullPointerException.class, () -> {
            seat.jButton1ActionPerformed(null);
        }, "Should throw NullPointerException if the date is not selected.");
    }

    @Test
    public void testAddSeatButtonVisibility() {
        assertTrue(seat.jButton1.isVisible(), "Add button should be visible.");
    }
}

