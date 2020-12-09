package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Group1;
import com.company.entity.GroupUser;
import com.company.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eminov
 */
@Repository("userDao")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll(String name, String surname, String email) {
        String jpql = "select u from User u where 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }

        if (email != null && !email.trim().isEmpty()) {
            jpql += " and u.email=:email ";
        }

        Query q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }

        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }

        if (email != null && !email.trim().isEmpty()) {
            q.setParameter("email", email);
        }

        return q.getResultList();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {

        Query q = em.createQuery("select u from User u where u.email=:email and u.password=:password", User.class);
        q.setParameter("email", email);
        q.setParameter("password", password);

        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {

        Query q = em.createQuery("select u from User u where u.email=:email", User.class);
        q.setParameter("email", email);

        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getById(int id) {

        Query q = em.createQuery("select u from User u where u.id=:id", User.class);
        q.setParameter("id", id);

        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    public static BCrypt.Hasher crypt = BCrypt.withDefaults();

    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean addUser(User u) {
//        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);

        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);

        return true;
    }

    @Override
    public List<String> getGroup(int id) {
//        Query q = em.createQuery(" select u from GroupUser u where u.userId=:id", GroupUser.class);
        String jpql = "SELECT " +
                " m.* " +
                " FROM " +
                " group_user g " +
                " LEFT JOIN `group` m ON g.group_id = m.id " +
                " WHERE " +
                " g.user_id = ? ";

        Query q = em.createNativeQuery(jpql, Group1.class);


        q.setParameter(1, id);

        List<Group1> list = q.getResultList();

        List<String> l = new ArrayList<>();

        for(Group1 g : list){
            l.add(g.getName());
        }

        return l;
    }



}
