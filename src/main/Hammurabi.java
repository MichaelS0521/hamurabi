package hammurabi.src.main;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Hammurabi {

        Random rand = new Random();
        public static Scanner scanner = new Scanner(System.in);
        public static int years = 1;
        public static int yearOnePopulation = 100;
        public static int userInput;

        public static void main(String[] args) {
            new Hammurabi().playGame();
        }

        void playGame() {

            while (true) {
                if (playSelect().equals("no")) {
                    endGame();
                    break;
                }
                gameRules();

                while (years < 11) {
                    System.out.println("It's year: " + years);
                }
                if(years == 11){
                    break;
                }
            }


        }

    public static String playSelect() {
        System.out.println("Would you like to play the game?");
        return scanner.next().toLowerCase();
    }

    public static void endGame() {
        System.out.println("Ending Program");
    }

    public static void gameRules() {
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office. " +
                "Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. Watch out for rat " +
                "infestiations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:\n" +
                "\n" +
                "- Each person needs at least 20 bushels of grain per year to survive\n" +
                "- Each person can farm at most 10 acres of land\n" +
                "- It takes 2 bushels of grain to farm an acre of land\n" +
                "- The market price for land fluctuates yearly\n" +
                "Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!\n");
    }

    public int askHowManyAcresToBuy (int price, int bushels) {
            return 0;
        }

        public int askHowManyAcresToSell(int acresOwned) {
            return 0;
        }

        public int askHowMuchGrainToFeedPeople(int bushels) {
            return 0;
        }

        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            return 0;
        }
        //other methods go here
}
