enum Suit {
    Spade,
    Club,
    Heart,
    Diamond
}

public class Card {

    private int[] values;
    private String rank;
    private Suit suit;

    public Card(int[] values, String rank, Suit suit) {
        if (values.length > 2) {
            System.out.println("A card cannot have more than two values.");
            return;
        }
        this.values = values;
        this.rank = rank;
        this.suit = suit;
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "s";
    }
}
