import java.util.Scanner;

public class RewardsConverter {

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
			System.out.println("Welcome to the Credit Card Rewards Converter!");
			System.out.println("Please enter a cash value to convert to airline miles: ");
			var input_value = scanner.nextLine();
			double cashValue;
			try {
			    cashValue = Double.parseDouble(input_value);
			} catch (NumberFormatException exception) {
			    System.out.println("Could not parse input value as a double, exiting");
			    return;
			}

			System.out.println("Converting $" + input_value + " to miles");
			var rewardsValue = new RewardValue(cashValue, false);
			System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
		}
    }
}

class RewardValue {
    private double cashValue;
    private double milesValue;
    private static final double MILES_TO_CASH_RATE = 0.0035;

    // Constructor that accepts a cash value
    public RewardValue(double value, boolean isMiles) {
        if (isMiles) {
            this.milesValue = value;
            this.cashValue = value * MILES_TO_CASH_RATE;
        } else {
            this.cashValue = value;
            this.milesValue = value / MILES_TO_CASH_RATE;
        }
    }

    // Method to get the cash value
    public double getCashValue() {
        return cashValue;
    }

    // Method to get the miles value
    public double getMilesValue() {
        return milesValue;
    }
}
