package com.company.service.impl;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Eminov
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao")
    private UserRepositoryCustom userDao;

    @Override
    public List<User> getAll(String name, String surname, String email) {
        return userDao.getAll(name, surname, email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getById(int id) {

        return userDao.getById(id);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao.removeUser(id);
    }

}
