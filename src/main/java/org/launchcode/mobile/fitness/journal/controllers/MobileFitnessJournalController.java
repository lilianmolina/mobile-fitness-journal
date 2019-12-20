package org.launchcode.mobile.fitness.journal.controllers;

import org.launchcode.mobile.fitness.journal.models.User;
import org.launchcode.mobile.fitness.journal.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "")
public class MobileFitnessJournalController {
    @Autowired
    private UserDao userDao;

    //===========THIS CODE DIRECTS TO HOMEPAGE===============
    @RequestMapping(value = "")
    public String index(Model model){

        return "homepage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "homepage")
    public String home(Model model) {
        return "homepage";
    }

    //---------------------------------------------------------

    //=================BEGINNING CODE FOR USER REGISTRATION================

    @RequestMapping(method = RequestMethod.GET, value = "registration")
    public String register(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Registration");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser,
                      Errors errors) {

        model.addAttribute(newUser);

        if (errors.hasErrors()) {
            return "registration";

        }

        userDao.save(newUser);

        return "login";
    }

    //-----------------ENDING CODE FOR USER REGISTRATION---------------




    //===============BEGINNING CODE FOR USER LOGIN=====================

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "User") User user, Model model, Errors errors) {
        String username = user.getUsername();
        String password = user.getPassword();

        User myFoundUser = userDao.findByUsername(username);
        if ( myFoundUser != null && password.equals(myFoundUser.getPassword())){
            return "redirect:/homepage";
        }
        if (errors.hasErrors()) {
            return "login";

        }
        model.addAttribute("invalidCredentials", true);
        return "login";

    }

    //---------------ENDING CODE FOR USER LOGIN---------------------

}