package com.labs.spring.rest.service;

import com.labs.spring.rest.model.Greeting;

import java.util.Collection;
import java.util.Optional;

public interface GreetingsService1 {

    public int addGreeting(Greeting greeting);
    public Optional<Greeting> getGreeting(int id);
    public Collection<Greeting> getAllGreetings();

    public boolean updateGreeting(int id, Greeting greeting);

    public boolean deleteGreeting(int id);
}
