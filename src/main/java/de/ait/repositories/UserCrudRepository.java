package de.ait.model.repositories;

import de.ait.model.User;

import java.util.List;

public interface UserCrudRepository extends CrudRepository <User> {
    public List<User> findUserByStartingName(String prefix);
}
