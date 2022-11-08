import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the only blackjack table you'll ever need.");
        System.out.println("Please enter your name: ");

        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100);
        House house = new House(1000);

        String response = "";

        while (response != "q") {
            Deck deck = new Deck();
            deck.shuffleCards();

            Game game = new Game(deck, player, house);

            int intBet = game.increaseBet();

            game.startRound(intBet);

            int playerHandValue = player.getHand().getHandValue();
            boolean playerFinished = false;

            while (!playerFinished || playerHandValue < 21) {
                //Player continues to pull cards
                if (game.doesPlayerHit()) {
                    game.dealCardToPlayer();
                } else {
                    playerFinished = true;
                }
            }

            //Determine winnings and start a new game
            int winnings;
            //TODO: If ==21
            winnings = (int) Math.round(game.getCurrentBet() * 1.5);
            System.out.println("You got a perfect 21, you win 1.5x your bet, which is " + winnings + "$!");

            //TODO: If >21
            winnings = game.getCurrentBet() * -1;
            System.out.println("You busted by going over 21 and have lost your money...");

            System.out.println("To quit type 'q', and to continue type anything else.");

            response = scanner.nextLine();
        }
    }
}