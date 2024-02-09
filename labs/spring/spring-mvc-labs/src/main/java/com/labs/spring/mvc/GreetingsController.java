package com.labs.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

//    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
//    public String greetings(Model model) {
//        String msg = "Hello! Welcome to BlueYonder!!!";
//        model.addAttribute("msg", msg);
//        return "greetings";
//    }

//    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
//    public String greetings(Model model, @RequestParam(name= "name", defaultValue = "Anil", required = false) String name) {
//        String msg = "Hello " + name + "! Welcome to BlueYonder!!!";
//        model.addAttribute("msg", msg);
//        return "greetings";
//    }

    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
    public String greetings(Model model, @RequestParam(name= "firstName", defaultValue = "Anil", required = false) String firstName, @RequestParam(name= "lastName", defaultValue = "Anil", required = false) String lastName) {
        String msg = "Hello " + firstName + " " + lastName + "! Welcome to BlueYonder!!!";
        model.addAttribute("msg", msg);
        return "greetings";
    }
}
