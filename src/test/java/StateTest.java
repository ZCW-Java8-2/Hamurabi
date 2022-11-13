import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    GameEngine game = new GameEngine();

    @BeforeEach
    public void setUp() {
        State state = new State(100, 1000, 3000, 0, 19);
    }

    @Test
    void getPopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 100;
        int actual = state.getPopulation();
        assertEquals(expected, actual);
    }

    @Test
    void setPopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 200;
        state.setPopulation(200);
        int actual = state.getPopulation();
        assertEquals(expected, actual);
    }

    @Test
    void changePopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 50;
        state.changePopulation(-50);
        int actual = state.getPopulation();
        assertEquals(expected, actual);
    }

    @Test
    void getLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 1000;
        int actual = state.getLandsOwned();
        assertEquals(expected, actual);
    }

    @Test
    void setLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 2000;
        state.setLandsOwned(2000);
        int actual = state.getLandsOwned();
        assertEquals(expected, actual);
    }

    @Test
    void changeLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 900;
        state.changeLandsOwned(-100);
        int actual = state.getLandsOwned();
        assertEquals(expected, actual);
    }
    @Test
    public final void testNewCostOfLand() {
        State state = new State(100, 1000, 3000, 0, 19);
        int[] cost = new int[24];
        for (int i = 0; i < 1000; i++) {
            int price = state.newCostOfLand();
            assertTrue("Illegal cost of land: " + price, price >= 17 && price <= 23);
            cost[price] += 1;
        }
        for (int j = 17; j <= 23; j++) {
            assertTrue("You never have a land cost of " + j + " bushels per acre.", cost[j] > 0);
        }
    }
    @Test
    void getBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 3000;
        int actual = state.getBushels();
        assertEquals(expected, actual);
    }

    @Test
    void setBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 5000;
        state.setBushels(5000);
        int actual = state.getBushels();
        assertEquals(expected, actual);
    }

    @Test
    void changeBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 2900;
        state.changeBushels(-100);
        int actual = state.getBushels();
        assertEquals(expected, actual);
    }

    @Test
    void getPriceTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 19;
        int actual = state.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void setPriceTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 23;
        state.setPrice(23);
        int actual = state.getPrice();
        assertEquals(expected, actual);
    }
    @Test
    void getYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 0;
        int actual = state.getYear();
        assertEquals(expected, actual);
    }

    @Test
    void setYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 5;
        state.setYear(5);
        int actual = state.getYear();
        assertEquals(expected, actual);
    }

    @Test
    void incrementYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 1;
        state.incrementYear();
        int actual = state.getYear();
        assertEquals(expected, actual);
    }
    @Test
    void getpDeathsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setpDeaths(game.plagueDeaths(state.getPopulation()));
        assertTrue("Plague deaths are: " + state.getpDeaths(),
                state.getpDeaths() == 50 || state.getpDeaths() == 0);
    }
    @Test
    void setpDeathsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setpDeaths(50);
        assertEquals(50, state.getpDeaths());
    }
    @Test
    void getsDeathsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setsDeaths(game.starvationDeaths(state.getPopulation(), 1200));
        int expected = state.getsDeaths();
        assertEquals(40, expected);
    }
    @Test
    void setsDeathsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setsDeaths(40);
        assertEquals(40, state.getsDeaths());
    }

    @Test
    void getImmigrantsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setImmigrants(game.immigrants(state.getPopulation(), state.getLandsOwned(), state.getBushels(), 2000));
        assertEquals(3, state.getImmigrants());
    }
    @Test
    void setImmigrantsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setImmigrants(3);
        assertEquals(3, state.getImmigrants());
    }
    @Test
    void getHarvestTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setHarvest(800);
        assertEquals(800, state.getHarvest());
    }
    @Test
    void setHarvestTest() {
        State state = new State(100, 1000, 3000, 0, 19);
    }
    @Test
    void getRats() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setRats(game.grainEatenByRats(state.getBushels()));
        assertTrue("Infestation: " + state.getRats(),
                state.getRats() == 0 || state.getRats() <= 900 && state.getRats() >= 300);
    }
    @Test
    void setRats() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setRats(300);
        assertEquals(300, state.getRats());
    }
    @Test
    void getsDeathsPool() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setsDeathsPool(state.getsDeathsPool() + state.getsDeaths());
        assertEquals(0, state.getsDeathsPool());
    }
    @Test
    void setsDeathsPool() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setsDeathsPool(10);
        assertEquals(10, state.getsDeathsPool());
    }
    @Test
    void getImmigrantsPoolTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setImmigrantsPool(state.getImmigrantsPool() + state.getImmigrants());
        assertEquals(0, state.getImmigrantsPool());
    }
    @Test
    void setImmigrantsPoolTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        state.setImmigrantsPool(5);
        assertEquals(5, state.getImmigrantsPool());
    }

}