package TravelActivity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int number;
    private double balance;
    private PassengerType type;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int number, PassengerType type) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.signedUpActivities = new ArrayList<>();
        switch (type) {
            case STANDARD:
            case GOLD:
                this.balance = 0.0;
                break;
            case PREMIUM:
                this.balance = Double.POSITIVE_INFINITY;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public PassengerType getType() {
        return type;
    }

    public boolean signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            if ((type == PassengerType.STANDARD && balance >= activity.getCost()) ||
                    type == PassengerType.GOLD || type == PassengerType.PREMIUM) {
                double cost = (type == PassengerType.GOLD) ? activity.getCost() * 0.9 : activity.getCost();
                if (type != PassengerType.PREMIUM) {
                    balance -= cost;
                }
                signedUpActivities.add(activity);
                activity.reduceCapacity();
                return true;
            }
        }
        return false;
    }
}

