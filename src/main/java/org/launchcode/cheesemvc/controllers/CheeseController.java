package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.Rating;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("cheese")
public class CheeseController {


    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseType", CheeseType.values());
        model.addAttribute("ratingOptions", Rating.values());
        return "cheese/add";

    }

    @RequestMapping(value = "add", method  = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseType", CheeseType.values());
            model.addAttribute("ratingOptions", Rating.values());
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method  = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

            for (int cheeseId : cheeseIds) {
                CheeseData.remove(cheeseId);
            }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("cheeseType", CheeseType.values());
        model.addAttribute("ratingOptions", Rating.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, @ModelAttribute @Valid Cheese cheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseType", CheeseType.values());
            model.addAttribute("ratingOptions", Rating.values());
            model.addAttribute("cheese", cheese);
            return "cheese/edit";
        }

        Cheese c = CheeseData.getById(cheeseId);
        CheeseData.getAll().set(CheeseData.getAll().indexOf(c), cheese);

        return "redirect:";
    }

}