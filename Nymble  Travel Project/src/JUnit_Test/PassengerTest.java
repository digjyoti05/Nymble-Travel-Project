package JUnit_Test;

import TravelActivity.Activity;
import TravelActivity.Passenger;
import TravelActivity.PassengerType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD);
        assertEquals("Digjyoti Nayak", passenger.getName());
        assertEquals(123, passenger.getNumber());
        assertEquals(0.0, passenger.getBalance(), 0.01);
        assertTrue(passenger.getSignedUpActivities().isEmpty());
        assertEquals(PassengerType.STANDARD, passenger.getType());
    }

    @Test
    public void testSignUpForActivity() {
        Passenger passenger = new Passenger("Digjyoti Nayak", 123, PassengerType.STANDARD);
        Activity activity = new Activity("Hiking", "Enjoy hiking in the mountains", 50.0, 1);
        assertTrue(passenger.signUpForActivity(activity));
        assertFalse(passenger.signUpForActivity(activity)); // Capacity full, should return false
        assertFalse(passenger.getSignedUpActivities().isEmpty());
    }
}
