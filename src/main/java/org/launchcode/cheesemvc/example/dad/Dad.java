package org.launchcode.cheesemvc.example.dad;

import org.launchcode.cheesemvc.example.person.Person;

public class Dad extends Person {
    private String name = "John";
    private int age = 60;

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    protected void printIamProtected() {
        System.out.println(String.format("I am %s and I am protected!", getName()));
    }

}
