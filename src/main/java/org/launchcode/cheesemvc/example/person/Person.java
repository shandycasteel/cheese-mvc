package org.launchcode.cheesemvc.example.person;

public abstract class Person {
    public abstract int getAge();
    public abstract String getName();

    public void speak(){
        System.out.println(String.format("Hello! My name is %s. I am %d years or maybe just year old", getName() ,getAge()));
    }
}
