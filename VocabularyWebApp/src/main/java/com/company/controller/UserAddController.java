package com.company.controller;

import com.company.entity.User;
import com.company.form.UserDetailForm;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserAddController {

    @Autowired
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET, value = "/adduser")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("adduser");
        mv.addObject("useradd", new UserDetailForm());

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adduser")
    public ModelAndView indexM(@Valid @ModelAttribute("useradd") UserDetailForm u ,
                               BindingResult bindingResult) {

        if(!bindingResult.hasErrors()) {
            String name = u.getName();
            String surname = u.getSurname();
            String email = u.getEmail();
            Integer score = u.getScore();
            String password = u.getPassword();

            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setScore(score);
            user.setPassword(password);

            userService.addUser(user);
        }

        ModelAndView mv = new ModelAndView("users");
        List<User> list = userService.getAll(null, null, null);
        mv.addObject("useradd", new UserForm());
        mv.addObject("list", list);
        return mv;
    }

}
