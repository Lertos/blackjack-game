public class Player {

    private final Bank bank;
    private final Hand hand;

    public Player(int startingCash) {
        this.bank = new Bank(startingCash);
        this.hand = new Hand();
    }

    public Bank getBank() {
        return bank;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }
}
