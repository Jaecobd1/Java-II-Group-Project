package application;
// Started by Jake Dobler
// Code by Genevieve Mathews

abstract public class Clue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accusation Input
        System.out.println("Make Accusations?");
        System.out.print("Player: Input Y/N: ");
        char input = scanner.next().charAt(0);

        if (input == 'Y' || input == 'y') {
            System.out.print("Enter Suspect: ");
            int suspect = scanner.nextInt();

            System.out.print("Enter Item: ");
            int item = scanner.nextInt();

            System.out.print("Enter Location: ");
            int location = scanner.nextInt();

            // Checker program here
            boolean suspectResult = checkSuspect(suspect);
            boolean itemResult = checkItem(item);
            boolean locationResult = checkLocation(location);

            // Output results
            System.out.println("Suspect: " + suspectResult);
            System.out.println("Item: " + itemResult);
            System.out.println("Location: " + locationResult);
        } else {
            System.out.println("No accusations made.");
        }

        scanner.close();
    }

// Accusation Checker
    public static void accusationChecker(int playerSuspect, int playerItem, int playerLocation) {
        // Solution
        String solutionSuspect = "Professor Plum";
        String solutionItem = "Candlestick";
        String solutionLocation = "Study";

        // Player Guess
        String playerGuessSuspect = getSuspectName(playerSuspect);
        String playerGuessItem = getItemName(playerItem);
        String playerGuessLocation = getLocationName(playerLocation);

        // If/then checker
        boolean suspectResult = playerGuessSuspect.equals(solutionSuspect);
        boolean itemResult = playerGuessItem.equals(solutionItem);
        boolean locationResult = playerGuessLocation.equals(solutionLocation);

        // Return results
        System.out.println("Suspect: " + suspectResult);
        System.out.println("Item: " + itemResult);
        System.out.println("Location: " + locationResult);
    }

    // Helper methods to get names based on input numbers
    public static String getSuspectName(int suspect) {
        // Implement logic to get suspect name based on the input number
        return "";
    }

    public static String getItemName(int item) {
        // Implement logic to get item name based on the input number
        return "";
    }

    public static String getLocationName(int location) {
        // Implement logic to get location name based on the input number
        return "";
    }

    // Placeholder methods for checking
    public static boolean checkSuspect(int suspect) {
        // Implement logic to check the suspect
        return false;
    }

    public static boolean checkItem(int item) {
        // Implement logic to check the item
        return false;
    }

    public static boolean checkLocation(int location) {
        // Implement logic to check the location
        return false;
    }
}
