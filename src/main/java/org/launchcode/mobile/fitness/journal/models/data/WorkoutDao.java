package org.launchcode.mobile.fitness.journal.models.data;

import org.launchcode.mobile.fitness.journal.models.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WorkoutDao extends CrudRepository<Workout, Integer> {
}
