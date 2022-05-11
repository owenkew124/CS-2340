package com.example.demo;
import javafx.scene.control.Button;
import java.util.ArrayList;

/**
 * Abstract Tower clas s to parent differant types of tower.
 * @author Andrew J. Dowdy
 * @version 1.0.0
 */
public class Tower extends TileObject {
    /**
     * Constructor for tower.
     * @param location button location of tower
     * @param type the type of tower being constructed
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param targets the targets of the tower
     */
    public Tower(Button location, int x, int y, String type, ArrayList<TileObject> targets) {
        super(location, type, x, y);
        String oldURL = this.image.getUrl();
        String startURL = oldURL.substring(0, (oldURL.length() - ("EmptySlot.png").length()));
        this.setImage(startURL, type + ".png");
        this.targets = targets;
        this.level = 0;
    }

    /**
     * The level of the tower.
     */
    protected int level;

    /**
     * A getter for level
     * @return level of the tower
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Target array.
     */
    protected ArrayList<TileObject> targets;

    /**
     * Array of target coordinates
     */
    protected ArrayList<int[]> targetCoordinates;

    /**
     * Method to upgrade tower. Feature not yet implemented.
     */
    public void upgradeTower() {
        if (this.level < 2) {
            System.out.println("User attempting to upgrade level " + level + " " + type);
            if (GameApplication.getMoney() >= GameApplication.getPrice()) {
                //System.out.println("User can afford the upgrade");
                this.level += 1;
                this.updateType(this.type.substring(0, (this.type.length() - 1)) + this.level);
                GameApplication.gainMoney((-1 * GameApplication.getPrice()));
                //System.out.println("Tower upgraded to level " + level);
            }
        }
    }

    /**
     * Fires tower weapon.
     */
    public void fire() {
        //System.out.println("Tower firing");
        for (TileObject item : targets) {
            if (item.type.contains("enemy") || item.type.contains("boss")) {
                //System.out.println("Target aquired at "+item.getX()+","+item.getY());
                GameApplication.interact(this, item);
            }
        }
    }
}
