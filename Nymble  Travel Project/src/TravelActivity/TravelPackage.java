package TravelActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Description: " + activity.getDescription() +
                        ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getNumber());
        System.out.println("Balance: " + passenger.getBalance());
        System.out.println("Signed Up Activities:");
        for (Activity activity : passenger.getSignedUpActivities()) {
            System.out.println("Activity: " + activity.getName() + ", Destination:");
                    System.out.println("Destination: " + getActivityDestination(activity).getName() + ", Price: " + getActivityPrice(activity));
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getCapacity();
                for (Passenger passenger : passengers) {
                    if (passenger.getSignedUpActivities().contains(activity)) {
                        spacesAvailable--;
                    }
                }
                System.out.println("Activity: " + activity.getName() + ", Destination: " + destination.getName() +
                        ", Spaces Available: " + spacesAvailable);
            }
        }
    }

    private Destination getActivityDestination(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination;
            }
        }
        return null;
    }

    private double getActivityPrice(Activity activity) {
        for (Destination destination : itinerary) {
            for (Activity destActivity : destination.getActivities()) {
                if (destActivity.equals(activity)) {
                    return destActivity.getCost();
                }
            }
        }
        return 0.0;
    }

    public Map<Object, Object> getItinerary() {
        return null;
    }
}
