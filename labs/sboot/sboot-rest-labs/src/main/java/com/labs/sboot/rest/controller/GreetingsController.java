package com.labs.sboot.rest.controller;

import com.labs.sboot.rest.service.GreetingsService;
import com.labs.sboot.rest.service.GreetingsServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    GreetingsService service = new GreetingsServiceImpl();

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String home() {
        return "Welcome to Spring REST Training!!!";
    }

    @RequestMapping(path = "/greetings", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String greetings() {
        return "Welcome to BlueYonder!!!";
    }

//    @RequestMapping(path = "/greetings1", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public String greetingsWithParams(@RequestParam(name = "firstName", required = false) String firstName, @RequestParam(name = "lastName", required = false) String lastName) {
//        return "Hello " + firstName + " " + lastName + "! Welcome to BlueYonder!!!";
//    }

//    @RequestMapping(path = "/greetings", method = RequestMethod.POST)
//    public String greetingWithPost(@RequestBody String message) {
//        return message;
//    }

//    @RequestMapping(path = "/greetings/{type}", method = RequestMethod.PUT)
//    public String greetingsWithPut(@PathVariable(name = "type", required = true) String type, @RequestBody String message) {
//        String greetings = switch (type) {
//            case "welcome" -> message + " Welcome to FSD Training!!!";
//            case "farewell" -> "Thanks!!! " + message + " Best Wishes!!!";
//            default -> "Better Luck next time";
//        };
//        return greetings;
//    }

    // POST /greetings
    @RequestMapping(path = "/greetings", method = RequestMethod.POST)
    public String greetingWithPost(@RequestBody String message) {
        return String.valueOf(service.addGreeting(message));
    }

    // GET /greetings/{id}
    @RequestMapping(path = "/greetings/{id}", method = RequestMethod.GET)
    public String greetingWithGet(@PathVariable(name = "id", required = true) int id) {
        return service.getGreeting(id).toUpperCase();
    }

    // PUT /greetings/{id}
    @RequestMapping(path = "/greetings/{id}", method = RequestMethod.PUT)
    public String greetingsWithPut(@PathVariable(name = "id", required = true) int id, @RequestBody String message) {
        return service.updateGreeting(id, message) ? "Update Successfull!!!" : "Update Failed!!!";
    }

    // DELETE /greetings/{id}
    @RequestMapping(path = "/greetings/{id}", method = RequestMethod.DELETE)
    public String greetingsWithDelete(@PathVariable(name = "id", required = true) int id) {
        return service.deleteGreeting(id) ? "Delete Successfull!!!" : "Delete Failed!!!";
    }


}
