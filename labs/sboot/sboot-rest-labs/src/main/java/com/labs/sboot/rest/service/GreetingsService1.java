package com.labs.sboot.rest.service;

import com.labs.sboot.rest.exception.GreetingsAppException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;

import java.util.Collection;
import java.util.Optional;

public interface GreetingsService1 {

    public int addGreeting(Greeting greeting) throws GreetingsAppException;
    public Optional<Greeting> getGreeting(int id) throws GreetingsAppException, NoGreetingsFoundException;
    public Collection<Greeting> getAllGreetings();

    public boolean updateGreeting(int id, Greeting greeting);

    public boolean deleteGreeting(int id);
}
