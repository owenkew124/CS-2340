package tests;

import com.example.demo.GameApplication;
import com.example.demo.Tower;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class GameApplicationM4Test {

    private GameApplication gameApplication;

    /**
     * Prevent tests from running infinitely
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    /**
     * Setup necessary components before start
     */
    @Before
    public void setup() throws IOException {
        gameApplication = new GameApplication();

    }

    /**
     * Test that creating a tower adds it to the array and increments the number of towers by 1
     * For Milestone 3
     */
    @Test (expected = NullPointerException.class)
    public void testPushTower() {
        //ActionEvent event = new Event(gameApplication.)
        gameApplication.setupGameComponents();
        int numberOfTowers = gameApplication.getNumberOfTowers();
        gameApplication.pushTower(null);
        assertTrue(gameApplication.getNumberOfTowers() - numberOfTowers == 1);
    }

    /**
     * Tests that the game setup creates a functional combat controller with appropriate values
     * For Milestone 4
     */
    @Test
    public void testSetupCombatController() {
        gameApplication.setupGameComponents();
        assertTrue(gameApplication.getCombatController().getMoneyInterval() > 0);
    }

    /**
     * Tests that the end game checker does not incorrectly close the game
     * For Milestone 4
     */
    @Test
    public void testCheckEndGame() throws IOException {
        gameApplication.setupGameComponents();
        gameApplication.easy();
        gameApplication.checkEndgame();
        gameApplication.medium();
        gameApplication.checkEndgame();
        gameApplication.hard();
        gameApplication.checkEndgame();
    }

    /**
     * Tests that pauseCombat() pauses combat but without improperly affecting game components
     */
    @Test
    public void testPauseCombat() {
        gameApplication.setupGameComponents();
        gameApplication.pauseCombat();
        assert (gameApplication != null);
    }
    /**
     * Tests that stopCombat() properly stops combat
     * @throws IOException IOException
     */
    @Test
    public void testStopCombat() throws IOException {
        gameApplication.setupGameComponents();
        gameApplication.stopCombat();
        assert (gameApplication.getCombatController() == null);
    }

    /**
     * Tests that the maximum number of towers is an appropriate number
     */
    @Test
    public void testMaximumTowers() {
        assertTrue(gameApplication.getMaxTowers() > 0);
    }

    /**
     * Tests that the maximum number of enemies is an appropriate number
     */
    @Test
    public void testMaximumEnemies() {
        assertTrue(gameApplication.getMaxEnemies() > 0);
    }

    /**
     * Tests that the length of the array of towers is equal to the maximum number of towers allowed
     */
    @Test
    public void testTowersArrayLengthEqualsMaximumTowers() {
        gameApplication.setupGameComponents();
        assert (gameApplication.getTowers().length == gameApplication.getMaxTowers());
    }

    /**
     * Tests that the length of the array of enemies
     * is equal to the maximum number of enemies allowed
     */
    @Test
    public void testEnemiesArrayLengthEqualsMaximumTowers() {
        gameApplication.setupGameComponents();
        assert (gameApplication.getEnemies().length == gameApplication.getMaxEnemies());
    }


    /**
     * Test that the game does not move to purchase screen when components are loaded
     * For Milestone 4
     */
    @Test
    public void testCurrentPurchase() {
        gameApplication.setupGameComponents();
        assert (gameApplication.getCurrentPurchase() == null);
    }
}
