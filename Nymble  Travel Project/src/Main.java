import TravelActivity.*;

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}
public class Main {
    public static void main(String[] args) {
        // Create activities
        Activity hiking = new Activity("Hiking", "Enjoy hiking in the mountains", 50.0, 20);
        Activity swimming = new Activity("Swimming", "Swim in the ocean", 30.0, 15);

        // Create destinations and add activities
        Destination mountains = new Destination("Mountains");
        mountains.addActivity(hiking);

        Destination beach = new Destination("Beach");
        beach.addActivity(swimming);

        // Create passengers
        Passenger standardPassenger = new Passenger("Digjyoti Nayak", 1, PassengerType.STANDARD);
        Passenger goldPassenger = new Passenger("Digjyoti Nayak", 2, PassengerType.GOLD);

        // Create travel package and add destinations
        TravelPackage travelPackage = new TravelPackage("Adventure Package", 10);
        travelPackage.addDestination(mountains);
        travelPackage.addDestination(beach);

        // Add passengers to travel package
        travelPackage.addPassenger(standardPassenger);
        travelPackage.addPassenger(goldPassenger);

        // Print itinerary, passenger list, etc.
        travelPackage.printItinerary();
        travelPackage.printPassengerList();
        travelPackage.printAvailableActivities();
    }
}
