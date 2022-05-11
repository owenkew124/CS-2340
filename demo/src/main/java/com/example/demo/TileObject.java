package com.example.demo;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileObject {
    /**
     * Location.
     */
    protected Button location;

    /**
     * Getter for location.
     * @return the button object the tile object is located at
     */
    public Button getLocation() {
        return this.location;
    }

    /**
     * Setter for button location.
     * @param newLocation new button location
     */
    public void setLocation(Button newLocation) {
        this.location = newLocation;
    }

    /**
     * Node for image.
     */
    protected ImageView imageNode;

    /**
     * Image.
     */
    protected Image image;

    /**
     * Getter for image node.
     * @return the Node for the image
     */
    public ImageView getImage() {
        return this.imageNode;
    }

    /**
     * String holding the type.
     */
    protected String type;

    /**
     * X coordinate of the object.
     */
    protected int x;

    /**
     * Y coordinate of the object.
     */
    protected int y;

    /**
     * A setter for image node.
     * @param url the image url to replace the old one
     * @param startURL image folder url start
     */
    protected void setImage(String startURL, String url) {
        this.image = new Image(startURL + url);
        this.imageNode.setImage(this.image);
        this.location.setGraphic(this.imageNode);
    }

    /**
     * Returns the type of the TileObject.
     * @return string type of tile object.
     */
    protected String getType() {
        return this.type;
    }

    /**
     * A setter for image node.
     * @param newType the new type of the image
     */
    protected void updateType(String newType) {
        String oldURL = this.image.getUrl();
        String oldCap = type + ".png";
        String startURL = oldURL.substring(0, (oldURL.length() - oldCap.length()));
        String pushURL = startURL + newType + ".png";
        //System.out.println("Old URL: " + oldURL);
        //System.out.println("Old Cap: " + oldCap);
        //System.out.println("Push URL: " + pushURL);
        this.image = new Image(pushURL);
        this.imageNode.setImage(this.image);
        this.location.setGraphic(this.imageNode);
        this.type = newType;
    }

    /**
     * Constructor for tileobject.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param location button location of tower
     * @param type the type of tower being constructed
     */
    public TileObject(Button location, String type, int x, int y) {
        this.location = location;
        this.imageNode = (ImageView) location.getGraphic();
        this.image = imageNode.getImage();
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the coordinates of a tile object.
     * @param coords the objects coordinates as a 2 element array
     */
    public void setCoordinates(int[] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    /**
     * Returns tile object coordiantes.
     * @return tile object coordinate
     */
    public int[] getCoordinates() {
        return new int[] {x, y};
    }

    /**
     * Getter for x
     * @return x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for y
     * @return y coordinate
     */
    public int getY() {
        return this.y;
    }

    public boolean compareLocation(TileObject other) {
        //System.out.println("Comparing tilecoordinates for: ");
        //System.out.println("Tile 1 at "+this.getX()+","+this.getY());
        //System.out.println("Tile 1 at "+other.getX()+","+other.getY());
        return (this.x == other.getX()) && (this.y == other.getY());
    }

    /**
     * Changes the type of a tileobject.
     * @param newType new object type
     */
    public void setType(String newType) {
        this.type = newType;
    }
}
