package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Map {
    /**
     * Button locations of all objects on the path.
     */
    private static Button[] pathLocations;

    /**
     * Final list of path locations.
     */
    private static int[][] pathi = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1},
        {7, 1}, {7, 2}, {7, 3}, {6, 3}, {5, 3}, {4, 3}, {3, 3},
        {2, 3}, {1, 3}, {1, 4}, {1, 5}, {2, 5}, {3, 5}, {4, 5},
        {5, 5}, {6, 5}, {7, 5}, {7, 6}};

    /**
     * Returns path locations
     * @return path locations
     */
    public static int[][] getPathi() {
        return pathi;
    }

    /**
     * Length of the game path.
     */
    private static final int PATHLENGTH = 25;

    public static int getPathLength() {
        return PATHLENGTH;
    }
    /**
     * List of all path objects (in order).
     */
    private static TileObject[] path;

    /**
     * 2D array of all objects on the map.
     */
    private static TileObject[][] map;

    /**
     * Map of enemy locations
     */
    private static Enemy[][] enemyMap;

    /**
     * Map of towers
     */
    private static Tower[][] towerMap;

    /**
     * A constructor for the map class.
     * @param fxmlLoader the game ui fxmlloader
     */
    public Map(FXMLLoader fxmlLoader) {
        setupMap(fxmlLoader);
        setupPath();
    }

    /**
     * Method to set up the game path.
     */
    private void setupPath() {
        int i = 0;
        path = new TileObject[PATHLENGTH];
        pathLocations = new Button[PATHLENGTH];
        for (int[] pair : pathi) {
            TileObject t = map[pair[0]][pair[1]];
            t.setType("map");
            pathLocations[i] = t.getLocation();
            path[i] = t;
            i++;
        }
    }

    /**
     * Method to setup game map.
     * @param fxmlLoader the game UI fxmlloader
     */
    private void setupMap(FXMLLoader fxmlLoader) {
        map = new TileObject[9][7];
        towerMap = new Tower[9][7];
        // setup map
        String id;
        for (Integer x = 0; x < 9; x++) {
            for (Integer y = 0; y < 7; y++) {
                id = y.toString() + x.toString();
                //System.out.println("Attempting to aquire "+id);
                Button b = (Button) fxmlLoader.getNamespace().get(id);
                map[x][y] = new TileObject(b, "empty", x, y);
            }
        }
        enemyMap = new Enemy[9][7];
        setupPath();
    }

    /**
     * A method to move an enemy along the path.
     * @param enemy the enemy to move.
     */
    public void moveEnemy(Enemy enemy) {
        path[enemy.getPathLocation()].updateType("map");
        enemyMap[enemy.getX()][enemy.getY()] = null;
        enemy.setPathLocation(enemy.getPathLocation() + 1);
        enemy.setCoordinates(pathi[enemy.getPathLocation()]);
        path[enemy.getPathLocation()].updateType(enemy.getType());
        enemyMap[enemy.getX()][enemy.getY()] = enemy;
    }

    /**
     * A getter method for buttons on the path
     * @param i index to grab location at
     * @return button location at index
     */
    public Button getLocation(int i) {
        return pathLocations[i];
    }

    public TileObject getPathTile(int i) {
        return path[i];
    }

    public Tower getTower(int x, int y) {
        return towerMap[x][y];
    }

    /**
     * Adds an enemy to the map
     * @param enemy enemy to be added to the map
     */
    public void addEnemy(Enemy enemy) {
        enemyMap[0][1] = enemy;
    }

    /**
     * Method to find the targets of a specific tower.
     * @param x x coordinate of tower
     * @param y y coordinate of tower
     * @return a target list for the tower
     */
    public ArrayList<TileObject> getTargets(int x, int y) {
        int[][] adjacentTiles = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};
        ArrayList<TileObject> targetsList = new ArrayList<TileObject>();
        for (int[] tileID : adjacentTiles) {
            for (int[] pathID : pathi) {
                if ((pathID[0] == tileID[0]) && (pathID[1] == tileID[1])) {
                    targetsList.add(map[pathID[0]][pathID[1]]);
                }
            }
        }
        return targetsList;
    }

    /**
     * A method to add a tower to the map
     * @param tower the tower to be added
     */
    public void addTower(Tower tower) {
        towerMap[tower.getX()][tower.getY()] = tower;
    }
}
