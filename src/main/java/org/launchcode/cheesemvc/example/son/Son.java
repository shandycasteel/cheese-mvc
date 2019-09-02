package org.launchcode.cheesemvc.example.son;

import org.launchcode.cheesemvc.example.dad.Dad;
import org.launchcode.cheesemvc.example.person.Person;

public class Son extends Dad {
    private String name = "Johnny";
    private int age = 12;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge(){
        return age;
    }

    String iamHidden() {
        return "I am hiden";
    }

    public void printHidden(){
        System.out.println("I am dad and " + iamHidden());
    }

}
