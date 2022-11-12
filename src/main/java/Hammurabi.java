import java.util.*;

public class Hammurabi {
    public static void main(String[] args) {
            Hammurabi ham = new Hammurabi(100, 1000, 3000, 0, 19);
        while(ham.playerWantsNewGame()){  //Initialize a loop to keep the game playing if the game ends and the player wants to play again
            ham.setUpNewGame();
            while(ham.getYear() < 11){ // Starts the actual game
                ham.initializeRound();
                ham.printSummary();

                // Asks how many acres to buy

                int acresToBuy = ham.getNumber("How many acres would you like to buy? The price is currently " + ham.getPrice() + " bushels per acre.");
                if (ham.howManyAcresToBuy(acresToBuy, ham.getPrice(), ham.getBushels()) != 0){
                    ham.changeLandsOwned(acresToBuy);
                    ham.changeBushels(acresToBuy * ham.getPrice());
                    System.out.println("AMAZING! You bought " + acresToBuy + "acres!" );
                }

                // Asks how many acres to sell

                int acresToSell = ham.getNumber("How many acres would you like to sell? The Price is currently " + ham.getPrice() + " bushels per acre.");
                if (ham.howManyAcresToSell(ham.getLandsOwned()) != 0){
                    ham.changeLandsOwned(acresToSell);
                    ham.changeBushels(acresToSell * ham.getPrice());
                    System.out.println("AMAZING! You sold " + acresToSell + "acres!" );
                }

                int acresToPlant = 0 // NOT DONE YET NEED TO KEEP GOIN!!!

            }
        }
    }

    Random random = new Random();
    int randomNum = random.nextInt();
    Scanner scanner = new Scanner (System.in);
    int  population, landsOwned, bushels, year;
    int temp;
    int price;


    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLandsOwned(int landsOwned) {
        this.landsOwned = landsOwned;
    }

    public void setBushels(int bushels) {
        this.bushels = bushels;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Hammurabi(int population, int landsOwned, int bushels, int year, int price) {
        this.population = population;
        this.landsOwned = landsOwned;
        this.bushels = bushels;
        this.year = year;
        this.price = price;
    }

    public void setUpNewGame(){
        this.setPopulation(100);
        this.setLandsOwned(1000);
        this.setBushels(3000);
        this.setYear(0);
        this.setPrice(19);
    }

    public void initializeRound(){
        this.setPrice(newCostOfLand());
        this.incrementYear();
    }
    public int howManyAcresToBuy(int acresToBuy, int price, int bushels){
        if ( (acresToBuy * price) > bushels){
            System.out.println("You FOOL! You don't have enough bushels to buy that many acres!");
            return 0;
        } else return acresToBuy;
    }

    public int howManyAcresToSell(int acresOwned) {
        return 0;
    }

    public int howMuchGrainToFeedPeople(int bushels) {
        return 0;
    }

    public int howManyAcresToPlant(int acresOwned, int population, int bushels) {
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

    public boolean playerWantsNewGame(){ //THIS IS NOT FINISHED YET... NEED TO ADD REAL LOGIC
        System.out.println("Would you like to continue playing?");
        return true;
    }
    public int getPopulation() {
        return population;
    }

    public void changePopulation(int populationChange) {
        this.population += populationChange;
    }

    public int getLandsOwned() {
        return landsOwned;
    }

    public void changeLandsOwned(int acresToChange) {
        this.landsOwned += acresToChange;
    }

    public int getBushels() {
        return bushels;
    }

    public void changeBushels(int bushelsChanged) {
        this.bushels += bushelsChanged;
    }

    public int getYear() {
        return year;
    }

    public void incrementYear() {
        this.year += 1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
