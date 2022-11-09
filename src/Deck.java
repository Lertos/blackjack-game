import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> allCards;
    private int[] cardValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    public Deck() {
        this.allCards = new ArrayList<>();
    }

    public void shuffleCards() {
        //First clear the deck
        allCards.clear();

        //Create all the cards
        for (Suit suit : Suit.values()) {
            for (int i=0; i<cardValues.length; i++) {
                Card newCard;

                if (i == 0) {
                    newCard = new Card(new int[]{1, 11}, cardNames[i], suit);
                } else {
                    newCard = new Card(new int[]{cardValues[i]}, cardNames[i], suit);
                }

                allCards.add(newCard);
            }
        }
    }

    public Card getRandomCard() {
        Random rand = new Random();
        int index = rand.nextInt(allCards.size());
        Card card = allCards.get(index);

        allCards.remove(index);

        return card;
    }
}
