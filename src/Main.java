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

            System.out.println("You currently have " + player.getBank().getBalance() + "$, and the house has " + house.getBank().getBalance() + "$.");
            System.out.println("Please enter your initial bet: ");

            String stringBet = scanner.nextLine();
            int intBet;

            try {
                intBet = Integer.parseInt(stringBet);
            } catch (NumberFormatException e) {
                System.out.println("Your bet must be an integer above 0");
                continue;
            }

            //Check to make sure it's a valid bet; over 0
            if (intBet <= 0) {
                System.out.println("Your bet must be an integer above 0");
                continue;
            }

            System.out.println("You have placed a bet of " + intBet + "$");

            //Deal the initial card to the player
            Card card = deck.getRandomCard();
            player.addCardToHand(card);

            System.out.println("You have been dealt a card: " + card.toString());

            //Deal the initial card to the house
            card = deck.getRandomCard();
            house.addCardToHand(card);

            System.out.println("The house has been dealt a card: " + card.toString());

        }


    }
}