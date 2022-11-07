public class Player {

    private Bank bank;
    private Hand hand;
    private String name;

    public Player(String name, int startingCash) {
        this.bank = new Bank(startingCash);
        this.hand = new Hand();
        this.name = name;
    }



}
