public class House {

    private Bank bank;
    private Hand hand;

    public House(int startingCash) {
        this.bank = new Bank(startingCash);
        this.hand = new Hand();
    }
}
