package Lesson.DeckOfCards.CardGame;

import Lesson.DeckOfCards.Card;

import java.util.*;

public class HigherHandGame {
    private List<Card> deck;
    private List<String> card_number;
    private final List<String> pictureCards = List.of(new String[]{"J", "K", "Q", "A"});

    public HigherHandGame(){
        this.deck = Card.getStandardDeck();
        Collections.shuffle(this.deck);

        List<String>stringList = new ArrayList<>();
        for (int i = 1; i<=10; i++){
            stringList.add(String.valueOf(i));
        }


        stringList.addAll(pictureCards);
        this.card_number = stringList;
    }

    public void deal(){
        Random random = new Random();
        int suit_idx1 = random.nextInt(4);
        int suit_idx2 = random.nextInt(4);
        int idx1 = random.nextInt(12);
        int idx2 = random.nextInt(12);

        Card card1 = getCard(suit_idx1, idx1);
        Card card2 = getCard(suit_idx2, idx2);
        if (declareWinner(card1, card2) < 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
        System.out.println("-".repeat(50));
        System.out.println("Player 1's card: ");
        System.out.println(card1);
        System.out.println("Player 2's card: ");
        System.out.print(card2);
    }

    public Card getCard(int suit_idx, int idx){
        String number = card_number.get(idx);
        Card.Suit[] suits = Card.Suit.values();
        if (pictureCards.contains(number)){
            return Card.getFaceCard(suits[suit_idx], number.charAt(0));
        }
        return Card.getNumericCard(suits[suit_idx], Integer.parseInt(number));
    }

    public int declareWinner(Card card1, Card card2){
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        return sortingAlgorithm.compare(card1, card2);
    }
}
