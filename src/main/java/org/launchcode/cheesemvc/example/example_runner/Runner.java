package org.launchcode.cheesemvc.example.example_runner;

import org.launchcode.cheesemvc.example.dad.Dad;
import org.launchcode.cheesemvc.example.grandson.GrandSon;
import org.launchcode.cheesemvc.example.person.Person;
import org.launchcode.cheesemvc.example.son.Son;

public class Runner {
    public static void main(String[] asdflkjalsdkjflksdjfjalskdf) {
        Person dad = new Dad();

        Person son = new Son();

        dad.speak();
        son.speak();

        Person grandson = new GrandSon();
        grandson.speak();
        Son grandsonner = new GrandSon();
        grandsonner.printHidden();

        Person person =  new Person() {
            @Override
            public int getAge() {
                return 350;
            }

            @Override
            public String getName() {
                return "Anonymous";
            }
        };
        person.speak();
    }
}
