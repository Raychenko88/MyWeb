package org.example.service;

import org.example.dao.ItemDAO;
import org.example.dao.UserDAO;
import org.example.model.User;

import java.util.List;

public class UserService {

    public static User create(User user){
    if (UserDAO.findByLogin(user.getLogin()) != null){
        UserDAO.create(user);
        return user;
    }
    return null;
    }

    public static User update(User user){
        if (UserDAO.findById(user.getId()) != null){
            UserDAO.update(user);
            return user;
        }
        return null;
    }

    public static void delete(Integer id){
        UserDAO.delete(id);
    }

    public static List<User> findAllUsers(){
        return UserDAO.findAll();
    }

    public static User findById(Integer id){
        return UserDAO.findById(id);
    }

    public static User findByLogin(User user){
       return UserDAO.findByLogin(user.getLogin());
    }
}
