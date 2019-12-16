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

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser,
                      Errors errors) {

        model.addAttribute(newUser);

        if (errors.hasErrors()) {
            return "registration";

        }

        userDao.save(newUser);

        return "redirect:/homepage";
    }

    //-----------------ENDING CODE FOR USER REGISTRATION---------------




    //===============BEGINNING CODE FOR USER LOGIN=====================

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(Model model) {
        model.addAttribute("title", "Log In");
        /*model.addAttribute(new User());*/
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String username, @RequestParam String password) {

        //check if username is not emtpy
       //User user = userDao.findByUsername(username);
        //if (password.equals(user.getPassword()))
     // set cookie
     // redirect to home page
     return "home";
/* else {
     model.addAttribute("myerror", "Incorrect Login Info");
     //user.setPassword("");
     return "login";
 }*/
    }

    //---------------ENDING CODE FOR USER LOGIN---------------------

}
