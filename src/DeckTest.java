import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {
    @Test
    public void shuffleCards() {
        Deck deck = new Deck();
        deck.shuffleCards();

        assertEquals(52, deck.getAllCards().size());
    }

    @Test
    public void getRandomCard() {
        Deck deck = new Deck();
        deck.shuffleCards();

        assertNotEquals(deck.getRandomCard(), deck.getRandomCard());
    }
}