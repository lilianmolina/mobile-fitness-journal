package org.launchcode.mobile.fitness.journal.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Workout {
    @Id
    @GeneratedValue
    private int id;

    public Workout(int id) {
        this.id = id;
    }

    @NotNull
    private String musclegroup;

    @NotNull
    private String exercise;


    public Workout(String musclegroup, String exercise) {
        this.musclegroup = musclegroup;
        this.exercise = exercise;
    }

    public Workout() {
    }

    public String getMusclegroup() {
        return musclegroup;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

}

