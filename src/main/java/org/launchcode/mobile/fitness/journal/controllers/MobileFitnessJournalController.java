package org.launchcode.mobile.fitness.journal.controllers;

import org.launchcode.mobile.fitness.journal.models.User;
import org.launchcode.mobile.fitness.journal.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MobileFitnessJournalController {
    @Autowired
    private UserDao UserDao;

    @RequestMapping(value = "")

    public String index(Model model){
        return "homepage";
    }
}
