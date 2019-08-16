package org.launchcode.cheesemvc.controllers;
import org.launchcode.cheesemvc.models.Cheese;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }

    @RequestMapping(value = "add", method  = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam  String  cheeseName, @RequestParam String cheeseDescription) {

        Cheese newCheese = new Cheese(cheeseName, cheeseDescription);

        cheeses.add(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method  = RequestMethod.GET)
    public String removeCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);

        // Redirect to /cheese
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method  = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> removeList) {

        for(int i = 0; i < removeList.size(); i++) {
            cheeses.remove(i);
        }

        // Redirect to /cheese
        return "redirect:";
    }
}