package Lesson.One.DeckOfCards.CardGame;

import Lesson.One.DeckOfCards.Card;

import java.util.*;

public class HigherHandGame {
    private List<Card> deck;

    public HigherHandGame(){
        this.deck = Card.getStandardDeck();
        Collections.shuffle(this.deck);
    }

    public void deal(int num_players){
        // Deck already shuffled in constructor, just take first N cards
        List<Card> dealtCards = new ArrayList<>(deck.subList(0, num_players));

        Map<Card, String> cardDraw = new HashMap<>();
        for (int i = 0; i < dealtCards.size(); i++){
            cardDraw.put(dealtCards.get(i), "Player " + (i + 1));  // Fixed
        }

        var sortedCards = sortCards(dealtCards);  // Sort the dealt cards
        String winner = cardDraw.get(sortedCards.get(sortedCards.size() - 1));  // Highest card wins
        System.out.println("Winner is: " + winner);

        for (Map.Entry<Card, String> entry: cardDraw.entrySet()){
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    public List<Card> sortCards(List<Card> cards){
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        cards.sort(sortingAlgorithm);
        return cards;
    }
}
