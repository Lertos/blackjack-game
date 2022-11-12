import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
        deck.shuffleCards();
    }

    @Test
    public void shuffleCards() {
        assertEquals(52, deck.getAllCards().size());
    }

    @Test
    public void getRandomCard() {
        assertNotEquals(deck.getRandomCard(), deck.getRandomCard());
    }
}