package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.Node;
//import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.stage.Stage;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;

import java.io.IOException;
//import java.util.ArrayList;

/**
 * Game Application
 * @author Andrew J. Dowdy
 * @version 6
 */
public class GameApplication extends Application {
    /**
     * String to display enemy health
     */
    private static String enemyHealthString;

    /**
     * Returns enemy health string
     * @return enemy health string
     */
    public static String getEnemyHealthString() {
        return enemyHealthString;
    }
    /**
     * A boolean to record whether or not the final boss has spawned.
     */
    private static boolean finalBossSpawned;

    public static boolean isFinalBossSpawned() {
        return finalBossSpawned;
    }

    public static void setIsFinalBossSpawned(boolean isFinalBossSpawned) {
        finalBossSpawned = isFinalBossSpawned;
    }

    public static Enemy getFinalBoss() {
        return finalBoss;
    }

    /**
     * Final boss.
     */
    private static Enemy finalBoss;

    /**
     * A map keeping track of locations.
     */
    private static Map map;

    /**
     * A getter for map.
     * @return the map class of the game
     */
    public static Map getMap() {
        return map;
    }

    /**
     * Final variable for maximum number of enemies.
     */
    private static final int MAXENEMIES = 10;

    /**
     * Gets the maximum number of enemies
     * @return maximum number of enemies
     */
    public static int getMaxEnemies() {
        return MAXENEMIES;
    }

    /**
     * Combat animation timer.
     */
    private static Combat combatController;

    /**
     * Returns the combat controller
     * @return combat controller
     */
    public static Combat getCombatController() {
        return combatController;
    }

    /**
     * List of game enemies.
     */
    private static Enemy[] enemies;

    /**
     * Number of active enemies in the scene.
     */
    private static int numEnemies;

    /**
     * Get array of enemies
     * @return array of enemies
     */
    public static Enemy[] getEnemies() {
        return enemies;
    }

    /**
     * Get number of enemies
     * @return number of enemies
     */
    public static int getNumberOfEnemies() {
        return numEnemies;
    }

    /**
     * Set number of enemies
     * @param newNumEnemies new number of enemies
     */
    public static void setNumberOfEnemies(int newNumEnemies) {
        numEnemies = newNumEnemies;
    }
    /**
     * Money gain per cycle.
     */
    private static int moneyGain;

    /**
     * Boolean containing whether or not combat has started.
     */
    private static boolean combat;

    /**
     * Bucket for current fxmlloader.
     */
    private static FXMLLoader fxmlLoader;

    /**
     * Bucket for tower window fxmlloader.
     */
    private static FXMLLoader towerfxmlLoader;

    /**
     * Current button where purchase is operating.
     */
    private static Button currentPurchase;

    /**
     * Gets the current button where a purchase is occurring
     * @return current button where a purchase is occurring
     */
    public Button getCurrentPurchase() {
        return currentPurchase;
    }
    /**
     * Bucket for current scene.
     */
    private static Scene scene;

    /**
     * Bucket for tower scene.
     */
    private static Scene towerScene;

    /**
     * Window bucket.
     */
    private static Stage window;

    /**
     * Tower Menu Window Bucket.
     */
    private static Stage towerWindow;

    /**
     * Confirmed player name.
     */
    private static String playerName;

    /**
     * Present game difficulty.
     */
    private static int difficulty;

    /**
     * Money player has within game.
     */
    private static int playerMoney;

    /**
     * Returns player money.
     * @return money of player
     */
    public static int getMoney() {
        return playerMoney;
    }

    /**
     * Returns difficulty.
     * @return game difficulty.
     */
    public static int getDifficulty() {
        return difficulty;
    }

    /**
     * Health of the monument.
     */
    private static int monumentHealth;

    /**
     * Returns monument health.
     * @return monument health
     */
    public static int getHealth() {
        return monumentHealth;
    }

    /**
     * Price of all towers.
     */
    private static int towerPrice;

    /**
     * Gets the price of towers.
     * @return price of towers
     */
    public static int getPrice() {
        return towerPrice;
    }

    /**
     * All towers in operation.
     */
    private static Tower[] towers;

    /**
     * Gets the array of towers
     * @return array of towers
     */
    public static Tower[] getTowers() {
        return towers;
    }
    /**
     * Number of towers can sustain.
     */
    private static final int MAXTOWERS = 20;

    /**
     * Gets the maximum number of towers
     * @return maximum number of towers
     */
    public static int getMaxTowers() {
        return MAXTOWERS;
    }
    /**
     * Number tracking present number of towers.
     */
    private static int numTowers;

