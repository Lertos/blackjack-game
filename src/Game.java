public class Game {

    private Player player;
    private House house;
    private int currentBet;

    public Game(Player player, House house) {
        this.player = player;
        this.house = house;
        this.currentBet = 0;
    }

    public boolean startRound(int betAmount) {
        //Check if the player and the bank can handle the bet
        if (player.getBank().getBalance() > betAmount || house.getBank().getBalance() > betAmount) {
            System.out.println("The bet is too high, please make the bet smaller.");
            return false;
        }

        //Accept the bet
        player.getBank().withdraw(betAmount);
        house.getBank().withdraw(betAmount);

        this.currentBet = betAmount;

        //Deal the first card


        return true;
    }

}
