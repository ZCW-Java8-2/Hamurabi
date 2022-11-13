public class UserInterface {

    GameEngine game = new GameEngine();
    Console console = new Console();
    State state = new State();


    public void main() {

        while(true){  //Initialize a loop to keep the game playing if the game ends and the player wants to play again
            setUpNewGame();
            announceGame();
            while(state.getYear() < 11){ // Starts the actual game
                initializeRound();

                // Asks how many acres to buy
                int acresToBuy = console.getNumber("How many acres would you like to buy? The price is currently " + state.getPrice() + " bushels per acre.");
                askHowManyAcresToBuy(acresToBuy);

                // Asks how many acres to sell
                int acresToSell = console.getNumber("How many acres would you like to sell? The Price is currently " + state.getPrice() + " bushels per acre.");
                askHowManyAcresToSell(acresToSell);
                if(state.getLandsOwned() < state.getPopulation()*7) { //<-updated gameover
                    System.out.println("you are a national fink!");
                    break;
                }

                // Asks how many bushels to feed to people
                int bushelsFed = console.getNumber("How many bushels would you like to feed your nation?");
                askHowManyBushelsToFeedPeople(bushelsFed);
                if(game.starvationDeaths(state.getPopulation(), bushelsFed) > state.getPopulation()*45/100) {
                    System.out.println("you are a national fink!"); //<-updated gameover
                    break;
                }

                // Asks how many acres to plant with grain
                int acresToPlant = console.getNumber("How many acres to plant?");
                askHowManyAcresToPlant(acresToPlant);
                processRound(state.getPopulation(), bushelsFed, state.getLandsOwned(), acresToPlant*2, state.getBushels());
                printSummary();
            }
            if(exitGame() == false) break;
        }
    }

    public void setUpNewGame(){
        state.setPopulation(100);
        state.setLandsOwned(1000);
        state.setBushels(3000);
        state.setYear(0);
        state.setPrice(19);
        state.setpDeaths(0);
        state.setsDeaths(0);
        state.setImmigrants(0);
        state.setHarvest(0);
        state.setRats(0);
    }

    public void initializeRound(){
        state.setpDeaths(0);
        state.setsDeaths(0);
        state.setImmigrants(0);
        state.setHarvest(0);
        state.setRats(0);
    }

    public void processRound(int population, int bushelsFedToPeople, int acresOwned, int bushelsUsedAsSeed, int bushels ){

        state.setpDeaths(game.plagueDeaths(population));
        state.changePopulation(-state.getpDeaths());

        state.setsDeaths(game.starvationDeaths(population, bushelsFedToPeople));
        state.changePopulation(-state.getsDeaths());

        state.setImmigrants(game.immigrants(population, acresOwned, bushels, bushelsFedToPeople));
        state.changePopulation(state.getImmigrants());

//        state.setHarvest(game.harvest(bushelsUsedAsSeed));
//        state.changeBushels(state.getHarvest()); <-Bugged due to RNG, recommend not use

        state.setRats(game.grainEatenByRats(bushels));
        state.changeBushels(-state.getRats());

        state.setPrice(state.newCostOfLand());

        state.incrementYear();
    }

    public void printSummary() {
        System.out.println("O great Hammurabi");
        System.out.println("You are now in year " + state.getYear() + " of your ten year rule.");
        System.out.println("\n");
        System.out.println("In the previous year " + state.getsDeaths() + " people starved to death.");
        System.out.println("In the previous year "+ state.getImmigrants() + " entered the kingdom.");
        System.out.println("The population is now " + state.getPopulation());
//        System.out.println("We harvested " + state.getHarvest() + " bushels"); <-Bugged due to RNG
        System.out.println("Rats destroyed " + state.getRats() + " bushels");
        System.out.println("There are only " + state.getBushels() + " bushels left in storage.");
        System.out.println("The city owns " + state.getLandsOwned() + " acres of land.");
        System.out.println("Land is currently worth " + state.getPrice() + " bushels per acre");
        System.out.println("\n");
    }

    public void finalSummary() {
        //String
    }

    public void askHowManyAcresToBuy(int acresToBuy){
        if (game.calculateAcresToBuy(acresToBuy, state.getPrice(), state.getBushels()) != 0){
            state.changeLandsOwned(acresToBuy);
            state.changeBushels(-(acresToBuy * state.getPrice()));
            System.out.println("Bushels left: " + state.getBushels()
                            + "\nacres bought: " + acresToBuy
                    + "\nAcres update: " + state.getLandsOwned());
            System.out.println("\n");
            System.out.println("AMAZING! You bought " + acresToBuy + " acres!" );
            System.out.println("\n");
        }
    }

    public void askHowManyAcresToSell(int acresToSell){
        if (game.calculateAcresToSell(acresToSell, state.getLandsOwned(), state.getPopulation()) != 0){
            state.changeLandsOwned(-acresToSell);
            state.changeBushels(acresToSell * state.getPrice());
            System.out.println("Bushels left: " + state.getBushels()
                    + "\nacres sold: " + acresToSell
                    + "\nAcres update: " + state.getLandsOwned());
            System.out.println("\n");
            System.out.println("AMAZING! You sold " + acresToSell + " acres!" );
            System.out.println("\n");
        }
    }

    public void askHowManyBushelsToFeedPeople(int bushelsFed){
        if (game.calculateGrainToFeedPeople(state.getBushels(), bushelsFed) != 0){
            state.changeBushels(-bushelsFed);
            System.out.println("Bushels left: " + state.getBushels()
                    + "\nbushels eaten: " + bushelsFed);
        }
    }

    public void askHowManyAcresToPlant(int acresToPlant) {
//        if (game.calculateAcresToPlant(acresToPlant, state.getLandsOwned(), state.getPopulation(), state.getBushels()) > 0) {
        acresToPlant = game.calculateAcresToPlant(acresToPlant, state.getLandsOwned(), state.getPopulation(), state.getBushels());
        state.changeBushels(-acresToPlant);
        System.out.println(state.getBushels());
        state.changeBushels(game.harvest(acresToPlant));
            System.out.println("Acres planted: " + acresToPlant +
                    "\nUpdated Bushels " + state.getBushels());
            // FINISHED
//        } else if (game.calculateAcresToPlant(acresToPlant, state.getLandsOwned(), state.getPopulation(), state.getBushels()) == 0)
    }

        public void announceGame () {
            System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office.");
            System.out.println("Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.");
            System.out.println("Grain is the general currency, measured in bushels.");
            System.out.println("\n");
            System.out.println("The following will help you in your decisions:");
            System.out.println("\n");
            System.out.println("**Each person needs at least 20 bushels of grain per year to survive**");
            System.out.println("**Each person can farm at most 10 acres of land**");
            System.out.println("**It takes 2 bushels of grain to farm an acre of land**");
            System.out.println("**The market price for land fluctuates yearly**");
            System.out.println("\n");
            System.out.println("Now, let's begin!");
            System.out.println("\n");
            System.out.println("O great One! Your kingdom await your orders!");
            System.out.println("There are " + state.getPopulation() + " people that you must feed!");
            System.out.println("Our coffers have " + state.getBushels() + " bushels in storage.");
            System.out.println("The city owns " + state.getLandsOwned() + " acres of land.");
            System.out.println("Land is available to purchase for " + state.getPrice() + " bushels per acre");
            System.out.println("\n");
        }

        public boolean exitGame () { //fixed exitgame
            int options = console.getNumber("Would you like to play? 1 = Yes, 2 = No");
            boolean answer = true;
            switch (options) {
                case 1:
                    System.out.println("That's the spirit!");
                    answer = true;
                    break;
                case 2:
                    System.out.println("Goodbye");
                    answer = false;
                    break;
            }
            return answer;
        }
}
