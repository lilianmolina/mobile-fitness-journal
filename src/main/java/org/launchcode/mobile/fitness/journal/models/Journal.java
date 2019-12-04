package org.launchcode.mobile.fitness.journal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Journal {
    @Id
    @GeneratedValue
    private int id;

    public Journal(int id){
        this.id = id;
    }
}
