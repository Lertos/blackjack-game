public class House {

    private Bank bank;
    private Hand hand;

    public House(int startingCash) {
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

    public boolean addCardToHand(Card card) {
        return hand.addCard(card);
    }
}
