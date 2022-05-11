package tests;

import com.example.demo.Combat;
import com.example.demo.Enemy;
import com.example.demo.GameApplication;
import com.example.demo.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

import static org.junit.Assert.assertFalse;


/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class GameApplicationM6Test {

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
     * Test that the final boss is not spawned when the game begins
     * For Milestone 6
     */
    @Test
    public void testFinalBossNullOnInitialization() {
        assert (gameApplication.getFinalBoss() == null);
    }

    /**
     * Test that if a boss is already spawned, then there is no attempt to spawn another
     * For Milestone 6
     */
    @Test
    public void testOnlyOneFinalBoss() {
        //ActionEvent event = new Event(gameApplication.)
        gameApplication.setIsFinalBossSpawned(true);
        gameApplication.finalBoss();
        assert (gameApplication.getFinalBoss() == null);
    }


    /**
     * Tests that a null tower is not fired
     * For Milestone 5
     */
    @Test
    public void testNoFinalBossUntilLessThanMaxEnemies() {
        gameApplication.setNumberOfEnemies(gameApplication.getMaxEnemies() + 1);
        gameApplication.finalBoss();
        assert (gameApplication.getFinalBoss() == null);
    }

    /**
     * Tests that the path length is equal to the number of path locations
     * For Milestone 4
     */
    @Test
    public void testPathLocationsEqualPathLength() {
        assert (Map.getPathi().length == Map.getPathLength());
    }

    /**
     * Tests that the program does not believe an enemy is spawned on start
     * For Milestone 6
     */
    @Test
    public void testFinalBossNotSpawned() {
        assertFalse(gameApplication.isFinalBossSpawned());
    }

    /**
     * Tests that there is at least path of 1
     * For Milestone 4
     */
    @Test
    public void testPathLocations() {
        assert (Map.getPathi().length > 0);
    }

    /**
     * Tests that the path is at least of length 1
     * For Milestone 4
     */
    @Test
    public void testPathLength() {
        assert (Map.getPathLength() > 0);
    }

    /**
     * Tests that enemies start with 0 damage
     * For Milestone 5
     */
    @Test
    public void testEnemyTotalDamageAtStart() {
        assert (Enemy.getDamage() == 0);
    }

    /**
     * Tests that the combat controller contains the time at which to create the final boss
     * For Milestone 6
     */
    @Test
    public void testCombatControllerFinalBossTime() {
        Combat combat = new Combat(gameApplication, 0, 0, 0,
                0, 100);
        assert (combat.getFinalBossTime() == 100);
    }

    /**
     * Tests that the combat controller attempts to create the final boss at the final boss time
     * For Milestone 6
     */
    @Test (expected = NullPointerException.class)
    public void testCombatControllerHandlesFinalBoss() {
        Combat combat = new Combat(gameApplication, 1, 1, 1,
                1, 100);
        combat.handle(100);

    }

}
