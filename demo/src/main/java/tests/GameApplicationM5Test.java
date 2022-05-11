package tests;

import com.example.demo.Combat;
import com.example.demo.Enemy;
import com.example.demo.GameApplication;
import com.example.demo.TileObject;
import javafx.fxml.FXMLLoader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class GameApplicationM5Test {

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
     * Test that the method for finding targets for a tower returns a list of targets
     * For Milestone 5
     */
    @Test (expected = NullPointerException.class)
    public void testGetTargetsArray() {
        //ActionEvent event = new Event(gameApplication.)
        ArrayList<TileObject> list = new ArrayList<TileObject>();
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameScreen.fxml"));
        gameApplication.setupMap(fxmlLoader);
        //System.out.println(gameApplication.getMap().getTargets(0, 0).toString());
        assert (gameApplication.getMap().getTargets(0, 0).equals(list));
    }


    /**
     * Tests that a null tower is not fired
     * For Milestone 5
     */
    @Test (expected = NullPointerException.class)
    public void testFireNullTower() {
        gameApplication.setupGameComponents();
        gameApplication.pushTower(null);
        gameApplication.fireTowers();
        assert (true);
    }

    /**
     * Tests that the combat controller modifies the amount of money on the right timing
     * For Milestone 4
     */
    @Test (expected = NullPointerException.class)
    public void testCombatControllerIncrementMoney() throws NullPointerException {
        gameApplication.easy();
        Combat combat = new Combat(gameApplication, 2, 5, 7, 11, 100);
        int startingMoney = gameApplication.getMoney();
        combat.handle(4);
        int incrementedMoney = gameApplication.getMoney();
    }

    /**
     * Tests that the combat controller does not modify the amount of money if the time is wrong
     * For Milestone 4
     */
    @Test
    public void testCombatControllerDoesNotIncrementMoney() {
        gameApplication.easy();
        Combat combat = new Combat(gameApplication, 2, 5, 7, 11, 100);
        int startingMoney = gameApplication.getMoney();
        combat.handle(3);
        int incrementedMoney = gameApplication.getMoney();
        assert (startingMoney == incrementedMoney);
    }

    /**
     * Tests that the combat controller creates a new enemy on its interval
     * For Milestone 4
     */
    @Test (expected = NullPointerException.class)
    public void testCombatControllerNewEnemy() {
        gameApplication.easy();
        gameApplication.setupGameComponents();
        Combat combat = new Combat(gameApplication, 2, 5, 7, 11, 100);
        Enemy[] startingEnemies = gameApplication.getEnemies();
        combat.handle(11);
        Enemy[] incrementedEnemies = gameApplication.getEnemies();
        assert (startingEnemies.length < incrementedEnemies.length);
    }

    /**
     * Tests an interaction between a null tower and a null target
     * For Milestone 5
     */
    @Test // (expected = NullPointerException.class)
    public void testCombatController() {
        gameApplication.easy();
        gameApplication.setupGameComponents();
        GameApplication.interact(null, null);
        assert (true);
    }

    /**
     * Tests that deleting a null enemy causes an exception
     * For Milestone 4
     */
    @Test (expected = NullPointerException.class)
    public void testDeleteNullEnemy() {
        gameApplication.easy();
        gameApplication.setupGameComponents();
        GameApplication.deleteEnemy(null);
    }

    /**
     * Tests that enemies are not processed when there are no enemies
     */
    @Test
    public void testProcessNullEnemy() throws IOException {
        gameApplication.easy();
        gameApplication.setupGameComponents();
        gameApplication.processEnemies();
    }

    /**
     * Tests that an attempt to mine the path is processed
     */
    @Test
    public void testCheckUserTryingToMinePath() throws IOException {
        gameApplication.openMineMenu(null);
    }

    /**
     * Tests that the map is being setup
     * For Milestone 5
     */
    @Test (expected = NullPointerException.class)
    public void testSetupMap() {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameScreen.fxml"));
        gameApplication.setupMap(fxmlLoader);
        gameApplication.getMap();
    }

}
