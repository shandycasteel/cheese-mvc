package org.launchcode.cheesemvc.models;

public class Cheese {

    private String name;
    private String description;
    private int id;

    public Cheese() {

    }

    public Cheese(String aName, String aDescription) {

        this.name = aName;
        this.description = aDescription;
        this.id = id ++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

