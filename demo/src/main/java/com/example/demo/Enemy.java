package com.example.demo;

import javafx.scene.control.Button;

import java.io.IOException;

public class Enemy extends TileObject {
    /**
     * Integer index on the path.
     */
    protected int pathLocation;

    /**
     * Location of enemy in enemyList.
     */
    protected int listLocation;

    /**
     * Amount of health the enemy has.
     */
    protected int health;

    /**
     * Type of enemy.
     */
    protected String classification;

    /**
     * An int tracking how much total damage has been dealt to enemies.
     */
    private static int totalDamage = 0;

    /**
     * A getter for total damage.
     * @return total damage
     */
    public static int getDamage() {
        return totalDamage;
    }

    /**
     * Getter for list location.
     * @return list location
     */
    public int getListLocation() {
        return this.listLocation;
    }

    /**
     * Gets location on the path.
     * @return location on the path
     */
    public int getPathLocation() {
        return this.pathLocation;
    }

    /**
     * Setter for location.
     * @param newLocation new path location
     */
    public void setPathLocation(int newLocation) {
        this.pathLocation = newLocation;
    }

    /**
     * Constructor for enemy.
     * @param location button location of enemy
     * @param type the type of tower being constructed
     * @param pathLocation the location of the enemy on the path
     * @param listLocation the location of the enemy in the list of enemies
     */
    public Enemy(Button location, String type, int pathLocation, int listLocation) {
        super(location, type, pathLocation, 1);
        String oldURL = this.image.getUrl();
        String startURL = oldURL.substring(0, (oldURL.length() - ("map.png").length()));
        this.setImage(startURL, type + ".png");
        this.listLocation = listLocation;
        this.pathLocation = pathLocation;
        if (type == "boss") {
            this.health = 45;
            this.classification = "F";
        } else {
            this.classification = "G";
            this.health = 9;
        }
    }

    /**
     * A getter for classification.
     * @return enemy classification
     */
    public String getClassification() {
        return this.classification;
    }

    /**
     * Method to inflict damage on the relevant enemy.
     * @param damage amount of damage
     */
    public void takeDamage(int damage) {
        System.out.println("Enemy #" + this.getListLocation() + "("
                + classification + ")hit for " + damage + " damage");
        GameApplication.updateEnemyHealthString();
        health -= damage;
        totalDamage += damage;
        if (health <= 0) {
            GameApplication.deleteEnemy(this);
            if (this.type.equals("boss")) {
                try {
                    GameApplication.winGame();
                } catch (IOException i) {

                }
            }
        }
    }

    public void hitByTower(Tower tower) {
        String tType = tower.getType();
        String eType = this.type;
        if (tType.contains("PaperTower")) {
            GameApplication.gainMoney(1 + tower.getLevel());
        } else {
            if (tType.contains("FireTower")) {
                if (eType.equals("enemySnake")) {
                    takeDamage(2 + tower.getLevel());
                } else if (eType.equals("enemyGoblin")) {
                    takeDamage(1 + tower.getLevel());
                } else if (eType.equals("enemyDevil")) {
                    takeDamage(0 + tower.getLevel());
                } else {
                    takeDamage(1 + tower.getLevel());
                }
            } else if (tType.contains("RockTower")) {
                if (eType == "enemySnake") {
                    takeDamage(0 + tower.getLevel());
                } else if (eType.equals("enemyGoblin")) {
                    takeDamage(2 + tower.getLevel());
                } else if (eType.equals("enemyDevil")) {
                    takeDamage(1 + tower.getLevel());
                } else {
                    takeDamage(1 + tower.getLevel());
                }
            } else if (tType.contains("IceTower")) {
                if (eType == "enemySnake") {
                    takeDamage(1 + tower.getLevel());
                } else if (eType.equals("enemyGoblin")) {
                    takeDamage(0 + tower.getLevel());
                } else if (eType.equals("enemyDevil")) {
                    takeDamage(2 + tower.getLevel());
                } else {
                    takeDamage(1 + tower.getLevel());
                }
            }
        }
    }
}
