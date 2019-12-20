package org.launchcode.mobile.fitness.journal.controllers;

import org.launchcode.mobile.fitness.journal.models.Workout;
import org.launchcode.mobile.fitness.journal.models.data.WorkoutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "workout")
public class WorkoutJournalController {

    @Autowired
    private WorkoutDao workoutDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String workout(Model model) {

        model.addAttribute("workout", workoutDao.findAll());

        return "workout";
    }

}

