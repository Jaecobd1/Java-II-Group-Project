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
