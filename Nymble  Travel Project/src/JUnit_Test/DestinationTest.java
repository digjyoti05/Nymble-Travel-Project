package JUnit_Test;


    import TravelActivity.Activity;
    import TravelActivity.Destination;
    import org.junit.Test;
import static org.junit.Assert.*;

    public class DestinationTest {

        @Test
        public void testDestinationCreation() {
            Destination destination = new Destination("Beach");
            assertEquals("Beach", destination.getName());
            assertTrue(destination.getActivities().isEmpty());
        }

        @Test
        public void testAddActivity() {
            Destination destination = new Destination("Beach");
            Activity activity = new Activity("Swimming", "Swim in the ocean", 20.0, 10);
            destination.addActivity(activity);
            assertFalse(destination.getActivities().isEmpty());
            assertEquals(activity, destination.getActivities().get(0));
        }
    }


