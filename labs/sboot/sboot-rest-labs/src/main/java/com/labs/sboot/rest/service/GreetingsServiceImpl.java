package com.labs.sboot.rest.service;

import java.util.HashMap;
import java.util.Map;

public class GreetingsServiceImpl implements GreetingsService{

    private Map<Integer, String> greetings = new HashMap<>();

    @Override
    public int addGreeting(String message) {
        int id = greetings.size() + 1;
        greetings.put(id, message);
        return id;
    }

    @Override
    public String getGreeting(int id) {
        String msg = greetings.get(id);
        return msg;
//        return msg != null && !msg.isBlank() ? msg : "No matching greetings found";
    }

    @Override
    public boolean updateGreeting(int id, String message) {
        if(greetings.containsKey(id)) {
            greetings.put(id, message);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGreeting(int id) {
        if(greetings.containsKey(id)) {
            greetings.remove(id);
            return true;
        }
        return false;
    }
}
