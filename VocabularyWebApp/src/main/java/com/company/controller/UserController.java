package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String email = request.getParameter("email");
//
//        List<User> list = userService.getAll(name,surname,email);
//
//        request.setAttribute("list",list);
//
//        return "users" ;
//    }

    @RequestMapping(method = RequestMethod.GET , value = "/users")
    public ModelAndView index(
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "surname" , required = false) String surname,
            @RequestParam(value = "email" , required = false) String email){

        List<User> list = userService.getAll(name, surname, email);

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("list",list);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/usersm")
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm u , BindingResult bindingResult){
        ModelAndView mv = new ModelAndView("users");
        if(bindingResult.hasErrors()){
            List<User> list = userService.getAll(null,null,null);
            mv.addObject("list",list);
            return mv;
        }
        List<User> list = userService.getAll(u.getName(), u.getSurname(), u.getEmail());
        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/login" )
    public String login(){
        return "login";
    }


    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm(null,null,null);
    }


}
