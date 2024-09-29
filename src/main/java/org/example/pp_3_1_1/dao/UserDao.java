package org.example.pp_3_1_1.dao;

//import web.model.User;

import org.example.pp_3_1_1.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    User get(Long id);

    void update(Long id, User user);

    void delete(Long id);

    List<User> listUsers();
}
