package com.company.service;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao")
    UserRepositoryCustom userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        if (user != null) {

            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);

            builder.disabled(false);
            builder.password(user.getPassword());

            List<String> list = userRepo.getGroup(user.getId());
            System.out.println("user id = "+user.getId());
            System.out.println("size="+list.size());
            String[] a =new String[list.size()];

            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
                a[i]=list.get(i);
            }

            System.out.println(a);
            builder.authorities(a);

            return builder.build();
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
