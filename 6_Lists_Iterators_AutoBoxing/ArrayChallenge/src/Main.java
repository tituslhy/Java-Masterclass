import java.util.ArrayList;
import java.util.Scanner;

/*
This class is a simple console-based grocery list program. The user chooses a number between 0-2:
//0 - shutdown program
//1 - add item(s) to list (comma delimited)
//2 - remove any items (commma delimited list)
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int action = 1;
        do {
            System.out.println(
                    "Choose:" +
                            "\n-0 to shutdown the program, "+
                            "\n-1 to add items to grocery list, "+
                            "\n-2 to remove items from grocery list"
            );
            action = Integer.parseInt(scanner.nextLine());
            System.out.println("Received action: " + action);
            if ((action>2) || (action<0)){
                System.out.println("Only enter 0, 1, or 2");
            } else if (action==1){
                System.out.println("Add items (separated by commas) to grocery list: ");
                String groceries = scanner.nextLine();
                String[] parts = groceries.split(",");
                for(String part : parts){
                    part = part.trim();
                    if (part.isEmpty()) continue; //catch edge case
                    if (groceryList.contains(part)){
                        System.out.println("Skipping " + part + " because it is already in the grocery list");
                        continue;
                    } groceryList.add(part);
                }
                System.out.println("Updated grocery list: " + groceryList);
            } else if (action==2){
                if (groceryList.isEmpty()){
                    System.out.println("No element left in the grocery list to remove");
                    continue;
                }
                System.out.println("Enter items (separated by commas) to remove from grocery list: ");
                String groceries = scanner.nextLine();
                String[] parts = groceries.split(",");
                for(String part : parts){
                    groceryList.remove(part);
                }
                System.out.println("Updated grocery list: " + groceryList);
            }
        } while(action != 0);
        System.out.println("Shutting down grocery list program. Bye!");
    }
}

