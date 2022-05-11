package com.example.demo;

import javafx.animation.AnimationTimer;

public class Combat extends AnimationTimer {
    /**
     * Application owning Combat class.
     */
    private GameApplication application;

    /**
     * Interval at which player gains money
     */
    private int moneyInterval;

    /**
     * Interval at which towers fire.
     */
    private int towersInterval;

    /**
     * Interval at which enemies move.
     */
    private int enemiesInterval;

    /**
     * Interval at which new enemies are created.
     */
    private int newEnemyInterval;

    /**
     * How long it takes before the final boss arrives.
     */
    private int finalBossTime;

    /**
     * Returns interval at which player gains money
     * @return interval at which player gains money
     */
    public int getMoneyInterval() {
        return moneyInterval;
    }

    /**
     * Returns interval at which towers fire
     * @return interval at which towers fire
     */
    public int getTowersInterval() {
        return towersInterval;
    }

    /**
     * Returns interval at which enemies move
     * @return interval at which enemies move
     */
    public int getEnemiesInterval() {
        return enemiesInterval;
    }

    /**
     * Returns interval at which new enemies are created
     * @return interval at which new enemies are created
     */
    public int getNewEnemyInterval() {
        return newEnemyInterval;
    }

    /**
     * Returns time at which final boss should be created
     * @return time at which final boss should be created
     */
    public int getFinalBossTime() {
        return finalBossTime;
    }

    /**
     * Handles main scene interactions regularly.
     * @param sceneTime current time elapsed of scene
     */
    public void handle(long sceneTime) {
        if ((sceneTime % moneyInterval) == 0) {
            // add money
            application.incrementMoney();
        }
        if ((sceneTime % towersInterval) == 0) {
            // fire towers
            application.fireTowers();
        }
        if ((sceneTime % enemiesInterval) == 0) {
            // move enemies and damage monument
            try {
                application.processEnemies();
                // check for endgame
                application.checkEndgame();
            } catch (java.io.IOException e) {
                System.out.println("IO issues in main loop");
            }
        }
        if (((sceneTime % finalBossTime) == 0) && (sceneTime > newEnemyInterval)) {
            // add a new enemy
            application.finalBoss();
        } else if ((sceneTime % newEnemyInterval) == 0) {
            // add a new enemy
            application.newEnemy();
        }
    }

    /**
     * Constructor for combat class.
     * @param application owner application
     * @param moneyInterval interval at which player gains money
     * @param towersInterval interval at which towers fire
     * @param enemiesInterval interval at which enemies move
     * @param newEnemyInterval interval at which new enemies are created
     * @param newFinalBossTime time at which final boss is created
     */
    public Combat(GameApplication application, int moneyInterval, int towersInterval,
                  int enemiesInterval, int newEnemyInterval, int newFinalBossTime) {
        super();
        this.moneyInterval = moneyInterval;
        this.towersInterval = towersInterval;
        this.enemiesInterval = enemiesInterval;
        this.newEnemyInterval = newEnemyInterval;
        this.finalBossTime = newFinalBossTime;
        this.application = application;
    }
}
