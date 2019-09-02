package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "", method  = RequestMethod.GET)
    public String index(Model model) {

            model.addAttribute("users", UserData.getAll());
            model.addAttribute("title", "Users");
            return "user/index";
    }

    @RequestMapping(value = "{id}", method  = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") int id) {
        model.addAttribute("title", "User Profile");
        User user = UserData.getById(id);
        model.addAttribute("user", user);
        return "user/user-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return "user/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute @Valid User newUser, Errors errors) {

        model.addAttribute("user", newUser);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add";
        }

        UserData.add(newUser);
        return "redirect:";
    }

}
