package JUnit_Test;

import TravelActivity.Activity;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void testActivityCreation() {
        Activity activity = new Activity("Hiking", "Enjoy hiking in the mountains", 50.0, 20);
        assertEquals("Hiking", activity.getName());
        assertEquals("Enjoy hiking in the mountains", activity.getDescription());
        assertEquals(50.0, activity.getCost(), 0.01);
        assertEquals(20, activity.getCapacity());
    }

    @Test
    public void testActivityCapacity() {
        Activity activity = new Activity("Hiking", "Enjoy hiking in the mountains", 50.0, 20);
        activity.reduceCapacity(); // simulate one signup
        assertEquals(19, activity.getCapacity());
    }
}
