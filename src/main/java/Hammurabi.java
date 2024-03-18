import java.util.Random;
import java.util.Scanner;


public class Hammurabi {

    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int userAcresOption;
    public static int userBushelsOption;
    public static int userPlantingOption;
    public static int bushelsOfGrainStored = 2800;
    public static int acresOfLand = 1000;
    public static int acresValue = 19;
    public static int bushelsHarvestedPerAcre;
    public static int numBushelsEatenByRats;
    public static int years = 1;
    public static int totalPopulation = 100;
    public static int newPopulation;
    public static int peopleDiedFromPlague;
    public static int peopleStarved = 0;
    public static int newPeople;




    public static void main(String[] args) {
            new Hammurabi().playGame();
        }

        public static void playGame() {

            while (true) {
                if (playSelect().equals("no")) {
                    endGameOption();
                    break;
                }
                gameRules();
                if (confirmPlaySelect().equals("no")){
                    endGameOption();
                    break;
                }
                while (years < 11) {
                    System.out.println("\nIt's year: " + years++ + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    gameStart();
                    acresOption();
                    bushelsOption();
                    plantingOption();

                    implementingOptions();
                    newPeople();
                    starvedPopulation();
                    plagueDeaths();

                    acreCosts();
                    plantingFood();
                    grainsEatenByRats();

                    uprising();


                    if(years == 11){
                        break;
                    }
                }
                break;
            }


        }
    /*
    User Selections Methods
     */
    public static String playSelect() {
        System.out.println("Would you like to play the game? [yes/no]");
        return scanner.next().toLowerCase();
    }

    public static String confirmPlaySelect() {
        System.out.println("Would you like to play the game? [yes/no]");
        return scanner.next().toLowerCase();
    }

    public static void acresOption() {
        System.out.println("How many acres would you wish to buy or sell?");
        userAcresOption = scanner.nextInt();
    }

    public static void bushelsOption() {
        System.out.println("How many bushels would you wish to feed your people?");
        userBushelsOption = scanner.nextInt();
    }

    public static void plantingOption() {
        System.out.println("How many bushels would you wish to plant?");
        userPlantingOption = scanner.nextInt();
    }
    /*
    Implementing User inputs Method
     */
    public static void implementingOptions() {
        acresOfLand += userAcresOption;
        bushelsOfGrainStored -= userBushelsOption;
        bushelsOfGrainStored -= Math.multiplyExact(userPlantingOption, 2);
    }
    /*
    Prompts Methods
     */

    public static void endGame() {
        System.out.println(
                "Your term as Leader has finished after 10 years!\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Your city has had a total of [" + newPopulation + "] people enter your city.\n" +
                "Unfortunately over the years your city has had [" + totalDeaths() + "] deaths.\n" +
                "The city has a total of [" + bushelsOfGrainStored + "] bushels.\n" +
                "The city owns [" + acresOfLand + "] acres.\n"+
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        playGame();
    }

    public static void gameRules() {
        System.out.println(
                "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"+
                "Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office!\n" +
                "Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.\n" +
                "Watch out for rat infestations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:\n" +
                        "\n" +
                "- Each person needs at least 20 bushels of grain per year to survive\n" +
                "- Each person can farm at most 10 acres of land\n" +
                "- It takes 2 bushels of grain to farm an acre of land\n" +
                "- The market price for land fluctuates yearly\n" +
                "Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!\n" +
                "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
    }

    public static void gameStart() {
        System.out.println(
                "Hammurabi: I beg to report to you, \n\n" +
                "The city's total Population is now [" + totalPopulation +"].\n" +
                "In the previous year [" + peopleStarved + "] people starved to death.\n" +
                "In the previous year [" + newPeople + "] people entered the kingdom.\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "We harvested [" + bushelsHarvestedPerAcre + "] per acre.\n" +
                "Rats destroyed [" + numBushelsEatenByRats + "] bushels, leaving [" + bushelsOfGrainStored + "] bushels in storage.\n" +
                "The city owns [" + acresOfLand + "] acres of land.\n" +
                "Land is currently worth [" + acresValue + "] bushels per acre.\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    /*
    Population Methods
     */
    public static void newPeople() {
        if (years > 1) {
            if (peopleStarved <= 10) {
                newPeople = (20 * acresOfLand + bushelsOfGrainStored) / (100 * totalPopulation) + 1;
            }
            totalPopulation += newPeople;
        }
    }

    public static void starvedPopulation() {
        int starvingPeople;
        newPopulation = totalPopulation;
        int foodNeeded = newPopulation * 20;
        int foodRemaining = foodNeeded - userBushelsOption;
        if (years > 1) {
            if (foodNeeded <= userBushelsOption) {
            } else if (foodNeeded > userBushelsOption) {
                for (int i = foodRemaining; i % 20 != 0; i++) {
                    foodRemaining++;
                }
                starvingPeople = foodRemaining / 20;
                peopleStarved = starvingPeople;
                totalPopulation -= peopleStarved;
            }
        }
    }

    public static void plagueDeaths() {
        int diseaseChance = rand.nextInt(100)+1;
        if (years > 1) {
            if (diseaseChance < 16) {
                peopleDiedFromPlague = Math.round(newPopulation /= 2);     // half of totalPopulation dies from plague.
                System.out.println("A horrible disease has struck! You have lost [50%] of your totalPopulation!\n");
            }
        }
    }

    public static int totalDeaths() {
        return peopleStarved + peopleDiedFromPlague;
    }

    /*
    Acres | Bushels | Rat Methods
     */
    public static void acreCosts() {
        if (years >= 1) {
           acresValue = rand.nextInt(24-17) + 17;
           if (userAcresOption < 0) {
               bushelsOfGrainStored += acresValue * (userAcresOption * -1);
           }
           else {
               bushelsOfGrainStored -= userAcresOption * acresValue;
           }
        }
    }

    public static void plantingFood() {
        bushelsOfGrainStored -= userPlantingOption * 2;
        if (years >= 1) {
            int harvestYield = rand.nextInt(6) + 1;
            bushelsHarvestedPerAcre = harvestYield * userPlantingOption;
            bushelsOfGrainStored += bushelsHarvestedPerAcre;
        }
    }

    public static void grainsEatenByRats() {
        if (years > 1) {
            int ratInvasionChance = rand.nextInt(100) + 1;
            if (ratInvasionChance < 41) {                               // 40% chance of rat infestation.
                double ratsConsumption = rand.nextDouble() * 0.30;      // 10 - 30% of grain consumed.
                numBushelsEatenByRats += (int) (bushelsOfGrainStored * ratsConsumption);
            }
        }
        bushelsOfGrainStored -= numBushelsEatenByRats;
    }

    public static void uprising() {
        double uprising = totalPopulation * .45;
        if (peopleStarved >= uprising) {
            System.out.println("You have let more then [45%] of you total Population starve to death! You have been terminated from your position.\n");
            endGame();
        }
    }

    public static void endGameOption() {
        System.out.println("Thanks for playing! Goodbye!");
    }
        //other methods go here
}
