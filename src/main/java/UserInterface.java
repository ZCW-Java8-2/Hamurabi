public class UserInterface {

    GameEngine game = new GameEngine();
    Console console = new Console();
    State state = new State();


    public void main() {

        while (true) {
            setUpNewGame();
            console.announceGame(state.getPopulation(), state.getBushels(), state.getLandsOwned(), state.getPrice());

            while (state.getYear() < 11) {

                // Asks how many acres to buy
                askHowManyAcresToBuy(console.acresToBuySOUT(state.getPrice()));

                // Asks how many acres to sell
                askHowManyAcresToSell(console.acresToSellSOUT(state.getPrice()));

                if (state.getLandsOwned() < state.getPopulation() * 7) { //<-updated gameover
                    console.monster();
                    break;
                }

                // Asks how many bushels to feed to people
                int bushelsFed = console.bushelsToFeed();
                askHowManyBushelsToFeedPeople(bushelsFed);
                if (game.starvationDeaths(state.getPopulation(), bushelsFed) > state.getPopulation() * 45 / 100) {

                    console.monster(); //<-updated gameover
                    break;
                }

                // Asks how many acres to plant with grain
                int acresPlanted = console.acresToPlant();
                askHowManyAcresToPlant(acresPlanted);

                //Process the round, print data, and initialize the next round

                processRound(state.getPopulation(), bushelsFed, state.getLandsOwned(), acresPlanted * 2, state.getBushels());

                console.printSummary(state.getYear(), state.getImmigrants(), state.sDeaths, state.pDeaths, state.getPopulation(), state.getRats(), state.getBushels(), state.getLandsOwned(), state.getPrice());

                initializeRound();

            }

            if (state.getYear() == 11) { //<-newly added, it works
                console.gameEndingPrompt(state.getsDeathsPool(), state.getImmigrantsPool(), state.getPopulation(), state.getLandsOwned());
                badEnding();
                normalEnding();
                goodEnding();
                break;
            }
//            if (console.exitGame() == false) break;
        }
    }

    public void setUpNewGame() {
        state.setPopulation(100);
        state.setLandsOwned(1000);
        state.setBushels(2800);
        state.setYear(0);
        state.setPrice(19);
        state.setpDeaths(0);
        state.setsDeaths(0);
        state.setImmigrants(0);
        state.setHarvest(0);
        state.setRats(0);
    }

    public void initializeRound() {
        state.setpDeaths(0);
        state.setsDeaths(0);
        state.setImmigrants(0);
        state.setHarvest(0);
        state.setRats(0);
    }

    public void processRound(int population, int bushelsFedToPeople, int acresOwned, int bushelsUsedAsSeed, int bushels) {

        state.setImmigrants(game.immigrants(population, acresOwned, bushels, bushelsFedToPeople));
        state.changePopulation(state.getImmigrants());

        state.setpDeaths(game.plagueDeaths(state.getPopulation()));
        state.changePopulation(-state.getpDeaths());

        state.setsDeaths(game.starvationDeaths(population, bushelsFedToPeople));
        state.changePopulation(-state.getsDeaths());

//        state.setHarvest(game.harvest(bushelsUsedAsSeed));
//        state.changeBushels(state.getHarvest()); <-Bugged due to RNG, recommend not use DO WE WANT TO FIX THIS??? -- EMORY

        state.setRats(game.grainEatenByRats(bushels));
        state.changeBushels(-state.getRats());

        state.setPrice(state.newCostOfLand());

        state.setsDeathsPool(state.getsDeathsPool() + state.getsDeaths());

        state.setImmigrantsPool(state.getImmigrantsPool() + state.getImmigrants());

        state.incrementYear();
    }

    public void askHowManyAcresToBuy(int acresToBuy) {
        if (game.calculateAcresToBuy(acresToBuy, state.getPrice(), state.getBushels()) != 0) {

            state.changeLandsOwned(acresToBuy);
            state.changeBushels(-(acresToBuy * state.getPrice()));

            console.prompt(state.getBushels(), state.getPopulation(), state.getLandsOwned());
        }
    }

    public void askHowManyAcresToSell(int acresToSell) {
        if (game.calculateAcresToSell(acresToSell, state.getLandsOwned()) != 0) {

            state.changeLandsOwned(-acresToSell);
            state.changeBushels(acresToSell * state.getPrice());

            console.prompt(state.getBushels(), state.getPopulation(), state.getLandsOwned());
        }
    }

    public void askHowManyBushelsToFeedPeople(int bushelsFed) {

        if (game.calculateGrainToFeedPeople(state.getBushels(), bushelsFed) != 0) {

            state.changeBushels(-bushelsFed);

            console.prompt(state.getBushels(), state.getPopulation(), state.getLandsOwned());

        } else if (game.calculateGrainToFeedPeople(state.getBushels(), bushelsFed) == 0) {
            if (game.starvationDeaths(state.getPopulation(), game.calculateGrainToFeedPeople(state.getBushels(), bushelsFed)) > state.getPopulation() * 45 / 100) {

                console.monster(); //<-updated gameover
//                console.exitGame();

            }
        }
    }

    public void askHowManyAcresToPlant(int acresPlanted) {
        acresPlanted = game.calculateAcresToPlant(acresPlanted, state.getLandsOwned(), state.getPopulation(), state.getBushels());

        state.changeBushels(-acresPlanted);
        state.changeBushels(game.harvest(acresPlanted));

        console.prompt(state.getBushels(), state.getPopulation(), state.getLandsOwned());
    }

    public void badEnding() { //<- Newly added
        if ((double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 >= 10 && (double)state.getLandsOwned() / state.getPopulation() <= 9 ||
            (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 >= 10 && (double)state.getLandsOwned() / state.getPopulation() > 9 ||
            (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 < 10 && (double)state.getLandsOwned() / state.getPopulation() <= 9) {

            console.guts();
        }
    }

    public void normalEnding() { //<-Newly added
        if ((double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 < 10 && (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 >= 3 &&
            (double)state.getLandsOwned() / state.getPopulation() > 9 && (double)state.getLandsOwned() / state.getPopulation() <= 10 ||
            (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 < 10 && (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 >= 3 &&
            (double)state.getLandsOwned() / state.getPopulation() > 9 ||
            (double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 < 3 &&
            (double)state.getLandsOwned() / state.getPopulation() > 9 && (double)state.getLandsOwned() / state.getPopulation() <= 10) {

            console.boring();
        }
    }

    public void goodEnding() { //<-Newly added
        if ((double)state.getsDeathsPool() / (100 + state.getImmigrantsPool()) * 100 < 3 && (double)state.getLandsOwned() / state.getPopulation() > 10) {

            console.thriving();

        }
    }

}