package org.launchcode.cheesemvc.example.grandson;

import org.launchcode.cheesemvc.example.son.Son;

public class GrandSon extends Son {
    @Override
    public void speak() {
        System.out.println("I hate this family!");
    }

    @Override
    protected void printIamProtected() {
        System.out.println("aint gonna say is");
    }
}
