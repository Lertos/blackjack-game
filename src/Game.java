import java.util.Scanner;

public class Game {

    private final Deck deck;
    private final Player player;
    private final House house;
    private int currentBet;

    public Game(Deck deck, Player player, House house) {
        this.deck = deck;
        this.player = player;
        this.house = house;
        this.currentBet = 0;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public int increaseBet() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidBet = false;
        int intBet = 0;

        while (!isValidBet) {
            System.out.println("You currently have " + player.getBank().getBalance() + "$, and the house has " + house.getBank().getBalance() + "$.");
            System.out.println("Please enter your bet: ");

            String stringBet = scanner.nextLine();

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

            //Check to make sure both the player and the house can cover it
            if (player.getBank().getBalance() < intBet || house.getBank().getBalance() < intBet) {
                System.out.println("The bet is too high, please make the bet smaller.");
                continue;
            }

            isValidBet = true;
        }

        return intBet;
    }

    public void startRound(int betAmount) {
        //Accept the bet
        player.getBank().withdraw(betAmount);
        house.getBank().withdraw(betAmount);

        this.currentBet = betAmount;

        //Removes any previous cards
        player.getHand().emptyHand();
        house.getHand().emptyHand();

        //Deal the first card to each the player and the house
        dealCardToPlayer();
        dealCardToHouse(false);

        System.out.println();

        //Deal the second card to each the player and the house
        dealCardToPlayer();
        dealCardToHouse(true);
    }

    public void dealCardToPlayer() {
        //Deal a card to the player
        Card card = deck.getRandomCard();
        player.addCardToHand(card);

        System.out.println("You were dealt a " + card.toString());
    }

    public void dealCardToHouse(boolean cardFaceDown) {
        //Deal a card to the house
        Card card = deck.getRandomCard();
        house.addCardToHand(card);

        if (cardFaceDown) {
            System.out.println("The house was dealt an UNKNOWN card");
        } else {
            System.out.println("The house was dealt a " + card.toString());
        }
    }

    public boolean doesPlayerHit() {
        Scanner scanner = new Scanner(System.in);
        String response;

        while (true) {
            System.out.println("To hit type 'hit', and to stay type 'stay'");

            response = scanner.nextLine();

            if (response.equalsIgnoreCase("hit")) {
                return true;
            } else if (response.equalsIgnoreCase("stay")) {
                return false;
            }
        }
    }

    public boolean doesHouseHit() {
        //If the value is 16 or under, they must take another card
        return house.getHand().getHandValue(false) <= 16;
    }

    public int getWinnings(int playerHandValue, int houseHandValue) {
        int winnings = currentBet;

        if (playerHandValue == 21) {
            winnings = (int) Math.round(currentBet * 1.5);
            System.out.println("PERFECT 21! You win " + Math.abs(winnings) + "$! (1.5x your bet)");
        } else if (playerHandValue > 21) {
            winnings *= -1;
            System.out.println("You busted and lost " + Math.abs(winnings) + "$");
        } else if (houseHandValue > 21) {
            System.out.println("The house busted and you win " + Math.abs(winnings) + "$!");
        } else if (playerHandValue == houseHandValue) {
            winnings = 0;
            System.out.println("You and the house tied with " + playerHandValue + " and no one wins!");
        } else if (playerHandValue > houseHandValue) {
            System.out.println("You beat the house with a score of " + playerHandValue + " (the house had " + houseHandValue + ") and won " + Math.abs(winnings) + "$!");
        } else {
            winnings *= -1;
            System.out.println("The house beat you with a score of " + houseHandValue + " (you had " + playerHandValue + ") and lost " + Math.abs(winnings) + "$");
        }

        return winnings;
    }
}
