import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the only blackjack table you'll ever need.");

        Player player = new Player(100);
        House house = new House(1000);

        String response = "";

        //Start the main loop
        while (response != "q") {
            Deck deck = new Deck();
            deck.shuffleCards();

            Game game = new Game(deck, player, house);

            int intBet = game.increaseBet();

            //Deal the initial two cards to the player and the house
            game.startRound(intBet);

            System.out.println("\nYour hand value is currently: " + player.getHand().getHandValue());
            System.out.println("The house's hand value is currently: " + house.getHand().getHandValue() + " and UNKNOWN card\n");

            //Get the value of the players hand after the initial deal
            int playerHandValue = player.getHand().getHandValue();
            boolean playerFinished = false;

            //Continue to deal cards to the player if they want them
            while (!playerFinished && playerHandValue < 21) {
                //Player continues to pull cards
                if (game.doesPlayerHit()) {
                    game.dealCardToPlayer();
                    playerHandValue = player.getHand().getHandValue();
                    System.out.println("\nYour hand value is currently: " + player.getHand().getHandValue());
                } else {
                    playerFinished = true;
                }
            }

            //Check if the player won perfectly or busted. If not continue
            int houseHandValue = house.getHand().getHandValue();

            if (playerHandValue < 21) {
                //Now that the player is good with their cards, the house has to try to beat them
                boolean houseFinished = false;

                System.out.println("The house's UNKNOWN card was a " + house.getHand().getCards().get(1).toString());

                //Continue to deal cards to the house if they need to
                while (!houseFinished || houseHandValue < 21) {
                    //House continues to pull cards
                    if (game.doesHouseHit()) {
                        game.dealCardToHouse(false);
                        houseHandValue = house.getHand().getHandValue();
                        System.out.println("\nThe house's value is currently: " + house.getHand().getHandValue());
                    } else {
                        houseFinished = true;
                    }
                }
            }

            //Check who the winner is
            int winnings = game.getWinnings(playerHandValue, houseHandValue);

            //Handle the payouts and start a new game or quit
            if (winnings > 0) {
                player.getBank().deposit(Math.abs(winnings) + game.getCurrentBet());
            } else if (winnings < 0) {
                house.getBank().deposit(Math.abs(winnings) + game.getCurrentBet());
            }

            System.out.println("\n=================================");
            System.out.println("The house currently has " + house.getBank().getBalance() + "$");
            System.out.println("You currently have " + player.getBank().getBalance() + "$");
            System.out.println("=================================");

            System.out.println("\nType 'q' to quit, or anything else to continue.");

            response = scanner.nextLine();
        }
    }
}