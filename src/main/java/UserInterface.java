public class UserInterface {

    GameEngine game = new GameEngine();
    Console console = new Console();
    State state = new State();


    public void main() {

        while(exitGame() == false){  //Initialize a loop to keep the game playing if the game ends and the player wants to play again
            setUpNewGame();
            while(state.getYear() < 11){ // Starts the actual game
                initializeRound();
                printSummary();

                // Asks how many acres to buy
                int acresToBuy = console.getNumber("How many acres would you like to buy? The price is currently " + state.getPrice() + " bushels per acre.");
                askHowManyAcresToBuy(acresToBuy);

                // Asks how many acres to sell
                int acresToSell = console.getNumber("How many acres would you like to sell? The Price is currently " + state.getPrice() + " bushels per acre.");
                askHowManyAcresToSell(acresToSell);

//                int acresToPlant = 0 // NOT DONE YET NEED TO KEEP GOIN!!!

            }
        }
    }

    public void setUpNewGame(){
        state.setPopulation(100);
        state.setLandsOwned(1000);
        state.setBushels(3000);
        state.setYear(0);
        state.setPrice(19);
    }

    public void initializeRound(){
        state.setPrice(state.newCostOfLand());
        state.incrementYear();
    }

    public void printSummary() {
        //String
    }

    public void finalSummary() {
        //String
    }

    public void askHowManyAcresToBuy(int acresToBuy){
        if (game.calculateAcresToBuy(acresToBuy, state.getPrice(), state.getBushels()) != 0){
            state.changeLandsOwned(acresToBuy);
            state.changeBushels(acresToBuy * state.getPrice());
            System.out.println("AMAZING! You bought " + acresToBuy + "acres!" );
        }
    }

    public void askHowManyAcresToSell(int acresToSell){
        if (game.calculateAcresToSell(state.getLandsOwned()) != 0){
            state.changeLandsOwned(acresToSell);
            state.changeBushels(acresToSell * state.getPrice());
            System.out.println("AMAZING! You sold " + acresToSell + "acres!" );
        }
    }

    public boolean exitGame(){ //THIS IS NOT FINISHED YET... NEED TO ADD REAL LOGIC
        System.out.println("Would you like to continue playing?");
        return false;
    }

}
