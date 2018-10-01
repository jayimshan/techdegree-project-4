package com.affogatostudios.whichanimalareyou.model;

public class Animal {

    private int imageId;
    private String animal;

    public Animal(int imageId, String animal) {
        this.imageId = imageId;
        this.animal = animal;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAnimalName() {
        return animal;
    }
}
