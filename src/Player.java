public class Player {

    private Bank bank;
    private Hand hand;

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

    public void emptyHand() {
        hand.emptyHand();
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }
}
