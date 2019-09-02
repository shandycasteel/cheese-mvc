package org.launchcode.cheesemvc.models;

public enum Rating {

    ONE (1, "*"),
    TWO (2, "**"),
    THREE (3, "***"),
    FOUR (4, "****"),
    FIVE (5, "*****");

    private final String stars;
    private final int number;

    Rating(int number, String stars) {

        this.stars = stars;
        this.number = number;
    }

    public String getStars() {
        return stars;
    }
    public int getNumber() {
        return number;
    }


}