/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrototypePattern;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Google extends phone {

    private String brand;
    private String model;
    private Color color;
    private int storage;
    private int ram;
    private double displaysize;
    private double camera;
    private double price;
    private boolean waterproof;

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the storage
     */
    public int getStorage() {
        return storage;
    }

    /**
     * @param storage the storage to set
     */
    public void setStorage(int storage) {
        this.storage = storage;
    }

    /**
     * @return the ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * @return the displaySize
     */
    public double getDisplaySize() {
        return displaysize;
    }

    /**
     * @param displaysize the displaySize to set
     */
    public void setDisplaysize(double displaysize) {
        this.displaysize = displaysize;
    }

    /**
     * @return the camera
     */
    public double getCamera() {
        return camera;
    }

    /**
     * @param camera the camera to set
     */
    public void setCamera(double camera) {
        this.camera = camera;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the waterproof
     */
    public boolean isWaterproof() {
        return waterproof;
    }

    /**
     * @param waterproof the waterproof to set
     */
    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    @Override
    void selected() {
        JOptionPane.showMessageDialog(null, "New Google Phone Prototype Cloning in Progress!");
    }

}