    /**
     * Gets the number of towers
     * @return number of towers
     */
    public static int getNumberOfTowers() {
        return numTowers;
    }

    /**
     * JavaFX start method
     * @param stage stage to be updated
     * @throws IOException exception in case of IO issues
     */
    @Override
    public void start(Stage stage) throws IOException {
        //https://www.google.com/search?channel=cus5&client=firefox-b-1-d&q=switch+fxml+files#kpvalbx=_S_MKYuH0Oo2m_Qbci5vgDQ54
        window = stage;
        fxmlLoader = new FXMLLoader(GameApplication.class.getResource("startScreen.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
        window.setTitle("Team Six Tower Defence Game!");
        window.setScene(scene);
        // System.out.println("Start method running with money at: " + playerMoney);
        window.show();
    }

    /**
     * Method to go to config from start state.
     * @param event event prompting move
     * @throws IOException exception in case of IO issues
     */
    @FXML
    public void goToConfig(ActionEvent event) throws IOException {
        // RQ - A way to "start the game" that moves to the initial configuration screen
        difficulty = 0;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(GameApplication.class.getResource("setupScreen.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
        window.setScene(scene);
    }

    /**
     * Main method to launch from.
     * @param args arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Method to quit the game.
     */
    @FXML
    public void quit() {
        // RQ - A way to "quit the game" that quits the game within the application
        System.out.println("Player quit with money:" + playerMoney);
        System.exit(0);
    }

    @FXML
    /**
     * Name field where user provides name in setup state.
     */
    protected TextField nameField;

    /**
     * Method to record player name input.
     *
     * @param event event prompting game to record name
     * @throws IOException excpetion thrown in case of IO
     */
    @FXML
    public void takeName(ActionEvent event) throws IOException {
        // RQ - An input for the character's name
        // save name
        String inputName = nameField.getText();
        // test is valid
        if (isValidName(inputName)) {
            // name is valid - save
            playerName = inputName;
            System.out.println("Player has given name as " + playerName);
        }
    }

    /**
     * Method to check that a player name is valid
     *
     * @param name name to check
     * @return valid boolean whether name is valid
     */
    public boolean isValidName(String name) {
        if (!name.equals("")) {
            boolean hasText = false;
            for (char ch : name.toCharArray()) {
                if (ch != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method that sets up game with difficulty to easy.
     */
    @FXML
    public void easy() {
        difficulty = 1;
        playerMoney = 50;
        monumentHealth = 20;
        towerPrice = 10;
    }

    /**
     * Method that sets up game with difficulty to medium.
     */
    @FXML
    public void medium() {
        difficulty = 2;
        playerMoney = 30;
        monumentHealth = 15;
        towerPrice = 20;
    }

    /**
     * Method that sets up game with difficulty to hard.
     */
    @FXML
    public void hard() {
        difficulty = 3;
        playerMoney = 10;
        monumentHealth = 10;
        towerPrice = 30;
    }

    /**
     * Method for when a user tries to "lock in" choices in the setup stage and move to the game.
     * @param event event coressponding to user attempt
     * @throws IOException exception thrown by IO issues
     */
    @FXML
    public void confirm(ActionEvent event) throws IOException {
        if ((playerName != null) && (difficulty != 0)) {
            goToGame(event);
        } else {
            // tell user they need to select a name and difficulty
            System.out.println("Please input a valid name and difficulty.");
        }
    }

    /**
     * Method to move from the setup state to the game state.
     * @param event the event prompting this move
     * @throws IOException in case of IO issues
     */
    public void goToGame(ActionEvent event) throws IOException {
        combat = false;
        moneyGain = 1;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameScreen.fxml"));
        fxmlLoader.getNamespace().put("playerMoney", playerMoney);
        fxmlLoader.getNamespace().put("monumentHealth", monumentHealth);
        scene = new Scene(fxmlLoader.load(), 1200, 800);
        window.setScene(scene);
        setupGameComponents();
        setupMap(fxmlLoader);
        updateEnemyHealthString();
    }

    /**
     * A method to setup the map class.
     */
    public void setupMap(FXMLLoader fxmlLoader) {
        this.map = new Map(fxmlLoader);
    }

    /**
     * Set-up game components
     */
    public void setupGameComponents() {
        towers = new Tower[MAXTOWERS];
        enemies = new Enemy[MAXENEMIES];
        numTowers = 0;
        finalBossSpawned = false;
        currentPurchase = null;
        // name and money are loaded to the scene but left unchanged
        // combat cycle setup
        combatController = new Combat(this, 6000, 2500, 8000, 50000, 1000000);
    }

    /**
     * Open tower purchase menu.
     * @param event event prompting open
     * @throws IOException in case of IO issue
     */
    @FXML
    public void openTowerMenu(ActionEvent event) throws IOException {
        // tower window is a seperate window the game window
        Button source = (Button) event.getSource();
        int id = Integer.parseInt(source.getId());
        int x = id % 10;
        int y = id / 10;
        Tower location = map.getTower(x, y);
        if (location == null) {
            if (currentPurchase == null) {
                currentPurchase = source;
                towerWindow = new Stage();
                towerfxmlLoader =
                        new FXMLLoader(GameApplication.class.getResource("buyTower.fxml"));
                towerfxmlLoader.getNamespace().put("playerMoney", playerMoney);
                towerScene = new Scene(towerfxmlLoader.load(), 600, 600);
                towerWindow.setScene(towerScene);
                towerWindow.show();
            } else {
                // change purchase target
                currentPurchase = source;
            }
        } else {
            location.upgradeTower();
        }
    }

    /**
     * Open mine purchase menu.
     * @param event event prompting open
     * @throws IOException in case of IO issue
     */
    @FXML
    public void openMineMenu(ActionEvent event) throws IOException {
        System.out.println("User attempting to mine the path");
    }

    /**
     * Closes tower purchase menu.
     * @param event event prompting close
     * @throws IOException in case of IO issue
     */
    @FXML
    public void closeTowerMenu(ActionEvent event) throws IOException {
        towerWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentPurchase = null;
        // update money on ui
        fxmlLoader.getNamespace().put("playerMoney", playerMoney);
        towerWindow.close();
    }

    /**
     * Buys a specific tower.
     * @param event event prompting method
     * @throws IOException throws IO exception in case of IO issues
     */
    @FXML
    public void buyTower(ActionEvent event) throws IOException {
        // determine what tower is being purchased
        Button source = (Button) event.getSource();
        String towerType = source.getText();
        int id = Integer.parseInt(currentPurchase.getId());
        int x = id % 10;
        int y = id / 10;
        /*
        System.out.println("x and y tower creation");
        System.out.println(id);
        System.out.println(x);
        System.out.println(y);
        */
        if (playerMoney >= towerPrice) {
            // subtract funds
            playerMoney -= towerPrice;
            // select tower
            Tower newTower;
            // make new tower using player input on tower location and type
            newTower = new Tower(currentPurchase, x, y, towerType, map.getTargets(x, y));
            // push tower to tower array
            pushTower(newTower);
            // after purchase is successfully complete close tower purchase menu
            closeTowerMenu(event);
        }
    }

    /**
     * Method that starts combat.
     * @param event event triggering
     * @throws InterruptedException interruptedException
     */
    @FXML
    public void startCombat(ActionEvent event) throws InterruptedException {
        if (!combat) {
            combat = true;
            combatController.start();
        }
    }

    /**
     * Method that pauses combat.
     */
    @FXML
    public void pauseCombat() {
        if (combat) {
            combat = false;
            combatController.stop();
        }
    }

    /**
     * Method that stops and resets combat.
     */
    @FXML
    public static void stopCombat() {
        combat = false;
        combatController.stop();
        map = null;
        combatController = null;
    }

    /**
     * Method to push a newly purchased tower to the tower array.
     * @param newTower tower to be pushed
     */
    public void pushTower(Tower newTower) {
        // add tower to array
        towers[numTowers] = newTower;
        map.addTower(newTower);
        numTowers += 1;
    }

    /**
     * Fire all towers in the class.
     */
    public void fireTowers() {
        //combatController.stop();
        for (Tower tower : towers) {
            if (tower != null) {
                tower.fire();
            }
        }
        //combatController.start();
    }

    /**
     * Checks for game over and acts accordingly.
     * @throws IOException in case of IO issues
     */
    public void checkEndgame() throws IOException {
        if (monumentHealth < 1) {
            endGame();
        }
    }

    /**
     * Increments player money each cycle.
     */
    public void incrementMoney() {
        gainMoney(moneyGain);
    }

    /**
     * A method to give the player a specific quantity of money.
     * @param amount the quantity of money
     */
    public static void gainMoney(int amount) {
        playerMoney += amount;
        fxmlLoader.getNamespace().put("playerMoney", playerMoney);
        if (currentPurchase != null) {
            towerfxmlLoader.getNamespace().put("playerMoney", playerMoney);
        }
    }

    /**
     * Processes scene enemies.
     * @throws IOException in case of IO issues
     */
    public void processEnemies() throws IOException {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                // move along path until monument
                if (enemy.getPathLocation() < 23) {
                    // move down path
                    map.moveEnemy(enemy);
                } else {
                    // hit monument - damage
                    if (enemy.getType().equals("boss")) {
                        damageMonument(20);
                    } else {
                        damageMonument(1);
                    }
                    deleteEnemy(enemy);
                }
            }
        }
    }

    /**
     * Adds a new enemy to the game.
     */
    public void newEnemy() {
        if (numEnemies < MAXENEMIES) {
            String type = "enemyGoblin";
            switch (numEnemies % 3) {
            case (0):
                type = "enemyGoblin";
                break;
            case (1):
                type = "enemySnake";
                break;
            case (2):
                type = "enemyDevil";
                break;
            default:
                break;
            }
            createEnemy(type);
        }
    }

    /**
     * A method to create an enemy according to a certain type.
     * @param type the type of enemy being created
     * @return null if maximum number has been created, else newly created enemy
     */
    public Enemy createEnemy(String type) {
        int i = 0;
        while (enemies[i] != null && i < MAXENEMIES) {
            i += 1;
        }
        if (i < MAXENEMIES) {
            map.addEnemy(enemies[i]);
            updateEnemyHealthString();
            enemies[i] = new Enemy(map.getLocation(0), type, 0, i);
            numEnemies += 1;
            updateEnemyHealthString();
            return enemies[i];
        } else {
            return null;
        }
    }

    /**
     * Deletes enemy.
     * @param enemy enemy to delete
     */
    public static void deleteEnemy(Enemy enemy) {
        if (enemy.getPathLocation() < 24) {
            map.getPathTile(enemy.getPathLocation()).updateType("map");
        }
        enemies[enemy.getListLocation()] = null;
        enemy = null;
        numEnemies -= 1;
        updateEnemyHealthString();
    }

    /**
     * Damages the monument by given amount.
     * @param amount amount of damage.
     * @throws IOException in case of IO issues
     */
    public static void damageMonument(int amount)  throws IOException {
        monumentHealth -= amount;
        if (monumentHealth > 0) {
            // update monument health on screen
            fxmlLoader.getNamespace().put("monumentHealth", monumentHealth);
        }
        // endgame processed after
    }

    /**
     * Ends the game.
     * @throws IOException in case of IO issues
     */
    public void endGame() throws IOException {
        stopCombat();
        // close tower purchase menu
        currentPurchase = null;
        if (towerWindow != null) {
            towerWindow.close();
        }
        // move game to endgame screen
        fxmlLoader = new FXMLLoader(GameApplication.class.getResource("endGame.fxml"));
        scene = new Scene(fxmlLoader.load(), 1200, 800);
        window.setScene(scene);
    }

    /**
     * Win the game.
     * @throws IOException in case of IO issues
     */
    public static void winGame() throws IOException {
        stopCombat();
        // close tower purchase menu
        currentPurchase = null;
        if (towerWindow != null) {
            towerWindow.close();
        }
        // move game to endgame screen
        fxmlLoader = new FXMLLoader(GameApplication.class.getResource("winGame.fxml"));
        fxmlLoader.getNamespace().put("playerMoney", playerMoney);
        fxmlLoader.getNamespace().put("monumentHealth", monumentHealth);
        fxmlLoader.getNamespace().put("totalDamage", Enemy.getDamage());
        scene = new Scene(fxmlLoader.load(), 1200, 800);
        window.setScene(scene);
    }

    /**
     * Method to process combat between a tower and a tile occupied by an enemy.
     * @param tower tower attacking enemy
     * @param enemyTile tile of enemy
     */
    public static void interact(Tower tower, TileObject enemyTile) {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                if (enemyTile.compareLocation(enemy)) {
                    enemy.hitByTower(tower);
                }
            }
        }
    }

    /**
     * Updates enemy health string
     */
    public static void updateEnemyHealthString() {
        String newString = "";
        int count = 0;
        for (Enemy enemy : enemies) {
            if (enemy == null) {
                newString += ("E" + count + ": N |");
            } else {
                newString += ("E" + count + "(" + enemy.getClassification() + "): "
                        + enemy.health + " |");
            }
            count += 1;
        }
        enemyHealthString = newString;
        fxmlLoader.getNamespace().put("enemyHealthString", enemyHealthString);
    }

    /**
     * Method to spawn the game final boss.
     */
    public void finalBoss() {
        if (numEnemies < MAXENEMIES && (!finalBossSpawned)) {
            finalBoss = createEnemy("boss");
            finalBossSpawned = true;
        }
    }
}
