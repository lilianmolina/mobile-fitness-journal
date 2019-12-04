package org.launchcode.mobile.fitness.journal.models;

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

}
