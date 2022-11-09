import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void emptyHand() {
        cards.clear();
    }

    public int getHandValue(boolean hideAllButFirst) {
        int value = 0;
        int aceCount = 0;
        int count = 0;

        for (Card card : cards) {
            if (hideAllButFirst && count > 0)
                break;

            int[] values = card.getValues();

            if (values.length == 2) {
                aceCount++;
                value += Math.max(values[0], values[1]);
            } else {
                value += values[0];
            }
            count++;
        }

        //Turn aces into 1's if possible to get under 21
        for (int i=0; i<aceCount; i++) {
            if (value > 21) {
                value -= 10;
            } else {
                break;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }
}
