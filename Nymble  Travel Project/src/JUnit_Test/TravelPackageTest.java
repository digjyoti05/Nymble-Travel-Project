package JUnit_Test;

import TravelActivity.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Test Destination");
        travelPackage.addDestination(destination);
        assertFalse(travelPackage.getItinerary().isEmpty());
        assertEquals(destination, travelPackage.getItinerary().get(0));
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger passenger1 = new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Digjyoti Nayak", 456, PassengerType.PREMIUM);
        assertTrue(travelPackage.addPassenger(passenger1));
        assertTrue(travelPackage.addPassenger(passenger2));
        assertFalse(travelPackage.addPassenger(new Passenger("Test", 789, PassengerType.STANDARD))); // Capacity full, should return false
    }

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination1 = new Destination("Destination 1");
        destination1.addActivity(new Activity("Activity 1", "Description 1", 50.0, 20));
        Destination destination2 = new Destination("Destination 2");
        destination2.addActivity(new Activity("Activity 2", "Description 2", 100.0, 10));
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        travelPackage.printItinerary();
    }

    @Test
    public void testPrintPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        travelPackage.addPassenger(new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD));
        travelPackage.addPassenger(new Passenger("Digjyoti Nayak", 456, PassengerType.GOLD));
        travelPackage.printPassengerList();
    }

    @Test
    public void testPrintPassengerDetails() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger = new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD);
        Activity activity = new Activity("Activity 1", "Description 1", 50.0, 10);
        passenger.signUpForActivity(activity);
        travelPackage.addPassenger(passenger);
        travelPackage.printPassengerDetails(passenger);
    }

    @Test
    public void testPrintAvailableActivities() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Destination 1");
        destination.addActivity(new Activity("Activity 1", "Description 1", 50.0, 5));
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD));
        travelPackage.printAvailableActivities();
    }
}
