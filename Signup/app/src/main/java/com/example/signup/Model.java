package com.example.signup;

public class Model {
    private int image;
    private String title;
    private String desc;

    public Model(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
