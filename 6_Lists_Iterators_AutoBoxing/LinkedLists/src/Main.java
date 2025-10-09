import java.util.LinkedList;
import java.util.ListIterator;

//A LinkedList is basically a deque

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        //this works too
//        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

        gettingElements(placesToVisit);
        printItinerary(placesToVisit);

        testListIterator(placesToVisit);
        testIterator(placesToVisit);

        removeElements(placesToVisit);
        System.out.println(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // This is a special LinkedList method
        list.offer("Melbourne"); //added to the back by default
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        list.push("Alice Springs"); //added to the front
    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4); //remove 4th element
        list.remove("Brisbane"); //remove the element Brisbane

        String s1 = list.remove(); //remove the first element by default
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");
        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        //poll methods
        String p1 = list.poll(); //removes first element
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast();
        System.out.println(p2 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        String p4 = list.pop(); //remove first element
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieved Element = " + list.getFirst());
        System.out.println("Retrieved Element = " + list.get(4));
        System.out.println("Retrieved Element = " + list.getLast());
        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        //Queue retrieval - takes the first element
        System.out.println("Element from element() = " + list.element());

        //Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek()); //peeks at the first element
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("-".repeat(30));
        System.out.println("Trip starts at " + list.getFirst());

        //Using a list iterator - a listiterator supports going backwards and forwards
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1); //pass in the index you want to start at
        while (iterator.hasNext()){
            var town = iterator.next(); //using .next() moves the cursor position to the next element in the list.
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println("-".repeat(30));
    }

    private static void testIterator(LinkedList<String> list){

        // NOte that iterators only move forward through the list and only supports the remove method.
        var iterator = list.iterator(); //list.listIterator() to use a listIterator;

        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")){
                iterator.remove(); //the iterator provides a safe way to remove elements from a list.
            }
        }

        // Once the iterator is done iterating through the linked list you have to reset the pointer back
        // to the beginning.
        System.out.println(list);
    }

    private static void testListIterator(LinkedList<String> list){
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }
        //iterate backwards!
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

        var iterator2 = list.listIterator(3); //specify cursor position
        System.out.println(iterator.next());
        System.out.println(iterator.previous());

        System.out.println(list);
    }
}
