package org.launchcode.mobile.fitness.journal.models.data;

import org.launchcode.mobile.fitness.journal.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

}
