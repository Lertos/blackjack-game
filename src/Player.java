public class Player {

    private Bank bank;
    private Hand hand;
    private String name;

    public Player(String name, int startingCash) {
        this.bank = new Bank(startingCash);
        this.hand = new Hand();
        this.name = name;
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
