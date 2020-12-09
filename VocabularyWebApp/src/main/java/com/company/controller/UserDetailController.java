package com.company.controller;

import com.company.entity.User;
import com.company.form.UserDetailForm;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET, value = "/userdetail")
    public ModelAndView index(@RequestParam(value = "id", required = false) Integer id) {

        User user = userService.getById(id);

        UserDetailForm udf = new UserDetailForm(
                user.getId(), user.getName(), user.getSurname(), user.getEmail(),
                user.getScore(), user.getPassword());

        ModelAndView mv = new ModelAndView("userdetail");
        mv.addObject("userd" , udf);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userdetail")
    public ModelAndView indexM(@Valid @ModelAttribute("userdetail") UserDetailForm u
        , @RequestParam("action" ) String action) {

        if (action.equals("update")) {

            Integer id = u.getId();
            String name = u.getName();
            String surname = u.getSurname();
            String email = u.getEmail();
            Integer score = u.getScore();
            String password = u.getPassword();

            User user = userService.getById(id);

            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setScore(score);
            user.setPassword(password);

            userService.updateUser(user);


        }else if(action.equals("delete")){
            Integer id = u.getId();
            userService.removeUser(id);
        }

        ModelAndView mv = new ModelAndView("users");
        List<User> list = userService.getAll(null, null, null);
        mv.addObject("user", new UserForm());
        mv.addObject("list", list);
        return mv;
    }

}
