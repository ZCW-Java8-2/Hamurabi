import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @BeforeEach
    public void setUp() {
        State state = new State(100, 1000, 3000, 0, 19);
    }

    @Test
    void getPopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 100;
        int actual = state.getPopulation();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setPopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 200;
        state.setPopulation(200);
        int actual = state.getPopulation();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void changePopulationTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 50;
        state.changePopulation(-50);
        int actual = state.getPopulation();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 1000;
        int actual = state.getLandsOwned();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 2000;
        state.setLandsOwned(2000);
        int actual = state.getLandsOwned();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void changeLandsOwnedTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 900;
        state.changeLandsOwned(-100);
        int actual = state.getLandsOwned();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 3000;
        int actual = state.getBushels();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 5000;
        state.setBushels(5000);
        int actual = state.getBushels();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void changeBushelsTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 2900;
        state.changeBushels(-100);
        int actual = state.getBushels();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getPriceTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 19;
        int actual = state.getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setPriceTest() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 23;
        state.setPrice(23);
        int actual = state.getPrice();
        Assert.assertEquals(expected, actual);
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
    void getYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 0;
        int actual = state.getYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 5;
        state.setYear(5);
        int actual = state.getYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void incrementYear() {
        State state = new State(100, 1000, 3000, 0, 19);
        int expected = 1;
        state.incrementYear();
        int actual = state.getYear();
        Assert.assertEquals(expected, actual);
    }
}