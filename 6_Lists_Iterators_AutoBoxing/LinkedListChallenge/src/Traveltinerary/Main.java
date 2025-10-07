package Traveltinerary;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> destinations = sortByDistance(initializeDestinations());
        ListIterator<String> iterator = destinations.listIterator();
        boolean quit = false;

        printMenu();

        // Start at the first place
        if (iterator.hasNext()) {
            System.out.println("You are currently at " + iterator.next());
        }

        do {
            String action = scanner.nextLine().trim().toUpperCase();
            switch (action) {
                case "Q":
                    quit = true;
                    break;

                case "F":
                    if (iterator.hasNext()) {
                        System.out.println("You are now at " + iterator.next());
                    } else {
                        System.out.println("There are no other places in your itinerary.");
                    }
                    break;

                case "B":
                    if (iterator.hasPrevious()) {
                        System.out.println("You are now at " + iterator.previous());
                    } else {
                        System.out.println("You are at the start of your itinerary.");
                    }
                    break;

                case "L":
                    System.out.println("Places in your itinerary:");
                    for (String place : destinations) {
                        System.out.println(place);
                    }
                    break;

                case "M":
                    printMenu();
                    break;

                default:
                    System.out.println("Invalid input! Press M to see the menu.");
            }
        } while (!quit);

        System.out.println("Quitting itinerary program. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("""
                Press either:
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    private static Map<String, Integer> initializeDestinations() {
        Map<String, Integer> unsorted = new HashMap<>();
        unsorted.put("Sydney", 0);
        unsorted.put("Adelaide", 1374);
        unsorted.put("Alice Springs", 2771);
        unsorted.put("Brisbane", 917);
        unsorted.put("Darwin", 3972);
        unsorted.put("Melbourne", 877);
        unsorted.put("Perth", 3923);
        return unsorted;
    }

    private static LinkedList<String> sortByDistance(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sorted = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return new LinkedList<>(sorted.keySet());
    }
}