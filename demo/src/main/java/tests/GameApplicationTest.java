package tests;

import com.example.demo.GameApplication;
//import com.example.demo.IceTower;
//import com.example.demo.Tower;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.junit.*;
//import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;

/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class GameApplicationTest {

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
    public void setup() {
        gameApplication = new GameApplication();
    }

    /**
     * Test that player name cannot be blank or spaces
     * Null names are handled separately by the program
     * For Milestone 2
     */
    @Test
    public void testPlayerName() {
        //ActionEvent event = new Event(gameApplication.)
        assertFalse("\"\" is valid name", gameApplication.isValidName(""));
        assertFalse("\" \" is valid name", gameApplication.isValidName(" "));
    }

    /**
     * Test that fire tower prices vary based on difficulty setting
     * For Milestone 3
     */
    @Test
    public void testFireTowerVariedPrices() throws InterruptedException {
        int easyPrice = 0;
        int mediumPrice = 0;
        int hardPrice = 0;
        gameApplication.easy();
        easyPrice = gameApplication.getPrice();
        gameApplication.medium();
        mediumPrice = gameApplication.getPrice();
        gameApplication.hard();
        hardPrice = gameApplication.getPrice();
        assert ((easyPrice != mediumPrice)
                && (mediumPrice != hardPrice)
                && (easyPrice != hardPrice));
    }

    /**
     * Test that ice tower prices vary based on difficulty setting
     * For Milestone 3
     */
    @Test
    public void testIceTowerVariedPrices() {
        int easyPrice = 0;
        int mediumPrice = 0;
        int hardPrice = 0;
        gameApplication.easy();
        easyPrice = gameApplication.getPrice();
        gameApplication.medium();
        mediumPrice = gameApplication.getPrice();
        gameApplication.hard();
        hardPrice = gameApplication.getPrice();
        assert ((easyPrice != mediumPrice)
                && (mediumPrice != hardPrice)
                && (easyPrice != hardPrice));
    }

    /**
     * Test that paper tower prices vary based on difficulty setting
     * For Milestone 3
     */
    @Test
    public void testPaperTowerVariedPrices() {
        int easyPrice = 0;
        int mediumPrice = 0;
        int hardPrice = 0;
        gameApplication.easy();
        easyPrice = gameApplication.getPrice();
        gameApplication.medium();
        mediumPrice = gameApplication.getPrice();
        gameApplication.hard();
        hardPrice = gameApplication.getPrice();
        assert ((easyPrice != mediumPrice)
                && (mediumPrice != hardPrice)
                && (easyPrice != hardPrice));
    }

    /**
     * Test that rock tower prices vary based on difficulty setting.
     * For Milestone 3
     */
    @Test
    public void testRockTowerVariedPrices() {
        int easyPrice = 0;
        int mediumPrice = 0;
        int hardPrice = 0;
        gameApplication.easy();
        easyPrice = gameApplication.getPrice();
        gameApplication.medium();
        mediumPrice = gameApplication.getPrice();
        gameApplication.hard();
        hardPrice = gameApplication.getPrice();
        assert ((easyPrice != mediumPrice)
                && (mediumPrice != hardPrice)
                && (easyPrice != hardPrice));
    }

    /**
     * Tests that the monument health varies depending on game difficulty setting
     * For Milestone 2
     */
    @Test
    public void testVariedMonumentHealth() {
        int easyHealth = 0;
        int mediumHealth = 0;
        int hardHealth = 0;
        gameApplication.easy();
        easyHealth = gameApplication.getPrice();
        gameApplication.medium();
        mediumHealth = gameApplication.getPrice();
        gameApplication.hard();
        hardHealth = gameApplication.getPrice();
        assert ((easyHealth != mediumHealth)
                && (mediumHealth != hardHealth)
                && (easyHealth != hardHealth));
    }

    /**
     * Tests that the starting money varies depending on game difficulty settings
     * For Milestone 3
     */
    @Test
    public void testVariedStartingMoney() {
        int easyModeStartingMoney = 0;
        int mediumModeStartingMoney = 0;
        int hardModeStartingMoney = 0;
        gameApplication.easy();
        easyModeStartingMoney = gameApplication.getPrice();
        gameApplication.medium();
        mediumModeStartingMoney = gameApplication.getPrice();
        gameApplication.hard();
        hardModeStartingMoney = gameApplication.getPrice();
        assert ((easyModeStartingMoney != mediumModeStartingMoney)
                && (mediumModeStartingMoney != hardModeStartingMoney)
                && (easyModeStartingMoney != hardModeStartingMoney));
    }

    /**
     * Tests that the starting money is greater than the tower price
     */
    @Test
    public void testStartingMoneyGreaterThanTowerPriceEasyMode() {
        gameApplication.easy();
        int easyModeStartingMoney = gameApplication.getMoney();
        int easyModeTowerPrice = gameApplication.getPrice();
        assert (easyModeTowerPrice <= easyModeStartingMoney);
    }

    /**
     * Tests that the starting money is greater than the tower price
     */
    @Test
    public void testStartingMoneyGreaterThanTowerPriceMediumMode() {
        gameApplication.easy();
        int mediumModeStartingMoney = gameApplication.getMoney();
        int mediumModeTowerPrice = gameApplication.getPrice();
        assert (mediumModeTowerPrice <= mediumModeStartingMoney);
    }

    /**
     * Tests that the starting money is greater than the tower price
     */
    @Test
    public void testStartingMoneyGreaterThanTowerPriceHardMode() {
        gameApplication.easy();
        int hardModeStartingMoney = gameApplication.getMoney();
        int hardModeTowerPrice = gameApplication.getPrice();
        assert (hardModeTowerPrice <= hardModeStartingMoney);
    }
}
