package com.labs.spring.rest.service;

import com.labs.spring.rest.model.Greeting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GreetingsServiceObjImpl implements GreetingsService1 {

    private Map<Integer, Greeting> greetings = new HashMap<>();

    @Override
    public int addGreeting(Greeting greeting) {
        int id = greetings.size() + 1;
        greetings.put(id, greeting);
        return id;
    }

    @Override
    public Optional<Greeting> getGreeting(int id) {
        Greeting greeting = greetings.get(id);
        return greeting != null ? Optional.of(greeting) : Optional.empty();    }

    @Override
    public Collection<Greeting> getAllGreetings() {
        return greetings.values();
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) {
        if(greetings.containsKey(id)) {
            greetings.put(id, greeting);
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
