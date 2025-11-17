package Lesson._1.DeckOfCards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        // Create an array of cards for one suit
        // This method fails because 'fill' does not replace null values.
        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1);

        // Create n copies
        // New Array of cards
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of clubs", 1);

        // Add all
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card collection with Aces added", 1);

        // Copy - does not work if the list is empty.
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card collection with Aces added and Kings copied", 2);

        cards = List.copyOf(kingsOfClubs); //this is an unmodifiable copy of the list
        Card.printDeck(cards, "List Copy of Kings", 1);

        // shuffle
        List<Card> deck2 = Card.getStandardDeck();
        Collections.shuffle(deck2);
        Card.printDeck(deck2, "Shuffled Deck", 4);

        // reverse
        Collections.reverse(deck2);
        Card.printDeck(deck2, "Reversed Deck", 4);

        // Sorting. Collections.sort calls list.sort
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck2, sortingAlgorithm);
        Card.printDeck(deck2, "Sorted Deck", 13);
        Collections.reverse(deck2);
        Card.printDeck(deck2, "Sorted Deck, suit reversed", 13);

        List<Card> kings = new ArrayList<>(deck2.subList(4, 8)); //Kings are in the second row
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck2.subList(16, 20)); //Tens are in the fifth row
        Card.printDeck(tens, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck2, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck2.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck2, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);

        //resort to use the binary search method
        deck2.sort(sortingAlgorithm);

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        // your list must be sorted before you can execute binary search
        // int foundIndex = Collections.binarySearch(deck2, tenOfHearts, sortingAlgorithm);

        //Alternatively: Use this if your list is unsorted and contains a small number of elements.
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));

        // System.out.println("foundIndex = " + foundIndex);
        // System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        // Replaces all elements
        Collections.replaceAll(deck2, tenOfClubs, tenOfHearts);
        Card.printDeck(deck2.subList(32,36), "Tens row", 1);

        Collections.replaceAll(deck2, tenOfHearts, tenOfClubs);
        Card.printDeck(deck2.subList(32,36), "Tens row", 1);

        if (Collections.replaceAll(deck2, tenOfClubs, tenOfHearts)){
            System.out.println("Replaced");
        } else {
            System.out.println("No tens of hearts found in list");
        }

        // Check for duplicates
        System.out.println("Tens of Clubs Cards = " +
                Collections.frequency(deck2, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        //Rotate
        List<Card> copied = new ArrayList<>(deck2.subList(0, 13));
        Collections.rotate(copied, 2); //move to the end of the list
        System.out.println("Unrotated: " + deck2.subList(0,13));
        System.out.println("Rotated" + 2 + ": " + copied);

        //Swap
        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size() / 2; i++){
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse: " + copied);

        //Alternatively just reverse]
        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using reverse: " + copied);
    }
}
