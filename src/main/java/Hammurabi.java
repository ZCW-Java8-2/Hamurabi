import java.util.*;

public class Hammurabi {
    public static void main(String[] args) {

    }

    Random random = new Random();
    int randomNum = random.nextInt();
    Scanner scanner = new Scanner (System.in);

    public Hammurabi() {

    }

    public int askHowManyAcresToBuy(int price, int bushels){
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

    public void printSummary() {
        //String
    }

    public void finalSummary() {
        //String
    }

    public void playGame() {
        //int
    }

    public int plagueDeaths(int population) {
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        return 0;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return true;
    }

    public int immigrants (int population, int acresOwned, int grainInStorage) {
        return 0;
    }

    public int harvest (int bushelsUsedAsSeed) {
        return 0;
    }

    public int grainEatenByRats (int bushels) {
        return random.nextInt(21)+10;
    }

    public int newCostOfLand() {
        return random.nextInt(7)+17;
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
}
